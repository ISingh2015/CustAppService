package com.cust.domain.dao;

import java.util.ArrayList;
import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.domain.vo.ElegantSalesMan;

public interface SalesManDao {

    public ElegantSalesMan getSalesManById(long compId, long salesManId) throws ApplicationException;

    public ArrayList<ElegantSalesMan> getAllSalesMan(ServiceControl serviceControl,long compId) throws ApplicationException;

    public ArrayList<ElegantSalesMan> saveSalesManList(ArrayList<ElegantSalesMan> salesManList) throws ApplicationException;

    public Boolean deleteSalesManList(ArrayList<ElegantSalesMan> salesManList) throws ApplicationException;

}
