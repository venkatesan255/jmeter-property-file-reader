package com.jmeterplugins.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.services.FileServer;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testelement.TestStateListener;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PropertyReader extends ConfigTestElement implements TestBean, TestStateListener {

    private static final Logger log = LoggingManager.getLoggerForClass();
    private static final long serialVersionUID = 232L;
    private transient String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void testStarted() {
        if (StringUtils.isNotEmpty(getFilename())) {
            try {
                String fpath = this.filename;
                if (!(new File(this.filename)).isAbsolute())
                    fpath = FileServer.getFileServer().getBaseDir() + File.separator + this.filename;
                log.info("Property file reader - loading the properties from " + fpath);
                JMeterUtils.getJMeterProperties().load(new FileInputStream(fpath));
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

    }

    public void testStarted(String s) {
        testStarted();

    }

    public void testEnded() {

    }

    public void testEnded(String s) {

    }
}
