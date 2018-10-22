package com.cust.domain.service.impl;

import java.util.ArrayList;
import com.cust.common.ApplicationException;
import com.cust.common.ResponseMetaData;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.dao.BuySellDao;
import com.cust.domain.service.BuySellService;
import com.cust.domain.vo.ElegantBuySell;
import com.cust.domain.vo.ElegantBuySellConsolidation;
import com.cust.domain.vo.ElegantMailList;
import com.cust.domain.vo.ElegantMarketMail;
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
public class BuySellServiceImpl implements BuySellService, Serializable {

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(BuySellServiceImpl.class);

    @Autowired
    private BuySellDao elegantBuySellDao;

    @Override
    public ServicePayload getBuySellById(ServiceControl serviceControl, long compId, long billId) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ElegantBuySell elegantBuySell;
        elegantBuySell = elegantBuySellDao.getBuySellById(compId, billId);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantBuySell);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload getAllBuySell(ServiceControl serviceControl, long compId, boolean forRep) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantBuySell> elegantBuySellList;
        elegantBuySellList = elegantBuySellDao.getAllBuySell(serviceControl, compId,forRep);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantBuySellList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload saveBuySellList(ServiceControl serviceControl, ArrayList<ElegantBuySell> buySellList, boolean updateStock) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        buySellList = elegantBuySellDao.saveBuySellList(buySellList,updateStock);
        List<Object> objectList = new ArrayList<>();
        objectList.add(buySellList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload deleteBuySellList(ServiceControl serviceControl, ArrayList<ElegantBuySell> buySellList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        Boolean deleted = elegantBuySellDao.deleteBuySellList(buySellList);
        List<Object> objectList = new ArrayList<>();
        objectList.add(deleted);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload getAllBuySellForReport(ServiceControl serviceControl, long compId, int  salesManId, long productId, String buyerSellerCode, Date fromDt, Date toDate,String billType) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantBuySellConsolidation> elegantBuySellList;
        elegantBuySellList = elegantBuySellDao.getAllBuySellForReport(serviceControl, compId, salesManId, productId, buyerSellerCode, fromDt, toDate, billType);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantBuySellList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }

    @Override
    public ServicePayload getGlobalMailingList(ServiceControl serviceControl) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantMailList> elegantMailList;
        elegantMailList = elegantBuySellDao.getGlobalMailingList(serviceControl);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantMailList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;
    }

    @Override
    public ServicePayload saveGlobalMailingList(ServiceControl serviceControl, ArrayList<ElegantMarketMail> emailList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        emailList = elegantBuySellDao.saveGlobalMailingList(serviceControl, emailList);
        List<Object> objectList = new ArrayList<>();
        objectList.add(emailList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }
}
