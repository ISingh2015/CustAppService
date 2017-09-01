package com.cust.domain.dao;

import java.util.ArrayList;
import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.domain.vo.ElegantBuySell;
import com.cust.domain.vo.ElegantBuySellConsolidation;
import com.cust.domain.vo.ElegantMailList;
import com.cust.domain.vo.ElegantMarketMail;
import java.util.Date;

/**
 *
 * @author Inderjit
 */
public interface BuySellDao {

    public ElegantBuySell getBuySellById(long compId, long billId) throws ApplicationException;

    public ArrayList<ElegantBuySell> getAllBuySell(ServiceControl serviceControl, long compId, boolean forReport) throws ApplicationException;

    public ArrayList<ElegantBuySellConsolidation> getAllBuySellForReport(ServiceControl serviceControl, long compId, int salesManId, long productId, String buyerSellerCode, Date fromDt, Date toDate, String billType) throws ApplicationException;

    public ArrayList<ElegantBuySell> saveBuySellList(ArrayList<ElegantBuySell> buySellList, boolean updateStock) throws ApplicationException;

    public Boolean deleteBuySellList(ArrayList<ElegantBuySell> buySellList) throws ApplicationException;

    public ArrayList<ElegantMailList> getGlobalMailingList(ServiceControl serviceControl) throws ApplicationException;

    public ArrayList<ElegantMarketMail> saveGlobalMailingList(ServiceControl serviceControl, ArrayList<ElegantMarketMail> emailList) throws ApplicationException;
}
