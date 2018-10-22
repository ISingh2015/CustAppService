package com.cust.domain.webservice.impl;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.service.SalesManService;
import com.cust.domain.vo.ElegantSalesMan;
import com.cust.domain.webservice.SalesManWebService;
import java.io.Serializable;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Inderjit
 */
public class SalesManWebServiceImpl implements SalesManWebService, Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    private SalesManService salesManService;

    @Override
    public ServicePayload getSalesManById(ServiceControl serviceControl, long compId, long salesManId) throws ApplicationException {
        ServicePayload servicePayload = salesManService.getSalesManById(serviceControl, compId, salesManId);
        return servicePayload;
    }

    @Override
    public ServicePayload getAllSalesMan(ServiceControl serviceControl,long compId) throws ApplicationException {
        ServicePayload servicePayload = salesManService.getAllSalesMan(serviceControl,compId);
        return servicePayload;

    }

    @Override
    public ServicePayload saveSalesManList(ServiceControl serviceControl, ArrayList<ElegantSalesMan> salesManList) throws ApplicationException {
        ServicePayload servicePayload = salesManService.saveSalesManList(serviceControl, salesManList);
        return servicePayload;

    }

    @Override
    public ServicePayload deleteSalesManList(ServiceControl serviceControl, ArrayList<ElegantSalesMan> salesManList) throws ApplicationException {
        ServicePayload servicePayload = salesManService.deleteSalesManList(serviceControl, salesManList);
        return servicePayload;
    }

}
