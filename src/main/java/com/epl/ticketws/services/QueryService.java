package com.epl.ticketws.services;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
@Configuration("classpath:application.properties")
public class QueryService<T> {
    
	@Value("${app.onebox.user}")    		  
    private String user;
    
    @Value("${app.onebox.password}")
    private String password;
    
    @Value("${app.onebox.terminal}")
    private String terminal;
    
    @Value("${app.onebox.license}")
    private String license;
    
    @Value("${app.onebox.channel}")
    private String channel;
    
    @Value("${app.onebox.pos}")
    private String pos;
    
    private static final Logger logger = Logger.getLogger(QueryService.class);
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    private static final String UTF_8 = "UTF-8";
    private static final String PARAM_NAME_VALUE_SEPARATOR = "=";
    private static final String HMAC_FIELD_SEPARATOR = "\n";
    private static final String URI_PARAMETERS_SEPARATOR = "?";
    private static final String PARAMETERS_SEPARATOR = "&";
    private static final String AUTHORIZATION_HEADER_HMAC_PREFIX = "OB_HMAC ";
    
    public T query(String url, String method, Class<T> rc){
    	return query( url, method, rc, null);
    }
    
    public T query(String url, String method, Class<T> rc, Map<String, String> parameters) {                
    	logger.info("user: "+user);    	
    	logger.info("terminal "+terminal);
    	logger.info("license "+license);
    	logger.info("terminal "+terminal);
        try {            
            URI uri = new URL(url).toURI();            
            long timestamp = new Date().getTime();

            HttpMethod httpMethod;
            httpMethod = HttpMethod.GET;
            if (method.equalsIgnoreCase("post")) 
                httpMethod = HttpMethod.POST;             
            
            String stringToSign = getStringToSign(uri, httpMethod.name(), timestamp);

            logger.info("String to sign: " + stringToSign);            
            String authorization = generate_HMAC_SHA1_Signature(stringToSign,password + license);
            logger.info("Authorization string: " + authorization);
            
            // Setting Headers
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.TEXT_XML));            

            headers.add("Authorization", authorization);
            headers.add("OB_DATE", ""+timestamp);
            headers.add("OB_Terminal", terminal);
            headers.add("OB_User", user);
            headers.add("OB_Channel", channel);
            headers.add("OB_POS", pos);

            HttpEntity<String> entity;

            if (httpMethod == HttpMethod.POST) {
                // Adding post parameters to POST body
            	String parameterStringBody = getParametersAsString(parameters);
                entity = new HttpEntity<String>(parameterStringBody, headers);
                logger.info("POST Body: " + parameterStringBody);
            } else {
                entity = new HttpEntity<String>(headers);
            }

            RestTemplate restTemplate = new RestTemplate();

