package com.cust.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QueryCriteria implements Serializable
{
	private static final long serialVersionUID = 1L;
	private List<FilterCriteria> filterCriteria = new ArrayList<FilterCriteria>();

	/**
	 * @return the filterCriteria
	 */
	public List<FilterCriteria> getFilterCriteria() {
		return filterCriteria;
	}

	/**
	 * @param filterCriteria
	 *            the filterCriteria to set
	 */
	public void setFilterCriteria(List<FilterCriteria> filterCriteria) {
		this.filterCriteria = filterCriteria;
	}

	/**
	 * @return the sortCriteria
	 */
	public List<SortCriteria> getSortCriteria() {
		return sortCriteria;
	}

	/**
	 * @param sortCriteria
	 *            the sortCriteria to set
	 */
	public void setSortCriteria(List<SortCriteria> sortCriteria) {
		this.sortCriteria = sortCriteria;
	}

	private List<SortCriteria> sortCriteria = null;
}
