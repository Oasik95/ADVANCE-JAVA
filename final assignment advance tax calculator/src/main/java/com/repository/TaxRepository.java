package com.repository;

import com.domain.Tax;

import java.util.List;

public interface TaxRepository {

    public Tax create(Tax tax);

    List<Tax> findAllByUserName(String name);
}
