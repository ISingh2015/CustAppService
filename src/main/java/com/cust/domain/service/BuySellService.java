package com.cust.domain.service;

import java.util.ArrayList;
import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.vo.ElegantBuySell;
import com.cust.domain.vo.ElegantMailList;
import com.cust.domain.vo.ElegantMarketMail;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author Inderjit
 */
@Service("buySellService")
public interface BuySellService {

    public ServicePayload getBuySellById(ServiceControl serviceControl, long compId, long prodId) throws ApplicationException;

    public ServicePayload getAllBuySell(ServiceControl serviceControl, long compId, boolean forRep) throws ApplicationException;

    public ServicePayload getAllBuySellForReport(ServiceControl serviceControl, long compId, int salesManId, long productId, String buyerSellerCode, Date fromDt, Date toDate, String billType) throws ApplicationException;

    public ServicePayload saveBuySellList(ServiceControl serviceControl, ArrayList<ElegantBuySell> buySellList, boolean updateStock) throws ApplicationException;

    public ServicePayload deleteBuySellList(ServiceControl serviceControl, ArrayList<ElegantBuySell> buySellList) throws ApplicationException;

    public ServicePayload getGlobalMailingList(ServiceControl serviceControl) throws ApplicationException;

    public ServicePayload saveGlobalMailingList(ServiceControl serviceControl, ArrayList<ElegantMarketMail> emailList) throws ApplicationException;
}
