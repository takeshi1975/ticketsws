package com.epl.ticketws.services;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.zefer.cache.ResourceProvider;

/**
 * Created by gcortes on 24/04/2017.
 */
public class CustomPd4mlProvider extends ResourceProvider {

    public byte[] getResourceAsBytes(String resource, boolean debugOn) {
        try {

            if ( resource == null || !(resource.toLowerCase().endsWith(".jpeg") || resource.toLowerCase().endsWith(".jpg") )
                    || resource.toLowerCase().endsWith(".png") ) {
                return null;
            }


            resource = resource.substring(resource.indexOf(":")+1);
            InputStream is =   this.getClass().getResourceAsStream("/templates/" + resource);

            return IOUtils.toByteArray(is);

        } catch (Exception e) {
            return null;
        }
    }


}



