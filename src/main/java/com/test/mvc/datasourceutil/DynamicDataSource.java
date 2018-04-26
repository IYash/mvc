package com.test.mvc.datasourceutil;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;



/**
 * @author huangchangling on 2017/6/28 0028
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {

        return DataSourceContextHolder.getDataSourceName();
    }
}
