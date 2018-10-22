/**
 * 
 */
package com.cust.common;

import java.io.Serializable;

/**
 * @author Inderjit This will have the details to perform pagination on the a
 *         result set.
 */
public class Pagination implements Serializable
{
	private static final long serialVersionUID = 1L;

	private long currrentPageNumber;
	private long maxPageSize;
	private long totalPages;
	private long totalRows;

	/**
	 * @return the currrentPageNumber
	 */
	public long getCurrrentPageNumber() {
		return currrentPageNumber;
	}

	/**
	 * @param currrentPageNumber
	 *            the currrentPageNumber to set
	 */
	public void setCurrrentPageNumber(long currrentPageNumber) {
		this.currrentPageNumber = currrentPageNumber;
	}

	/**
	 * @return the maxPageSize
	 */
	public long getMaxPageSize() {
		return maxPageSize;
	}

	/**
	 * @param maxPageSize
	 *            the maxPageSize to set
	 */
	public void setMaxPageSize(long maxPageSize) {
		this.maxPageSize = maxPageSize;
	}

	/**
	 * @return the totalPages
	 */
	public long getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages
	 *            the totalPages to set
	 */
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the totalRows
	 */
	public long getTotalRows() {
		return totalRows;
	}

	/**
	 * @param totalRows
	 *            the totalRows to set
	 */
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

}
