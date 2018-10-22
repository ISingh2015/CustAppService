package com.cust.domain.dao;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.domain.vo.ElegantSupplier;
import java.util.ArrayList;

/**
 *
 * @author Inderjit
 */
public interface SupplierDao {

    public ElegantSupplier getSupplierById(long compId, long supId) throws ApplicationException;

    public ArrayList<ElegantSupplier> getAllSuppliers(ServiceControl serviceControl, long compId) throws ApplicationException;

    public ArrayList<ElegantSupplier> saveSupplierList(ArrayList<ElegantSupplier> supList) throws ApplicationException;

    public Boolean deleteSupplierList(ArrayList<ElegantSupplier> supList) throws ApplicationException;
    
}
