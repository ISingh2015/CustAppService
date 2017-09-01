/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.webservice;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.vo.ElegantProduct;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Inderjit
 */
public interface ProductWebService {

    public ServicePayload getProductById(ServiceControl serviceControl, long compId, long prodId) throws ApplicationException;

    public ServicePayload getAllProducts(ServiceControl serviceControl, long compId) throws ApplicationException;

    public ServicePayload saveProductList(ServiceControl serviceControl, ArrayList<ElegantProduct> prodList) throws ApplicationException;

    public ServicePayload deleteProductList(ServiceControl serviceControl, ArrayList<ElegantProduct> prodList) throws ApplicationException;
    
    public ServicePayload getProductStockById(ServiceControl serviceControl, long compId, long prodId, long currBill) throws ApplicationException;    
}
