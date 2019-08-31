package com.X.MPR.Service.mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public interface Mapper <TEntity> {
	int add(TEntity t) throws SQLException, ClassNotFoundException;
    List<TEntity> getAll() throws SQLException, ClassNotFoundException;
    void remove(TEntity t) throws SQLException, ClassNotFoundException;
    ArrayList<TEntity> getById(int Id) throws SQLException, ClassNotFoundException;

}
