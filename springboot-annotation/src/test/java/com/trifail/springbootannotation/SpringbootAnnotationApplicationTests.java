package com.trifail.springbootannotation;

import config.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAnnotationApplicationTests {

    @Test
    public void contextLoads() {
        ClassPathResource resource = new ClassPathResource("application-trifail.xml");

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);

        ApplicationConfig config = (ApplicationConfig) beanFactory.getBean("trifail001");

        System.err.println("name -->" + config.getName());
        System.err.println("version -->" + config.getVersion());
        System.err.println("owner -->" + config.getOwner());
        Map<String, String> metadata = config.getMetadata();

        if (metadata != null && metadata.size() > 0) {
            for (Map.Entry<String, String> entry : metadata.entrySet()) {
                System.err.println("metadata key ->" + entry.getKey() +
                        ",metadata value->" + entry.getValue());
            }
        }

    }

}
