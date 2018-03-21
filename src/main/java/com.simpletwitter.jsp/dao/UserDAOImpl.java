package com.simpletwitter.jsp.dao;


import com.simpletwitter.jsp.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public HashMap<Long, User> getMapOfUsers() {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        List<User> userList = criteria.list();
        HashMap<Long,User> mapOfUsers = new HashMap<>();
        for (User user: userList) {
            mapOfUsers.put(user.getId(),user);
        }
        session.getTransaction().commit();
        session.close();
        return mapOfUsers;
    }

    @Override
    public User getUserById(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM User u WHERE u.id = :id").setParameter("id", id);
        User user = (User) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public void saveUser(User user) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUser(User user) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