            // Converting to UTF-8. OB Rest replies in windows charset.
            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(UTF_8)));
            
            /**
            ResponseEntity<String> responseStr = restTemplate.exchange(uri, httpMethod, entity, String.class);
            logger.info(responseStr.toString());
            **/
            
            restTemplate.getMessageConverters().add(0, new org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter());
            ResponseEntity<T> response = restTemplate.exchange(uri, httpMethod, entity, rc);
             
            if (!response.getStatusCode().is2xxSuccessful())
            	throw new HttpClientErrorException(response.getStatusCode());
            
            return response.getBody();	            
        } catch (HttpClientErrorException e) {
            logger.error(e.getMessage());
            e.printStackTrace();            
        } catch (MalformedURLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();            
        } catch (SignatureException e) {
            logger.error(e.getMessage());
            e.printStackTrace();            
        } catch (URISyntaxException e) {
            logger.error(e.getMessage());
            e.printStackTrace();            
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();            
        }             
        return null;
    }

    /**
     * This method generates the string to be signed based on the following rules:
     *
     *  - Add the request method + \n
     *  - Add the timestamp + \n
     *  - Add the request URI
     *  - For each request parameter ordered alphabetically:
     *    - First parameter delimiter ?
     *    - Other parameters separated by &
     *    - Name of the parameter
     *    - Add ´=´ sign
     *    - value of the parameter
     *
     * For example:
     *
     *   Given a GET request with timestamp = 1316430943576 and uri = /uri_path/ejemplo with parameters,
     *     Bc = 'Prueba1'
     *     Aa = 'Prueba2'
     *     bc = 'aPrueba3'
     *     z1 = 'prueba4'
     *
     *   The String to sign is:
     *
     *     GET\n1316430943576\n/uri_path/ejemplo?amp;Aa=Prueba2&bc=aPrueba3&Bc=Prueba1&z1=prueba4
     *
     * @param uri
     * @param method
     * @param timestamp
     * @return
     * @throws SignatureException
     */
    private String getStringToSign(URI uri,String method, long timestamp) throws SignatureException {

    	/*
    	 SortedMap<String,String> sortedMap = new TreeMap<String, String>();
        
        // Assuming GET. It actually processes URL parameters for all Method types
        if (uri.getRawQuery()!=null) {

            StringTokenizer tokenizer = null;
            try
            {
                tokenizer = new StringTokenizer(URLDecoder.decode(uri.getRawQuery(), UTF_8),AMPERSAND);
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            while(tokenizer.hasMoreElements())
            {
                String token = tokenizer.nextToken();
                sortedMap.put(token.split(PARAM_NAME_VALUE_SEPARATOR)[0].toLowerCase()+token.split(PARAM_NAME_VALUE_SEPARATOR)[1], token);
            }
        }

        // If POST process parameter map
        if(method.equals(HttpMethod.POST.name()))
        {
            for (String key : ((Set<String>)((MultiMap)queryForm.getFormParameters()).keySet())) {
                for (String valor : ((List<String>) ((MultiMap) queryForm.getFormParameters()).get(key))){
                    sortedMap.put(key.toLowerCase()+PARAM_NAME_VALUE_SEPARATOR+valor,key+ PARAM_NAME_VALUE_SEPARATOR +valor);
                }
            }
        }
*/
        // Generating String to sign
        StringBuilder stringToSign = new StringBuilder();
        stringToSign.append(method);
        stringToSign.append(HMAC_FIELD_SEPARATOR).append(timestamp);
        stringToSign.append(HMAC_FIELD_SEPARATOR).append(uri.getPath());
        stringToSign.append("?eventType=ACTIVITY");        
        return stringToSign.toString();
    }

    /**
     * Signs a string with the given key.
     *
     * @param data
     * @param key
     * @return
     * @throws SignatureException
     */
    private String generate_HMAC_SHA1_Signature(String data, String key) throws SignatureException
    {
        String result;
        try
        {
            // get an hmac_sha1 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(UTF_8), HMAC_SHA1_ALGORITHM);

            // get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);

            // compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(data.getBytes(UTF_8));
            //byte[] base64 = Base64.encodeBase64(rawHmac);
            byte[] base64 = Base64.getEncoder().encode(rawHmac);

            // base64-encode the hmac
            result = new String(base64);
        }
        catch (Exception e)
        {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }

        return AUTHORIZATION_HEADER_HMAC_PREFIX + result;
    }
    
    private String getParametersAsString(Map<String, String> params){
    	String result = "";
    	boolean isFirst = true;
    	for (Entry<String,String> entry:params.entrySet()){
    		String key = entry.getKey();
    		String value = entry.getValue();
    		if (isFirst){
    			result += URI_PARAMETERS_SEPARATOR+key+PARAM_NAME_VALUE_SEPARATOR+value;
    			isFirst= false;
    		} else
    			result += PARAMETERS_SEPARATOR +key+PARAM_NAME_VALUE_SEPARATOR+value;
    	}
    	return result;
    }
}

