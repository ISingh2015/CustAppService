/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.webservice.impl;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.service.SupplierService;
import com.cust.domain.vo.ElegantSupplier;
import com.cust.domain.webservice.SupplierWebService;
import java.io.Serializable;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Inderjit
 */
public class SupplierWebServiceImpl implements SupplierWebService,Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private SupplierService elegantSupplierService;

    @Override
    public ServicePayload getSupplierById(ServiceControl serviceControl, long compId, long supId) throws ApplicationException {
        ServicePayload servicePayload = elegantSupplierService.getSupplierById(serviceControl, compId, supId);
        return servicePayload;
    }

    @Override
    public ServicePayload getAllSuppliers(ServiceControl serviceControl, long compId) throws ApplicationException {
        ServicePayload servicePayload = elegantSupplierService.getAllSuppliers(serviceControl, compId);
        return servicePayload;

    }

    @Override
    public ServicePayload saveSupplierList(ServiceControl serviceControl, ArrayList<ElegantSupplier> supList) throws ApplicationException {
        ServicePayload servicePayload = elegantSupplierService.saveSupplierList(serviceControl, supList);
        return servicePayload;
    }

    @Override
    public ServicePayload deleteSupplierList(ServiceControl serviceControl, ArrayList<ElegantSupplier> supList) throws ApplicationException {
        ServicePayload servicePayload = elegantSupplierService.deleteSupplierList(serviceControl, supList);
        return servicePayload;
    }
    
}
