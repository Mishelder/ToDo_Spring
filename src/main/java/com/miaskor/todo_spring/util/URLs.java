package com.miaskor.todo_spring.util;

import lombok.experimental.UtilityClass;

import java.util.Set;

@UtilityClass
public class URLs {
    public static final String LOGIN = "/login";
    public static final String REGISTRATION = "/registration";
    public static final String CSS_FILES = "/css";
    public static final String JS_FILES = "/js";
    public static final String IMG_FILES = "/img";


    public static Set<String> getAllPublicURL() {
        return Set.of(LOGIN,CSS_FILES,JS_FILES,IMG_FILES,REGISTRATION);
    }
}