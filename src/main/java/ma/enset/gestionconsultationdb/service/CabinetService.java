package ma.enset.gestionconsultationdb.service;

import ma.enset.gestionconsultationdb.dao.IConsultationDao;
import ma.enset.gestionconsultationdb.dao.IPatientDao;
import ma.enset.gestionconsultationdb.entities.Consultation;
import ma.enset.gestionconsultationdb.entities.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CabinetService implements ICabinetService{

    private IPatientDao patientDao;
    private IConsultationDao consultationDao;

    public CabinetService(IPatientDao patientDao, IConsultationDao consultationDao) {
        this.patientDao = patientDao;
        this.consultationDao = consultationDao;
    }

    @Override
    public void addPatient(Patient patient) {
        try {
            patientDao.create(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePatient(Patient patient) {
        try {
            patientDao.delete(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePatient(Patient patient) {
        try {
            patientDao.update(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients;

        try {
            patients = patientDao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patients;
    }

    @Override
    public Patient getPatientById(Long id) {
        Patient patient = null;
        try {
            patient=patientDao.FindById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patient;
    }

    @Override
    public List<Patient> serachPatientByQuery(String query) {
        try {
            return patientDao.searchByQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void addConsultation(Consultation consultation) {
        try {
            consultationDao.create(consultation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void deleteConsultation(Consultation consultation) {
        try {
            consultationDao.delete(consultation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateConsultation(Consultation consultation) {
        try {
            consultationDao.update(consultation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Consultation> getAllConsultations() {
        List<Consultation> consultations = null;
        try {
            consultations= consultationDao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consultations;
    }


    @Override
    public Consultation getConsultationById(Long id) {
        return null;
    }
}
