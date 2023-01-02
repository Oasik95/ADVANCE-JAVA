package com.service;

import com.domain.TaxUser;
import com.repository.TaxUserRepository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaxUserImplService implements TaxUserService{

    private TaxUserRepository taxUserRepository;





    public TaxUserImplService(TaxUserRepository taxUserRepository ) {
        this.taxUserRepository = taxUserRepository;


    }

    @Transactional
    public TaxUser insert(TaxUser taxUser) {

        return taxUserRepository.create(taxUser);
    }

    @Transactional(readOnly = true)
    public TaxUser get(Long id) {
        return taxUserRepository.get(id);
    }


    @Transactional(readOnly = true)
    public List<TaxUser> getAll() {
        return taxUserRepository.getAll();
    }




    @Transactional(readOnly = true)
    public TaxUser findByUserName(String name) {
        return taxUserRepository.findByUserName(name);
    }

    @Override
    @Transactional
    public void update(TaxUser taxUser) {

//        taxUser.setPassword(passwordEncoder.encode(taxUser.getPassword()));
//        taxUser.setRepass(passwordEncoder.encode(taxUser.getPassword()));

         taxUserRepository.update(taxUser);

    }



}
