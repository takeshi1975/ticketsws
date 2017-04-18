package com.epl.ticketws.services;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by gcortes on 07/04/2017.
 */

public class ThymeleafContext {

    private String thymeleafTemplate;
    private Locale locale = Locale.ENGLISH;
    private Map<String, Object> properties = new HashMap<>();

    public ThymeleafContext(Locale locale) {
        this.locale = locale;
    }

    public ThymeleafContext addThymeleafProperty(String key, Object property) {
        this.properties.put(key, property);
        return this;
    }

    public ThymeleafContext addThymeleafPropertyIfAbsent(String key, Object property) {
        this.properties.putIfAbsent(key, property);
        return this;
    }

    public Locale getLocale() {
        return locale;
    }

    public Locale getLanguage() {
        return locale;
    }

    public Map<String, Object> getThymleafProperties() {
        return properties;
    }

    public String getThymeleafTemplate() {
        return thymeleafTemplate;
    }

    public void setThymeleafTemplate(String thymeleafTemplate) {
        this.thymeleafTemplate = thymeleafTemplate;
    }
}
