/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.webservice.impl;

import com.cust.common.ApplicationException;
import com.cust.common.ResponseMetaData;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.service.PreferenceService;
import com.cust.domain.vo.PreferenceVO;
import com.cust.domain.webservice.PreferenceWebService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ISanhot
 */
public class PreferenceWebServiceImpl implements PreferenceWebService {

    @Autowired
    private PreferenceService elegantPreferenceService;

    @Override
    public ServicePayload getServiceNames(ServiceControl serviceControl, long compId) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<PreferenceVO> preferenceVOList = elegantPreferenceService.getServiceNames(serviceControl, compId);
        List<Object> objectList = new ArrayList<>();
        objectList.add(preferenceVOList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }

    @Override
    public ServicePayload getServiceConstants(ServiceControl serviceControl, long compId) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<PreferenceVO> preferenceVOList = elegantPreferenceService.getServiceConstants(serviceControl, compId);
        List<Object> objectList = new ArrayList<>();
        objectList.add(preferenceVOList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }

    /**
     * @return the elegantPreferenceService
     */
    public PreferenceService getElegantPreferenceService() {
        return elegantPreferenceService;
    }

    /**
     * @param elegantPreferenceService the elegantPreferenceService to set
     */
    public void setElegantPreferenceService(PreferenceService elegantPreferenceService) {
        this.elegantPreferenceService = elegantPreferenceService;
    }


}
