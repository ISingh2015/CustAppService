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
import com.cust.domain.dao.SupplierDao;
import com.cust.domain.service.SupplierService;
import com.cust.domain.vo.ElegantSupplier;
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
public class SupplierServiceImpl implements SupplierService, Serializable{

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(SupplierServiceImpl.class);

    @Autowired
    private SupplierDao elegantSupplierDao;

    @Override
    public ServicePayload getSupplierById(ServiceControl serviceControl,long compId, long supId) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ElegantSupplier elegantSupplier;
        elegantSupplier = elegantSupplierDao.getSupplierById(compId, supId);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantSupplier);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }

    @Override
    public ServicePayload getAllSuppliers(ServiceControl serviceControl, long compId) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantSupplier> elegantSupplierList;
        elegantSupplierList = elegantSupplierDao.getAllSuppliers(serviceControl, compId);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantSupplierList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }

    @Override
    public ServicePayload saveSupplierList(ServiceControl serviceControl,ArrayList<ElegantSupplier> supList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        supList = elegantSupplierDao.saveSupplierList(supList);
        List<Object> objectList = new ArrayList<>();
        objectList.add(supList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }

    @Override
    public ServicePayload deleteSupplierList(ServiceControl serviceControl,ArrayList<ElegantSupplier> supList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        Boolean deleted = elegantSupplierDao.deleteSupplierList(supList);
        List<Object> objectList = new ArrayList<>();
        objectList.add(deleted);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
        
    }
    
}
