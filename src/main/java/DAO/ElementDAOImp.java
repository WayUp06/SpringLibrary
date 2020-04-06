package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public class ElementDAOImp<E> implements ElementDAO<E> {

    private Class<E> elementClass;

    public ElementDAOImp() { }

    public ElementDAOImp(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void add(E e) {
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(e);
        transaction.commit();
    }

    @Override
    public void update(E e) {
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().update(e);
        transaction.commit();
    }

    @Override
    public E get(int eID) {
        return sessionFactory.getCurrentSession().get(elementClass, 1);

    }


    @Override
    public Collection<E> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(elementClass).list();
    }

    @Override
    public void delete(E e) {
            Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(e);
            transaction.commit();
    }
}
