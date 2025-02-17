package ma.enset.gestionconsultationdb.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao <E,U>{

    void create(E e) throws SQLException;
    void delete(U u) throws SQLException;
    void update(E e) throws SQLException;
    List<E> FindAll() throws SQLException;
    E FindById(U id) throws SQLException;
}
