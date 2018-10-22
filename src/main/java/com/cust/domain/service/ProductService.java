package com.cust.domain.service;

import java.util.ArrayList;
import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.vo.ElegantProduct;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author Inderjit
 */
@Service("productService")
public interface ProductService {

    public ServicePayload getProductById(ServiceControl serviceControl, long compId, long prodId) throws ApplicationException;

    public ServicePayload getAllProducts(ServiceControl serviceControl, long compId) throws ApplicationException;

    public ServicePayload saveProductList(ServiceControl serviceControl, ArrayList<ElegantProduct> prodList) throws ApplicationException;

    public ServicePayload  deleteProductList(ServiceControl serviceControl, ArrayList<ElegantProduct> prodList) throws ApplicationException;

    public ServicePayload getProductStockById(ServiceControl serviceControl, long compId, long prodId, long currBill) throws ApplicationException;
}
