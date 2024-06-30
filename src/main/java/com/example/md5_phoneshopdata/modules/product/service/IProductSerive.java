package com.example.md5_phoneshopdata.modules.product.service;

import java.util.List;

public interface IProductSerive<T,E>  {
    List<T> findAll();
    T findById(E id);
    void save (T t);

    void delete(E id);
}
