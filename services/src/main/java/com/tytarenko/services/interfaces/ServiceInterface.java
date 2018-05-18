package com.tytarenko.services.interfaces;

import java.util.List;

public interface ServiceInterface<T> {

    List<T> get(String passport);
    List<T> getByReception(long id);
    void add(T object);

}
