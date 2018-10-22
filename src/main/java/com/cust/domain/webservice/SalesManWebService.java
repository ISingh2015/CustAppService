/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.webservice;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.vo.ElegantSalesMan;
import java.util.ArrayList;

/**
 *
 * @author Inderjit
 */
public interface SalesManWebService {

    public ServicePayload getSalesManById(ServiceControl serviceControl, long compId, long salesManId) throws ApplicationException;

    public ServicePayload getAllSalesMan(ServiceControl serviceControl,long compId) throws ApplicationException;

    public ServicePayload saveSalesManList(ServiceControl serviceControl, ArrayList<ElegantSalesMan> salesManList) throws ApplicationException;

    public ServicePayload deleteSalesManList(ServiceControl serviceControl, ArrayList<ElegantSalesMan> salesManList) throws ApplicationException;

}
