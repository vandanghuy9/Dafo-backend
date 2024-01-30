package com.dafo.application.service;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    T getById(@PathVariable int id);
    T save(T t);

    T updateByID(int id, T t);
    T deleteByID(int id);

}
