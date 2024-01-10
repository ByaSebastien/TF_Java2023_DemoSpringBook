package be.bstorm.tf_java2023_demospringbook.bll.services;


import java.util.List;

public interface CrudService<T,ID> {
    List<T> getAll();
    T getById(ID id);
    T insert(T entity);
    T update(ID id,T entity);
    void delete(ID id);
}
