package com.cust.domain.dao;

import java.util.ArrayList;
import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.domain.vo.ElegantCountry;

public interface CountryDao {

    public ElegantCountry getCountryById(int countryId) throws ApplicationException;

    public ArrayList<ElegantCountry> getAllCountries(ServiceControl serviceControl) throws ApplicationException;

    public ArrayList<ElegantCountry> saveCountryList(ArrayList<ElegantCountry> countryList) throws ApplicationException;

    public Boolean deleteCountryList(ArrayList<ElegantCountry> countryList) throws ApplicationException;

}
