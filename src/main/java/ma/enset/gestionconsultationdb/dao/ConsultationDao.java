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
        PreparedStatement ps = con.prepareStatement("INSERT INTO CONSULTATIONS(DATECONSULTATION,DESCRIPTION)" + "VALUE(?,?)");
        ps.setDate(1, consultation.getDateConsultation());
        ps.setString(1, consultation.getDescription());
        ps.executeUpdate();//for insert request
    }

    @Override
    public void delete(Consultation consultation) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM CONSULTATIONS WHERE ID_CONSULTATION=?");
        ps.setLong(1, consultation.getId());
        ps.executeUpdate();
    }

    @Override
    public void update(Consultation consultation) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE CONSULTATIONS SET DATECONSULTATION=?,DESCRIPTION=? WHERE ID_CONSULTATION=?");
        ps.setDate(1, consultation.getDateConsultation());
        ps.setString(2, consultation.getDescription());
        ps.setLong(3, consultation.getId());
        ps.executeUpdate();
    }

    @Override
    public List<Consultation> findAll() throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM CONSULTATIONS");
        ResultSet rs = ps.executeQuery();
        List<Consultation> consultations = new ArrayList<>();
        while (rs.next()) {
            Consultation consultation = new Consultation();
            consultation.setId(rs.getLong("ID_Consultation"));
            consultation.setDateConsultation(rs.getDate("DATECONSULTATION"));
            consultation.setDescription(rs.getString("DESCRIPTION"));
            consultations.add(consultation);
        }
        return consultations;
    }

    @Override
    public Consultation FindById(Long id) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM PATIENTS WHERE ID_CONSULTATION=?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        Consultation consultation = new Consultation();
        if (rs.next()) {
            consultation.setId(rs.getLong("ID_Consultation"));
            consultation.setDateConsultation(rs.getDate("DATECONSULTATION"));
            consultation.setDescription(rs.getString("DESCRIPTION"));
        }
        return consultation;
    }
}
