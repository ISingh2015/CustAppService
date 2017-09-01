/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.service.impl;

import com.cust.common.ApplicationException;
import com.cust.common.ResponseMetaData;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.dao.CountryDao;
import com.cust.domain.service.CountryService;
import com.cust.domain.vo.ElegantCountry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Inderjit
 */
public class CountryServiceImpl implements CountryService,Serializable{

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CountryDao elegantCountryDao;

    @Override
    public ServicePayload getCountryById(ServiceControl serviceControl, int countryId) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ElegantCountry elegantCountry;
        elegantCountry = elegantCountryDao.getCountryById(countryId);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantCountry);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }

    @Override
    public ServicePayload getAllCountries(ServiceControl serviceControl) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantCountry> elegantCountryList;
        elegantCountryList = elegantCountryDao.getAllCountries(serviceControl);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantCountryList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }

    @Override
    public ServicePayload saveCountryList(ServiceControl serviceControl, ArrayList<ElegantCountry> countryList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantCountry> elegantCountryList;
        elegantCountryList = elegantCountryDao.saveCountryList(countryList);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantCountryList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload  deleteCountryList(ServiceControl serviceControl, ArrayList<ElegantCountry> countryList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantCountry> elegantCountryList;
        Boolean deleted = elegantCountryDao.deleteCountryList(countryList);
        List<Object> objectList = new ArrayList<>();
        objectList.add(deleted);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    
}
