package com.service;

import com.domain.Tax;
import com.domain.TaxResult;

import java.util.List;

public interface TaxService {

    public Tax insert(Tax tax);
    public TaxResult calculateTax (Tax tax);

    List<Tax> getAllByUserName(String name);
}
