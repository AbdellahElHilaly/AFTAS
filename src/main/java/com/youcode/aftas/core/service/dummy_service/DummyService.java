package com.youcode.aftas.core.service.dummy_service;

import java.util.List;

public interface DummyService <T>{

    public T save();
    public List<T> saveCollection(int size);
}
