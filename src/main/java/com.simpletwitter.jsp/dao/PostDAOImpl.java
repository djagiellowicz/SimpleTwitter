package com.simpletwitter.jsp.dao;

import com.simpletwitter.jsp.model.Post;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class PostDAOImpl implements PostDAO {
    @Override
    public ArrayList<Post> getAllPosts() {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Post.class);
        ArrayList<Post> list = (ArrayList<Post>) criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Post getPostById(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Post p WHERE p.id = :id").setParameter("id",id);
        Post post = (Post) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return post;
    }

    @Override
    public void savePost(Post post) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updatePost(Post post) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(post);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deletePost(Post post) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(post);
        session.getTransaction().commit();
        session.close();
    }
}
