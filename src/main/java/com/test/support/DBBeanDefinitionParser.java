package com.test.support;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Created by huangchangling on 2018/7/27.
 */
public class DBBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    protected Class<?> getBeanClass(Element element) {
        return DBConfig.class;
    }

    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String url = element.getAttribute("url");
        String username = element.getAttribute("username");
        String password = element.getAttribute("password");

        if (StringUtils.hasText(url)) {
            bean.addPropertyValue("url", url);
        }

        if (StringUtils.hasText(username)) {
            bean.addPropertyValue("username", username);
        }

        if (StringUtils.hasText(password)) {
            bean.addPropertyValue("password", password);
        }
    }
}
