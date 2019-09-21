package com.trifail.customizedxsd.extensiblexml.parser;

import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.UUID;

/**
 * 参考dubbo进行修改
 */
public class TrifailBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    /*暂时没用*/
    private Class<?> beanCLass;


    public TrifailBeanDefinitionParser(Class<?> beanCLass) {
        this.beanCLass = beanCLass;
    }

    /*如何将element解析参数到beandefinitionbuilder中*/
    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        builder.getBeanDefinition().setBeanClass(beanCLass);
        builder.getBeanDefinition().setLazyInit(false);

        String id = element.getAttribute("id");
        if (StringUtils.isEmpty(id)) {
            id = UUID.randomUUID().toString();
        }
        builder.addPropertyValue("id", id);

        String name = element.getAttribute("name");
        if (StringUtils.isEmpty(name)) {
            name = UUID.randomUUID().toString();
        }
        builder.addPropertyValue("name", name);

        String owner = element.getAttribute("owner");
        if (StringUtils.isEmpty(owner)) {
            owner = "syoka";
        }
        builder.addPropertyValue("owner", owner);

        String version = element.getAttribute("version");
        if (StringUtils.isEmpty(owner)) {
            version = "1.0";
        }
        builder.addPropertyValue("version", version);

        NodeList parameterList = element.getElementsByTagName("metadata");
        builder.addPropertyValue("metadata", parseParameters(parameterList));
    }


    @SuppressWarnings("unchecked")
    private static ManagedMap parseParameters(NodeList nodeList) {
        if (nodeList != null && nodeList.getLength() > 0) {
            ManagedMap parameters = null;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    if ("parameter".equals(node.getNodeName())
                            || "parameter".equals(node.getLocalName())) {
                        if (parameters == null) {
                            parameters = new ManagedMap();
                        }
                        String key = ((Element) node).getAttribute("key");
                        String value = ((Element) node).getAttribute("value");
                        parameters.put(key, new TypedStringValue(value, String.class));
                    }
                }
            }
            return parameters;
        }
        return null;
    }
}
