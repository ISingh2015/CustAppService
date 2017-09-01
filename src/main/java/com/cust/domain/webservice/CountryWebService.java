/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.webservice;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.vo.ElegantCountry;
import java.util.ArrayList;

/**
 *
 * @author Inderjit
 */
public interface CountryWebService {

    public ServicePayload getCountryById(ServiceControl serviceControl, int countryId) throws ApplicationException;

    public ServicePayload getAllCountries(ServiceControl serviceControl) throws ApplicationException;

    public ServicePayload saveCountryList(ServiceControl serviceControl, ArrayList<ElegantCountry> countryList) throws ApplicationException;

    public ServicePayload deleteCountryList(ServiceControl serviceControl, ArrayList<ElegantCountry> countryList) throws ApplicationException;

}
