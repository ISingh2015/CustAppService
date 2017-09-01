package com.cust.domain.webservice.impl;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.service.BuySellService;
import com.cust.domain.vo.ElegantBuySell;
import com.cust.domain.vo.ElegantMarketMail;
import com.cust.domain.webservice.BuySellWebService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Inderjit
 */
public class BuySellWebServiceImpl implements BuySellWebService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private BuySellService elegantBuySellService;

    @Override
    public ServicePayload getBuySellById(ServiceControl serviceControl, long compId, long prodId) throws ApplicationException {
        ServicePayload servicePayload = elegantBuySellService.getBuySellById(serviceControl, compId, prodId);
        return servicePayload;
    }

    @Override
    public ServicePayload getAllBuySell(ServiceControl serviceControl, long compId, boolean forRep) throws ApplicationException {
        ServicePayload servicePayload = elegantBuySellService.getAllBuySell(serviceControl, compId,forRep);
        return servicePayload;
    }

    @Override
    public ServicePayload saveBuySellList(ServiceControl serviceControl, ArrayList<ElegantBuySell> buySellList, boolean updateStock) throws ApplicationException {
        ServicePayload servicePayload = elegantBuySellService.saveBuySellList(serviceControl, buySellList,updateStock);
        return servicePayload;
    }

    @Override
    public ServicePayload deleteBuySellList(ServiceControl serviceControl, ArrayList<ElegantBuySell> buySellList) throws ApplicationException {
        ServicePayload servicePayload = elegantBuySellService.deleteBuySellList(serviceControl, buySellList);
        return servicePayload;
    }

    @Override
    public ServicePayload getAllBuySellForReport(ServiceControl serviceControl, long compId, int  salesManId, long productId, String buyerSellerCode, Date fromDt, Date toDate,String billType) throws ApplicationException {
        ServicePayload servicePayload = elegantBuySellService.getAllBuySellForReport(serviceControl, compId, salesManId, productId, buyerSellerCode, fromDt, toDate,billType);
        return servicePayload;

    }

    @Override
    public ServicePayload getGlobalMailingList(ServiceControl serviceControl) throws ApplicationException {
        ServicePayload servicePayload = elegantBuySellService.getGlobalMailingList(serviceControl);
        return servicePayload;
    }

    @Override
    public ServicePayload saveGlobalMailingList(ServiceControl serviceControl, ArrayList<ElegantMarketMail> emailList) throws ApplicationException {
        ServicePayload servicePayload = elegantBuySellService.saveGlobalMailingList(serviceControl, emailList);
        return servicePayload;

    }
}
