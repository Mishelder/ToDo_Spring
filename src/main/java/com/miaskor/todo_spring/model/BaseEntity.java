package com.miaskor.todo_spring.model;

import lombok.Data;

@Data
public class BaseEntity<T> {
    T id;
}
