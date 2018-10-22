package com.inderjit.controller;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Inderjit Singh Sanhotra
 */
public class PropertiesCache {

    Logger logger = LoggerFactory.getLogger(PropertiesCache.class);
    private PropertiesConfiguration configProp = null;

    //Private constructor to restrict new instances
    private PropertiesCache() {
        try {
            configProp = new PropertiesConfiguration("common.properties");
            logger.info(this.getClass().getName() + ": " + "Created ");
        } catch (ConfigurationException ce) {
            ce.printStackTrace();
        }
    }

    private static class LazyHolder {

        private static final PropertiesCache INSTANCE = new PropertiesCache();
    }

    public static PropertiesCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key) {
        String value = null;
        if (configProp.containsKey(key)) {
            value = configProp.getString(key);
        }
        return value;
    }

    public void setProperty(String key, String value) {
        if (configProp.containsKey(key)) {
            configProp.setProperty(key, value);
        }
    }

    public synchronized boolean saveSetting() {
        logger.info(this.getClass().getName() + ": " + "Saving " + configProp.getFileName());
        boolean saved = false;
        try {
            configProp.save();
            saved = true;
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return saved;
    }
}
