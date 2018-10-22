package com.cust.common;

import java.io.Serializable;

public class SortCriteria implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String sortFieldName;
	private String sortDirection;

	/**
	 * @return the sortFieldName
	 */
	public String getSortFieldName() {
		return sortFieldName;
	}

	/**
	 * @param sortFieldName
	 *            the sortFieldName to set
	 */
	public void setSortFieldName(String sortFieldName) {
		this.sortFieldName = sortFieldName;
	}

	/**
	 * @return the sortDirection
	 */
	public String getSortDirection() {
		return sortDirection;
	}

	/**
	 * @param sortDirection
	 *            the sortDirection to set
	 */
	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}
}
