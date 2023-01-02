package com.repository;

import com.domain.Tax;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaxRepositoryImpl implements TaxRepository{


    private SessionFactory sessionFactory;

    public TaxRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Tax create(Tax tax) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tax);
        return tax;

    }

    @Override
    public List<Tax> findAllByUserName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Tax> taxQuery = session.createQuery("from Tax i " +
                        " where i.user.username=:username",
                Tax.class);
        taxQuery.setParameter("username", name);
        return taxQuery.getResultList();
    }
}
