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
import com.cust.domain.dao.SalesManDao;
import com.cust.domain.service.SalesManService;
import com.cust.domain.vo.ElegantSalesMan;
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
public class SalesManServiceImpl implements SalesManService,Serializable{

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(SalesManServiceImpl.class);

    @Autowired
    private SalesManDao elegantSalesManDao;

    @Override
    public ServicePayload getSalesManById(ServiceControl serviceControl, long compId, long salesManId) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ElegantSalesMan elegantSalesMan;
        elegantSalesMan = elegantSalesManDao.getSalesManById(compId, salesManId);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantSalesMan);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }

    @Override
    public ServicePayload getAllSalesMan(ServiceControl serviceControl,long compId) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantSalesMan> elegantSalesManList;
        elegantSalesManList = elegantSalesManDao.getAllSalesMan(serviceControl,compId);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantSalesManList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }

    @Override
    public ServicePayload saveSalesManList(ServiceControl serviceControl, ArrayList<ElegantSalesMan> salesManList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantSalesMan> elegantSalesManList;
        elegantSalesManList = elegantSalesManDao.saveSalesManList(salesManList);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantSalesManList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload  deleteSalesManList(ServiceControl serviceControl, ArrayList<ElegantSalesMan> salesManList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantSalesMan> elegantSalesManList;
        Boolean deleted = elegantSalesManDao.deleteSalesManList(salesManList);
        List<Object> objectList = new ArrayList<>();
        objectList.add(deleted);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
        
        
    }

    
}
