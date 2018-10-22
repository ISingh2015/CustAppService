package com.cust.common;

import java.io.Serializable;
import java.util.List;

public class ServicePayload implements Serializable
{
	private static final long serialVersionUID = 1L;
	private ResponseMetaData reponseMetaData;
	private List<Object> responseValue;

	/**
	 * @return the reponseMetaData
	 */
	public ResponseMetaData getReponseMetaData() {
		return reponseMetaData;
	}

	/**
	 * @param reponseMetaData
	 *            the reponseMetaData to set
	 */
	public void setReponseMetaData(ResponseMetaData reponseMetaData) {
		this.reponseMetaData = reponseMetaData;
	}

	/**
	 * @return the responseValue
	 */
	public List<Object> getResponseValue() {
		return responseValue;
	}

	/**
	 * @param responseValue
	 *            the responseValue to set
	 */
	public void setResponseValue(List<Object> responseValue) {
		this.responseValue = responseValue;
	}
}
