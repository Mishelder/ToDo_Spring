package com.miaskor.todo_spring.util;

import lombok.experimental.UtilityClass;

import java.util.Set;

@UtilityClass
public class URLs {
    public static final String LOGIN = "/login";
    public static final String CSS_FILES = "/css";

    public static Set<String> getAllFeasibleURL() {
        return Set.of(LOGIN);
    }

    public static Set<String> getAllPublicURL() {
        return Set.of(LOGIN,CSS_FILES);
    }
}