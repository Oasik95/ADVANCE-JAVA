package com.repository;

import com.domain.TaxUser;

import java.util.List;

public interface TaxUserRepository {

    public TaxUser create(TaxUser taxUser);


    public TaxUser get(Long id);



    TaxUser findByUserName(String name);

    void update(TaxUser taxUser);

    public List<TaxUser> getAll();
}
