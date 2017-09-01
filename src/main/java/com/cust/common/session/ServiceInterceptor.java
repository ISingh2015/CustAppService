package com.cust.common.session;

import com.cust.common.*;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;

public class ServiceInterceptor implements MethodInterceptor {

    @Autowired
    private CustomAbstractRoutingDataSource customRoutingDS;

    @Autowired
    private DynamicDataSource dynamicDataSource;

//    @Autowired
//    private MessageSource messageSource;

    @Autowired
    private SessionManager sessionManager;

    public ServiceInterceptor() {
        super();
    }

    /**
     * ServiceInterceptor intercepts any calls that are made to the service. It
     * inspects the method parameters to check if the necessary values have been
     * passed that mandatory. In this case it is checking if we have passed the
     * data source information in the ServiceControl parameter of the method. If
     * the value is not available then it throws and exception and cannot
     * proceed further. It is also checking to see if the session information
     * has been passed. else in this case to it throws an exception.
     *
     * @param mi
     * @throws java.lang.Throwable
     */
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
//        String errMsg = messageSource.getMessage("serviceInterceptor.invoke", null, null);

        String errMsg = "Either DBInfo is Null or DBName is not set ";
        // String methodName = mi.getMethod().getName();
        Map<Object, Object> targetDataSources = null;
        DBInfo dbInfo = getDbInfo(mi);

        if (dbInfo == null) {
            throw new ApplicationException(errMsg);
        } else if ((dbInfo.getDbName() == null || dbInfo.getDbName().equals(""))) {
            throw new ApplicationException(errMsg);
        } else {
            if (dbInfo.getTargetDataSources() == null) {
                targetDataSources = new HashMap<>();
            } else {
                targetDataSources = dbInfo.getTargetDataSources();
            }
        }
        if (targetDataSources.get(dbInfo.getDbName()) == null) {
            BasicDataSource ds = dynamicDataSource.getDataSource(dbInfo);
            targetDataSources.put(dbInfo.getDbName(), ds);
        }

        // set the dynamic data source for routing
        customRoutingDS.setTargetDataSources(targetDataSources);

        // inform the context loader of the database context
        DatabaseContextLoader.setDatabaseName(dbInfo.getDbName());
        if (!sessionManager.validateSession(getSessionInfo(mi))) {
//            throw new ApplicationException(messageSource.getMessage("serviceInterceptor.invokeUserNameError", null, null));
            throw new ApplicationException ("Session Info is Null or not available");
        }

        if (!sessionManager.validateUser(getSessionInfo(mi))) {
//            throw new ApplicationException(messageSource.getMessage("serviceInterceptor.invokeUserNameError", null, null));
            throw new ApplicationException ("Either User Info is Null or User Name is not Set");
        }

        Object obj = mi.proceed(); // invoke the method call;
        // clean up the database context
        // DatabaseContextLoader.clearDatabaseName();
        return obj;
    }

    public DBInfo getDbInfo(MethodInvocation mi) {
        ServiceControl serviceControl = null;
        DBInfo dbInfo = null;

        Object[] args = mi.getArguments();
        for (Object obj : args) {
            if (obj instanceof ServiceControl) {
                serviceControl = (ServiceControl) obj;
                dbInfo = (DBInfo) serviceControl.getDbInfo();
                break;
            }
        }
        return dbInfo;
    }

    public SessionInfo getSessionInfo(MethodInvocation mi) throws Throwable{
        ServiceControl serviceControl = null;
        SessionInfo sessionInfo = null;

        Object[] args = mi.getArguments();
        for (Object obj : args) {
            if (obj instanceof ServiceControl) {
                serviceControl = (ServiceControl) obj;
                sessionInfo = (SessionInfo) serviceControl.getSessionInfo();
                break;
            }
        }
        if (serviceControl == null ) {
            throw new ApplicationException ("ServiceControl is Null or is not available");
        }
        return sessionInfo;
    }
}
