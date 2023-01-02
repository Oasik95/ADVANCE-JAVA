package com.service;

import com.domain.TaxResult;

import java.util.List;

public interface TaxResultService {

    public TaxResult insert(TaxResult taxResult);

    List<TaxResult> getAllByUserName(String name);
}
