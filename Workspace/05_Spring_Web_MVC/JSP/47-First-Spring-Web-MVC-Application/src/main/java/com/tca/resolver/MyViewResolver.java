package com.tca.resolver;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.Locale;

public class MyViewResolver implements ViewResolver {

    @Override
    public @Nullable View resolveViewName(String viewName, Locale locale) throws Exception {
        String path = "/WEB-INF/view/" + viewName + ".jsp";
        return new InternalResourceView(path);
    }
}
