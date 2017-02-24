package com.stone.shs.dao;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public interface IBaseDao<T> {
    public void add(T t);
    public void update(T t);
    public void delete(int id);
    public T load(int id);
    public List<T> list(String hal);
    public List<T> list(String hql, Object[] params);

    /**
     * 分页查询
     * @param hql
     * @param params
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<T> list(String hql,Object[] params,int pageIndex,int pageSize);

    /**
     * 获取总记录数
     * @param hql
     * @return
     */
    public Long count(String hql);
    public Long count(String hql,Object[] params);













}
