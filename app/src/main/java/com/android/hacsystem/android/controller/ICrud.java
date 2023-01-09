package com.android.hacsystem.android.controller;

import java.util.List;

public interface ICrud<T> {

    public boolean criar(T obj);

    public boolean alterar(T obj);

    public boolean delete(T obj);

    public List<T> listar();


}
