package com.cust.common;

import java.io.Serializable;

public class FilterCriteria implements Serializable {
	private static final long serialVersionUID = 1L;
	private String filterFieldName;
	private String filterFieldValue;
	private String filterCondition;
	/**
	 * @return the filterFieldName
	 */
	public String getFilterFieldName() {
		return filterFieldName;
	}
	/**
	 * @param filterFieldName the filterFieldName to set
	 */
	public void setFilterFieldName(String filterFieldName) {
		this.filterFieldName = filterFieldName;
	}
	/**
	 * @return the filterFieldValue
	 */
	public String getFilterFieldValue() {
		return filterFieldValue;
	}
	/**
	 * @param filterFieldValue the filterFieldValue to set
	 */
	public void setFilterFieldValue(String filterFieldValue) {
		this.filterFieldValue = filterFieldValue;
	}
	/**
	 * @return the filterCondition
	 */
	public String getFilterCondition() {
		return filterCondition;
	}
	/**
	 * @param filterCondition the filterCondition to set
	 */
	public void setFilterCondition(String filterCondition) {
		this.filterCondition = filterCondition;
	}
}
