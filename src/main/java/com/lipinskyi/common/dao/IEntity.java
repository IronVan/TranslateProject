package com.lipinskyi.common.dao;

import java.util.List;

public interface IEntity {
    List selectAll();
    Entity getEntityByID(int id);
}
