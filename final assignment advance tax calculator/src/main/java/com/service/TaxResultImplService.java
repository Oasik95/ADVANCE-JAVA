package com.service;

import com.domain.TaxResult;
import com.repository.TaxResultRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaxResultImplService implements TaxResultService{

    private TaxResultRepository taxResultRepository;
    public TaxResultImplService(TaxResultRepository taxResultRepository ) {
        this.taxResultRepository = taxResultRepository;


    }
    @Transactional
    public TaxResult insert(TaxResult taxResult) {

        return taxResultRepository.create(taxResult);
    }

    @Transactional
    public List<TaxResult> getAllByUserName(String name) {
        return taxResultRepository.findAllByUserName(name);
    }
}
