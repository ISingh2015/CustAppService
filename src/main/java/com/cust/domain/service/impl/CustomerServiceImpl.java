package com.cust.domain.service.impl;

import java.util.ArrayList;
import com.cust.common.ApplicationException;
import com.cust.common.ResponseMetaData;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.dao.CustomerDao;
import com.cust.domain.service.CustomerService;
import com.cust.domain.vo.ElegantCustomer;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Inderjit
 */
public class CustomerServiceImpl implements CustomerService, Serializable {

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerDao elegantCustomerDao;

    @Override
    public ServicePayload getCustomerById(ServiceControl serviceControl, long compId, long custId) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ElegantCustomer elegantCustomer;
        elegantCustomer = elegantCustomerDao.getCustomerById(compId, custId);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantCustomer);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload getAllCustomers(ServiceControl serviceControl, long compId) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        List<ElegantCustomer> elegantCustomerList;
        elegantCustomerList = elegantCustomerDao.getAllCustomers(serviceControl, compId);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantCustomerList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload saveCustomerList(ServiceControl serviceControl, ArrayList<ElegantCustomer> custList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        custList = elegantCustomerDao.saveCustomerList(custList);
        List<Object> objectList = new ArrayList<>();
        objectList.add(custList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload  deleteCustomerList(ServiceControl serviceControl, ArrayList<ElegantCustomer> custList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        Boolean deleted = elegantCustomerDao.deleteCustomerList(custList);
        List<Object> objectList = new ArrayList<>();
        objectList.add(deleted);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }
}
