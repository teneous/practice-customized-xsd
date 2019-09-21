package com.trifail.springbootannotation.extensiblexml;

import com.trifail.springbootannotation.extensiblexml.parser.TrifailBeanDefinitionParser;
import config.ApplicationConfig;
import config.ClassReferConfig;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class TrifailNamespaceHandler extends NamespaceHandlerSupport {


    @Override
    public void init() {
        registerBeanDefinitionParser("application", new TrifailBeanDefinitionParser(ApplicationConfig.class));
//        registerBeanDefinitionParser("classrefer", new TrifailBeanDefinitionParser(ClassReferConfig.class));
    }
}
