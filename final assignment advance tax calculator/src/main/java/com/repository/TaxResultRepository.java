package com.repository;

import com.domain.Tax;
import com.domain.TaxResult;

import java.util.List;

public interface TaxResultRepository {

    public TaxResult create(TaxResult taxResult);

    List<TaxResult> findAllByUserName(String name);
}
