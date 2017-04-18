package com.epl.ticketws.services;




import com.epl.tickets.model.InformeCrearRespuesta;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.commons.io.IOUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.Locale;
import java.util.Map;


/**
 * Created by gcortes on 07/04/2017.
 */
public class ThymeleafEngine {

    private static TemplateEngine webTemplate;

    public static String getContentFrom(ThymeleafContext context) {
        if (webTemplate == null){
            webTemplate = createEngine("templates/");
        }
        final Context ctx = new Context(context.getLocale());
        for (Map.Entry<String, Object> variable : context.getThymleafProperties().entrySet()) {
            ctx.setVariable(variable.getKey(), variable.getValue());
        }

        return webTemplate.process(context.getThymeleafTemplate(), ctx);
    }

    private static  TemplateEngine createEngine(String path) {
        ClassLoaderTemplateResolver templateresolver = new ClassLoaderTemplateResolver();
        templateresolver.setPrefix(path);
        templateresolver.setTemplateMode(TemplateMode.HTML);
        templateresolver.setCharacterEncoding("UTF-8");
        templateresolver.setSuffix(".html");
        templateresolver.setCacheable(true);//De esta manera en local podemos recargar en caliente

        TemplateEngine newTemplateEngine = new TemplateEngine();
        newTemplateEngine.addDialect(new Java8TimeDialect());
        newTemplateEngine.setTemplateResolver(templateresolver);

        return newTemplateEngine;
    }




    public static void main(String args[]){
        try{

            ThymeleafContext context = new ThymeleafContext(Locale.ENGLISH);
            InputStream inputStream = ThymeleafEngine.class.getResourceAsStream("/images/barcode.png");
            String qrImage = Base64.encode(IOUtils.toByteArray(inputStream));
            context.setThymeleafTemplate("voucher");
            InformeCrearRespuesta informeCrearRespuesta = new InformeCrearRespuesta();
            informeCrearRespuesta.getInfpdf().add(qrImage);
            informeCrearRespuesta.getInfpdf().add(qrImage);
            context.addThymeleafPropertyIfAbsent("tickets", informeCrearRespuesta);
            String response =getContentFrom(context);

            System.out.println(response);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



}
