/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.service.impl;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.domain.dao.PreferenceDao;
import com.cust.domain.service.PreferenceService;
import com.cust.domain.vo.PreferenceVO;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ISanhot
 */
public class PreferenceServiceImpl implements PreferenceService {

    @Autowired
    private PreferenceDao elegantPreferenceDao;

    @Override
    public ArrayList<PreferenceVO> getServiceNames(ServiceControl serviceControl, long compId) throws ApplicationException {
        ArrayList<PreferenceVO> preferenceList = getElegantPreferenceDao().getServiceNames(compId);
        return preferenceList;
    }

    @Override
    public ArrayList<PreferenceVO> getServiceConstants(ServiceControl serviceControl, long compId) throws ApplicationException {
        ArrayList<PreferenceVO> preferenceList = getElegantPreferenceDao().getServiceNames(compId);
        return preferenceList;

    }

    /**
     * @return the elegantPreferenceDao
     */
    public PreferenceDao getElegantPreferenceDao() {
        return elegantPreferenceDao;
    }

    /**
     * @param elegantPreferenceDao the elegantPreferenceDao to set
     */
    public void setElegantPreferenceDao(PreferenceDao elegantPreferenceDao) {
        this.elegantPreferenceDao = elegantPreferenceDao;
    }


}
