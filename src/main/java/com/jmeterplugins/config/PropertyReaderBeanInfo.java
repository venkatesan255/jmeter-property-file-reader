package com.jmeterplugins.config;

import org.apache.jmeter.testbeans.BeanInfoSupport;

import java.beans.PropertyDescriptor;

public class PropertyReaderBeanInfo extends BeanInfoSupport {

    private static final String FILENAME = "filename";

    public PropertyReaderBeanInfo() {
        super(PropertyReader.class);
//        this.createPropertyGroup("csv_data", new String[]{"filename", "fileEncoding", "variableNames", "delimiter", "quotedData", "recycle", "stopThread", "shareMode"});
        PropertyDescriptor p = this.property(FILENAME);
        p.setValue("notUndefined", Boolean.TRUE);
        p.setValue("default", "");
        p.setValue("notExpression", Boolean.TRUE);

    }

}
