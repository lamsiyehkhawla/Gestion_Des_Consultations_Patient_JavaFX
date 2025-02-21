package ma.enset.gestionconsultationdb.dao;

import ma.enset.gestionconsultationdb.entities.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDao implements IPatientDao {

    @Override
    public void create(Patient patient) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO patients (NOM,PRENOM,tel)"+"VALUE(?,?,?)");
        ps.setString(1,patient.getNom());
        ps.setString(2,patient.getPrenom());
        ps.setString(3,patient.getTel());
        ps.executeUpdate();//for insert request

    }

    @Override
    public void delete(Patient patient) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM patients WHERE ID_PATIENT=?");
        ps.setLong(1,Patient.getId());
        ps.executeUpdate();
    }

    @Override
    public void update(Patient patient) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE patients SET NOM=?,PRENOM=?,tel=? WHERE ID_PATIENT=?");
        ps.setString(1,patient.getNom());
        ps.setString(2,patient.getPrenom());
        ps.setString(3,patient.getTel());
        ps.setLong(4,Patient.getId());
        ps.executeUpdate();
    }

    @Override
    public List<Patient> findAll() throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM patients");
        ResultSet rs = ps.executeQuery();
        List<Patient> patients = new ArrayList<>();
        while (rs.next()) {
            Patient patient = new Patient();
            patient.setId(rs.getLong("ID_PATIENT"));
            patient.setNom(rs.getString("NOM"));
            patient.setPrenom(rs.getString("PRENOM"));
            patient.setTel(rs.getString("TEL"));
            patients.add(patient);
        }
        return  patients;
    }

    @Override
    public Patient FindById(Long id) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM patients WHERE ID_PATIENT=?");
        ps.setLong(1,id);
        ResultSet rs = ps.executeQuery();
        Patient patient = new Patient();
        if (rs.next()) {
            patient.setId(rs.getLong("ID_PATIENT"));
            patient.setNom(rs.getString("NOM"));
            patient.setPrenom(rs.getString("PRENOM"));
            patient.setTel(rs.getString("TEL"));
        }
        return  patient;

    }
}
