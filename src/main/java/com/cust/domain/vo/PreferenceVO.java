/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.vo;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author ISanhot
 */
public class PreferenceVO implements Serializable {

    private static final long serialVersionUID = 4173435938575881525L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    private Map<String,String[]> preference;
    private Map<String,String[]> constants;
    /**
     * @return the preference
     */
    public Map<String,String[]> getPreference() {
        return preference;
    }

    /**
     * @param preference the preference to set
     */
    public void setPreference(Map<String,String[]> preference) {
        this.preference = preference;
    }

    /**
     * @return the constants
     */
    public Map<String,String[]> getConstants() {
        return constants;
    }

    /**
     * @param constants the constants to set
     */
    public void setConstants(Map<String,String[]> constants) {
        this.constants = constants;
    }
}
