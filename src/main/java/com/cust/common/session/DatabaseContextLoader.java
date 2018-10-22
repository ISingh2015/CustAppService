package com.cust.common.session;

import org.springframework.util.Assert;

public class DatabaseContextLoader {

	private static final InheritableThreadLocal<String> contextHolder = new InheritableThreadLocal<String>();

	public static void setDatabaseName(String dbName) {
		Assert.notNull(dbName, "DBName cannot be null");
		contextHolder.set(dbName);
	}

	public static String getDatabaseName() {
		return (String) contextHolder.get();
	}

	public static void clearDatabaseName() {
		contextHolder.remove();
	}

}
