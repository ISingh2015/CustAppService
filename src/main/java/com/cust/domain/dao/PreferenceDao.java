/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.dao;

import com.cust.common.ApplicationException;
import com.cust.domain.vo.PreferenceVO;
import java.util.ArrayList;

/**
 *
 * @author ISanhot
 */
public interface PreferenceDao {

    public ArrayList<PreferenceVO> getServiceNames(long compId) throws ApplicationException;

    public ArrayList<PreferenceVO> getServiceConstants(long compId) throws ApplicationException;

}
