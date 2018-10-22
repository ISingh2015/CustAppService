package com.cust.domain.webservice.impl;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.service.CountryService;
import com.cust.domain.vo.ElegantCountry;
import com.cust.domain.webservice.CountryWebService;
import java.io.Serializable;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Inderjit
 */
public class CountryWebServiceImpl implements CountryWebService, Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    private CountryService countryService;

    @Override
    public ServicePayload getCountryById(ServiceControl serviceControl, int countryId) throws ApplicationException {
        ServicePayload servicePayload = countryService.getCountryById(serviceControl, countryId);
        return servicePayload;
    }

    @Override
    public ServicePayload getAllCountries(ServiceControl serviceControl) throws ApplicationException {
        ServicePayload servicePayload = countryService.getAllCountries(serviceControl);
        return servicePayload;

    }

    @Override
    public ServicePayload saveCountryList(ServiceControl serviceControl, ArrayList<ElegantCountry> countryList) throws ApplicationException {
        ServicePayload servicePayload = countryService.saveCountryList(serviceControl, countryList);
        return servicePayload;

    }

    @Override
    public ServicePayload deleteCountryList(ServiceControl serviceControl, ArrayList<ElegantCountry> countryList) throws ApplicationException {
        ServicePayload servicePayload = countryService.deleteCountryList(serviceControl, countryList);
        return servicePayload;
    }

}
