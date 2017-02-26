package com.stone.shs.dao;

import com.stone.shs.model.Group;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/2/22.
 */
public class GroupDao extends BaseDao<Group> implements IGroupDao{
    public static void main(String[] args){
        new GroupDao().execute();
    }

    public void execute(){
        //得到父类
        Type type = this.getClass().getGenericSuperclass();
        System.out.println(type+"----");
        ParameterizedType pt = (ParameterizedType)type;

        Type[] t = pt.getActualTypeArguments();
        System.out.println(t[0]+"------");
    }
}















