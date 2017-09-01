package com.cust.common.session;

import com.cust.common.*;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CustomAbstractRoutingDataSource extends AbstractRoutingDataSource {

//    @Autowired
//    private MessageSource messageSource;

    private Map<Object, Object> targetDataSources = new HashMap<>();

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
//        System.out.println("setting data source " + targetDataSources.size());
        this.targetDataSources = targetDataSources;
    }

    @Override
    protected DataSource determineTargetDataSource() {
        Object lookupKey = determineCurrentLookupKey();
        if (lookupKey == null) {
            lookupKey = "custService";
        }
//        System.out.println("Look up key " + lookupKey);
        DataSource dataSource = (DataSource) this.targetDataSources.get(lookupKey);
        if (dataSource == null) {
//            String errMsg = messageSource.getMessage("customAbstractRoutingDataSource.determineTargetDataSource", new Object[]{lookupKey}, null);
            String errMsg = "Data Source not Found in ServiceControl...";
            throw new IllegalStateException(errMsg);
        }
        return dataSource;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextLoader.getDatabaseName();
    }

    @Override
    public void afterPropertiesSet() {
        // do nothing
        // overridden to avoid datasource validation error by Spring
    }

}
