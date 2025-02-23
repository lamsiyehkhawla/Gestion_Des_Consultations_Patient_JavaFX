package ma.enset.gestionconsultationdb.dao;

import ma.enset.gestionconsultationdb.entities.Patient;

import java.sql.SQLException;
import java.util.List;

public interface IPatientDao extends Dao<Patient,Long>{
    List<Patient> searchByQuery(String query) throws SQLException;


}
