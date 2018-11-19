package com.epam.task2.model;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String RESOURSE_NAME = "property.text";
    private ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(
                RESOURSE_NAME, Locale.US);
    }

    public void changeResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(
                RESOURSE_NAME, locale);
    }
    public String getString(String key) {
        return resourceBundle.getString(key);
    }
    public Enumeration getSetKey() {
        return resourceBundle.getKeys();
    }
}
