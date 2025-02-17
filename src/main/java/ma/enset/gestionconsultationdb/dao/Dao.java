package ma.enset.gestionconsultationdb.dao;

import java.util.List;

public interface Dao <E,U>{

    void create(E e);
    void delete(U u);
    void update(E e);
    List<E> FindAll();
    E FindById(U id);
}
