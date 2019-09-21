package com.trifail.customizedxsd.extensiblexml;

import com.trifail.customizedxsd.extensiblexml.parser.TrifailBeanDefinitionParser;
import config.ApplicationConfig;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class TrifailNamespaceHandler extends NamespaceHandlerSupport {


    @Override
    public void init() {
        registerBeanDefinitionParser("application", new TrifailBeanDefinitionParser(ApplicationConfig.class));
//        registerBeanDefinitionParser("classrefer", new TrifailBeanDefinitionParser(ClassReferConfig.class));
    }
}
