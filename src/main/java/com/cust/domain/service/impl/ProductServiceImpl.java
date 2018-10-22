package com.cust.domain.service.impl;

import java.util.ArrayList;
import com.cust.common.ApplicationException;
import com.cust.common.ResponseMetaData;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.dao.ProductDao;
import com.cust.domain.service.ProductService;
import com.cust.domain.vo.ElegantProduct;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Inderjit
 */
public class ProductServiceImpl implements ProductService, Serializable {

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao elegantProductDao;

    @Override
    public ServicePayload getProductById(ServiceControl serviceControl, long compId, long prodId) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ElegantProduct elegantProduct;
        elegantProduct = elegantProductDao.getProductById(compId, prodId);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantProduct);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload getAllProducts(ServiceControl serviceControl, long compId) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantProduct> elegantProductList;
        elegantProductList = elegantProductDao.getAllProducts(serviceControl, compId);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantProductList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload saveProductList(ServiceControl serviceControl, ArrayList<ElegantProduct> prodList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        prodList = elegantProductDao.saveProductList(prodList);
        List<Object> objectList = new ArrayList<>();
        objectList.add(prodList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload  deleteProductList(ServiceControl serviceControl, ArrayList<ElegantProduct> prodList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        Boolean deleted = elegantProductDao.deleteProductList(prodList);
        List<Object> objectList = new ArrayList<>();
        objectList.add(deleted);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload getProductStockById(ServiceControl serviceControl, long compId, long prodId, long currBill) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        Double productStock=null;
        productStock = elegantProductDao.getProductStockById(compId, prodId,currBill);
        List<Object> objectList = new ArrayList<>();
        objectList.add(productStock);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }
}
