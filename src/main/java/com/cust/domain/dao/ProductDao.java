package com.cust.domain.dao;

import java.util.ArrayList;
import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.domain.vo.ElegantProduct;
import java.util.Date;
/**
 * 
 * @author Inderjit
 */
public interface ProductDao {

    public ElegantProduct getProductById(long compId, long prodId) throws ApplicationException;

    public ArrayList<ElegantProduct> getAllProducts(ServiceControl serviceControl, long compId) throws ApplicationException;

    public ArrayList<ElegantProduct> saveProductList(ArrayList<ElegantProduct> productList) throws ApplicationException;

    public Boolean deleteProductList(ArrayList<ElegantProduct> productList) throws ApplicationException;
    
    public Double getProductStockById(long compId, long prodId, long currBill) throws ApplicationException;
    
}
