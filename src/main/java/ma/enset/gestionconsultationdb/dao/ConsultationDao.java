package ma.enset.gestionconsultationdb.dao;

import ma.enset.gestionconsultationdb.entities.Consultation;
import ma.enset.gestionconsultationdb.entities.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultationDao implements IConsultationDao {
    @Override
    public void create(Consultation consultation) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO consultations (DATE_CONSULTATION,DESCRIPTION,ID_PATIENT)" + "VALUE(?,?,?)");
        ps.setDate(1, consultation.getDateConsultation());
        ps.setString(2, consultation.getDescription());
        ps.setLong(3, consultation.getPatient().getId());
        ps.executeUpdate();//for insert request
    }

    @Override
    public void delete(Consultation consultation) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM consultations WHERE ID_CONSULTATION=?");
        ps.setLong(1, consultation.getId());
        ps.executeUpdate();
    }

    @Override
    public void update(Consultation consultation) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE consultations SET DATE_CONSULTATION=?,DESCRIPTION=? WHERE ID_CONSULTATION=?");
        ps.setDate(1, consultation.getDateConsultation());
        ps.setString(2, consultation.getDescription());
        ps.setLong(3, consultation.getId());
        ps.executeUpdate();
    }

    @Override
    public List<Consultation> findAll() throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "SELECT c.*, p.nom AS NOM FROM consultations c " +
                        "JOIN patients p ON c.ID_PATIENT = p.ID_PATIENT"
        );
        ResultSet rs = ps.executeQuery();
        List<Consultation> consultations = new ArrayList<>();
        while (rs.next()) {
            Consultation consultation = new Consultation();
            Patient patient = new Patient();
            consultation.setId(rs.getLong("ID_CONSULTATION"));
            consultation.setDateConsultation(rs.getDate("DATE_CONSULTATION"));
            consultation.setDescription(rs.getString("DESCRIPTION"));
            patient.setId(rs.getLong("ID_PATIENT"));
            patient.setNom(rs.getString("NOM")); // Set the patient's name
            consultation.setPatient(patient);
            consultations.add(consultation);
        }
        return consultations;
    }

    @Override
    public Consultation FindById(Long id) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM patients WHERE ID_CONSULTATION=?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        Consultation consultation = new Consultation();
        if (rs.next()) {
            consultation.setId(rs.getLong("ID_CONSULTATION"));
            consultation.setDateConsultation(rs.getDate("DATEC_ONSULTATION"));
            consultation.setDescription(rs.getString("DESCRIPTION"));
        }
        return consultation;
    }
}
