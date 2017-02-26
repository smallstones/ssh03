package com.stone.shs.service;

import com.stone.shs.dao.IGroupDao;
import com.stone.shs.model.Group;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public class GroupService implements IGroupService {
    private IGroupDao groupDao;

    @Resource
    public void setGroupDao(IGroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public void save(Group group) {
        groupDao.add(group);
    }

    @Override
    public Group load(int id) {
        return groupDao.load(id);
    }

    @Override
    public List<Group> list() {
        String hql = "from Group";
        return groupDao.list(hql);
    }

    @Override
    public List<Group> list(int pageIndex, int pageSize) {
        String hql = "from Group";
        return groupDao.list(hql, null, pageIndex, pageSize);
    }
}