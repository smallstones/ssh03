package com.stone.shs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.usertype.ParameterizedType;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public class BaseDao<T> implements IBaseDao<T> {
    private SessionFactory sessionFactory;

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 获取session
     * @return
     */
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    private Class<T> getCla(){
        return (Class<T>)(((java.lang.reflect.ParameterizedType)
                (this.getClass().getGenericSuperclass()))
                .getActualTypeArguments()[0]);
    }



    @Override
    public void add(T t) {
        getSession().save(t);
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public void delete(int id) {
        getSession().delete(id);
    }

    @Override
    public T load(int id) {
        return getSession().load(getCla(),id);
    }

    @Override
    public List<T> list(String hql) {
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<T> list(String hql, Object[] params) {
        Query query = getSession().createQuery(hql);
        //判断参数是否为空
        if (params != null && params.length > 0){
            for (int i = 0;i<params.length;i++){
                query.setParameter(i,params[i]);
            }
        }
        return query.list();
    }

    @Override
    public List<T> list(String hql, Object[] params, int pageIndex, int pageSize) {
        Query query = getSession().createQuery(hql);
        //判断参数是否为空
        if(params != null && params.length > 0){
            for (int i = 0;i<params.length;i++){
                query.setParameter(i,params[i]);
            }
        }
        return query.setFirstResult((pageIndex-1)*pageSize)
                .setMaxResults(pageSize).list();
    }

    @Override
    public Long count(String hql) {
        return (Long) getSession().createQuery(hql)
                .uniqueResult();
    }

    @Override
    public Long count(String hql, Object[] params) {
        Query query = getSession().createQuery(hql);
        //判断参数是否为空
        if(params != null && params.length>0){
            for(int i=0;i<params.length;i++){
                query.setParameter(i,params[i]);
            }
        }
        return (Long)query.uniqueResult();
    }
}









