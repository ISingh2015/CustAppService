/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.dao.impl;

import com.cust.common.ApplicationException;
import com.cust.domain.dao.PreferenceDao;
import com.cust.domain.vo.PreferenceVO;
import java.io.Serializable;
import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ISanhot
 */
public class PreferenceDaoImpl implements PreferenceDao, Serializable {

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(PreferenceDaoImpl.class);

    @Autowired
    private PreferenceVO preferenceVO;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ArrayList<PreferenceVO> getServiceNames(long compId) throws ApplicationException {
        ArrayList<PreferenceVO> preferenceVOList = new ArrayList<>();
        preferenceVO.setPreference(getPreferenceVO().getPreference());
        preferenceVOList.add(preferenceVO);
        if (logger.isDebugEnabled()) logger.debug("getServiceNames " + compId) ;
        return preferenceVOList;
    }

    @Override
    public ArrayList<PreferenceVO> getServiceConstants(long compId) throws ApplicationException {
        ArrayList<PreferenceVO> preferenceVOList = new ArrayList<>();
        preferenceVO.setPreference(getPreferenceVO().getConstants());
        preferenceVOList.add(preferenceVO);
        if (logger.isDebugEnabled()) logger.debug("getServiceConstants " + compId); 
        return preferenceVOList;

    }

    /**
     * @return the preferenceVO
     */
    public PreferenceVO getPreferenceVO() {
        return preferenceVO;
    }

    /**
     * @param preferenceVO the preferenceVO to set
     */
    public void setPreferenceVO(PreferenceVO preferenceVO) {
        this.preferenceVO = preferenceVO;
    }

}
