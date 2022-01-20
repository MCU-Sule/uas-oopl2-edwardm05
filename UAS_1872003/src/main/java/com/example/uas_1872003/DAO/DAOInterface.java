package com.example.uas_1872003.DAO;

import java.util.List;
//1872003 - Edward Michael S
public interface DAOInterface<T> {

    public int addData(T data);
    public int delData(T data);
    public int updateData(T data);

    List<T> getAll();
}
