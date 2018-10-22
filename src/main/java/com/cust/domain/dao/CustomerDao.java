package com.cust.domain.dao;

import java.util.ArrayList;
import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.domain.vo.ElegantCustomer;
import java.util.List;

/**
 *
 * @author Inderjit
 */
public interface CustomerDao {

    public ElegantCustomer getCustomerById(long compId, long custId) throws ApplicationException;

    public List<ElegantCustomer> getAllCustomers(ServiceControl serviceControl, long compId) throws ApplicationException;

    public ArrayList<ElegantCustomer> saveCustomerList(ArrayList<ElegantCustomer> custList) throws ApplicationException;

    public Boolean deleteCustomerList(ArrayList<ElegantCustomer> custList) throws ApplicationException;

}
