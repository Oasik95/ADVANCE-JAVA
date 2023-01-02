package com.service;

import com.domain.TaxUser;

import java.util.List;

public interface TaxUserService {

    public TaxUser insert(TaxUser taxUser);



    public TaxUser get(Long id);

    TaxUser findByUserName(String name);

    void update(TaxUser taxUser);
    public List<TaxUser> getAll();



}
