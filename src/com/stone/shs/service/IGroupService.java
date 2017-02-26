package com.stone.shs.service;

import com.stone.shs.model.Group;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public interface IGroupService {
    public void save(Group group);
    public Group load(int id);
    public List<Group> list();
    public List<Group> list(int pageIndex, int pageSize);
}
