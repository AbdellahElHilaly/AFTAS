package com.youcode.aftas.core.dao.model.fake;

import com.github.javafaker.Faker;
import com.youcode.aftas.core.dao.model.entity.Member;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseFaker<T> {
    protected final Faker faker = new Faker();

    public abstract T generate();

    public List<T> generateCollection(int size) {
        List<T> dummyList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            dummyList.add(generate());
        }
        return dummyList;
    }
}
