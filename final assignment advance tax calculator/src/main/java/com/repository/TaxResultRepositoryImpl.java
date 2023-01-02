package com.repository;

import com.domain.Tax;
import com.domain.TaxResult;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaxResultRepositoryImpl implements TaxResultRepository{

    private SessionFactory sessionFactory;

    public TaxResultRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public TaxResult create(TaxResult taxResult) {
        Session session = sessionFactory.getCurrentSession();
        session.save(taxResult);
        return taxResult;

    }

    @Override
    public List<TaxResult> findAllByUserName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<TaxResult> taxResultQuery = session.createQuery("from TaxResult i " +
                        " where i.user.username=:username",
                TaxResult.class);
        taxResultQuery.setParameter("username", name);
        return taxResultQuery.getResultList();
    }
}
