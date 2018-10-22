package com.cust.domain.service;

import java.util.ArrayList;
import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.vo.ElegantCustomer;
import org.springframework.stereotype.Service;

/**
 *
 * @author Inderjit
 */
@Service("customerService")
public interface CustomerService {

    public ServicePayload getCustomerById(ServiceControl serviceControl, long compId, long custId) throws ApplicationException;

    public ServicePayload getAllCustomers(ServiceControl serviceControl, long compId) throws ApplicationException;

    public ServicePayload saveCustomerList(ServiceControl serviceControl, ArrayList<ElegantCustomer> custList) throws ApplicationException;

    public ServicePayload  deleteCustomerList(ServiceControl serviceControl, ArrayList<ElegantCustomer> custList) throws ApplicationException;

}
