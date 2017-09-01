/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.service;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.vo.ElegantSupplier;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Inderjit
 */
@Service("supplierService")
public interface SupplierService {

    public ServicePayload getSupplierById(ServiceControl serviceControl, long compId, long supId) throws ApplicationException;

    public ServicePayload getAllSuppliers(ServiceControl serviceControl, long compId) throws ApplicationException;

    public ServicePayload saveSupplierList(ServiceControl serviceControl,ArrayList<ElegantSupplier> supList) throws ApplicationException;

    public ServicePayload deleteSupplierList(ServiceControl serviceControl,ArrayList<ElegantSupplier> supList) throws ApplicationException;
    
}
