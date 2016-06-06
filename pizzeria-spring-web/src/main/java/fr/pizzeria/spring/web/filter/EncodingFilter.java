package fr.pizzeria.spring.web.filter;

import org.springframework.web.filter.CharacterEncodingFilter;

public class EncodingFilter extends CharacterEncodingFilter {

    public EncodingFilter() {
        super("UTF-8", true);
    }

}
