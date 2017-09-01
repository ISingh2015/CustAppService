package com.cust.domain.webservice.impl;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.service.CustomerService;
import com.cust.domain.vo.ElegantCustomer;
import com.cust.domain.webservice.CustomerWebService;
import java.io.Serializable;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Inderjit
 */
public class CustomerWebServiceImpl implements CustomerWebService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CustomerService elegantCustomerService;

    @Override
    public ServicePayload getCustomerById(ServiceControl serviceControl, long compId, long custId) throws ApplicationException {
        ServicePayload servicePayload = elegantCustomerService.getCustomerById(serviceControl, compId,custId);
        return servicePayload;
    }

    @Override
    public ServicePayload getAllCustomers(ServiceControl serviceControl, long compId) throws ApplicationException {
        ServicePayload servicePayload = elegantCustomerService.getAllCustomers(serviceControl, compId);
        return servicePayload;
    }

    @Override
    public ServicePayload saveCustomerList(ServiceControl serviceControl, ArrayList<ElegantCustomer> custList) throws ApplicationException {
        ServicePayload servicePayload = elegantCustomerService.saveCustomerList(serviceControl, custList);
        return servicePayload;

    }

    @Override
    public ServicePayload deleteCustomerList(ServiceControl serviceControl, ArrayList<ElegantCustomer> custList) throws ApplicationException {
        ServicePayload servicePayload = elegantCustomerService.deleteCustomerList(serviceControl, custList);
        return servicePayload;
    }

}
