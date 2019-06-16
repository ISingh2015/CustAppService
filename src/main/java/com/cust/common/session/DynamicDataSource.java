package com.cust.common.session;

import com.cust.common.DBInfo;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class DynamicDataSource {

    @Autowired
    private DBPropertyContainer propertyContainer;

    public BasicDataSource getDataSource(DBInfo dbInfo) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(propertyContainer.getDbDriverClassName());
        ds.setUrl("jdbc:sqlserver://" + propertyContainer.getDbServerName() + ":" + propertyContainer.getDbServerPort() + ";databaseName=" + dbInfo.getDbName());
        ds.setUsername(propertyContainer.getDbUserName());
        ds.setPassword(propertyContainer.getDbPassword());
        return ds;
    }
}
