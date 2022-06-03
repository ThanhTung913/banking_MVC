package com.cg.service;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(int id);

    void create(T t);

    boolean update(int id) throws SQLException;

    boolean remove(int id);

}
