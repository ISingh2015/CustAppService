package com.cust.domain.webservice.impl;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.service.ProductService;
import com.cust.domain.vo.ElegantProduct;
import com.cust.domain.webservice.ProductWebService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Inderjit
 */
public class ProductWebServiceImpl implements ProductWebService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ProductService elegantProductService;

    @Override
    public ServicePayload getProductById(ServiceControl serviceControl, long compId, long prodId) throws ApplicationException {
        ServicePayload servicePayload = elegantProductService.getProductById(serviceControl, compId, prodId);
        return servicePayload;
    }

    @Override
    public ServicePayload getAllProducts(ServiceControl serviceControl, long compId) throws ApplicationException {
        ServicePayload servicePayload = elegantProductService.getAllProducts(serviceControl, compId);
        return servicePayload;
    }

    @Override
    public ServicePayload saveProductList(ServiceControl serviceControl, ArrayList<ElegantProduct> prodList) throws ApplicationException {
        ServicePayload servicePayload = elegantProductService.saveProductList(serviceControl, prodList);
        return servicePayload;
    }

    @Override
    public ServicePayload deleteProductList(ServiceControl serviceControl, ArrayList<ElegantProduct> prodList) throws ApplicationException {
        ServicePayload servicePayload = elegantProductService.deleteProductList(serviceControl, prodList);
        return servicePayload;
    }

    @Override
    public ServicePayload getProductStockById(ServiceControl serviceControl, long compId, long prodId, long currBill) throws ApplicationException {
        ServicePayload servicePayload = elegantProductService.getProductStockById(serviceControl, compId, prodId, currBill);
        return servicePayload;
    }

}
