package com.repository;

import com.domain.TaxUser;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaxUserRepositoryImpl implements TaxUserRepository {

    private SessionFactory sessionFactory;

    public TaxUserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public TaxUser create(TaxUser taxUser) {
        Session session = sessionFactory.getCurrentSession();
        session.save(taxUser);
        return taxUser;
    }

    public TaxUser get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TaxUser.class, id);
    }
    public List<TaxUser> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<TaxUser> taxUserQuery = session.createQuery("from TaxUser", TaxUser.class);
        return taxUserQuery.getResultList();
    }

    @Override
    public TaxUser findByUserName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<TaxUser> userQuery = session.createQuery("from TaxUser where username = :username", TaxUser.class);
        userQuery.setParameter("username", name);
        return userQuery.getSingleResult();

    }



    @Override
    public void update(TaxUser taxUser) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(taxUser);

    }
}
