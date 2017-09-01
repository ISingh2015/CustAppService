/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.webservice;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;

/**
 *
 * @author ISanhot
 */
public interface PreferenceWebService {

    public ServicePayload getServiceNames(ServiceControl serviceControl, long compId) throws ApplicationException;

    public ServicePayload getServiceConstants(ServiceControl serviceControl, long compId) throws ApplicationException;


}
