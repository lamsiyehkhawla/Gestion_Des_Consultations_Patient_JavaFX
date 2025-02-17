package ma.enset.gestionconsultationdb.service;

import ma.enset.gestionconsultationdb.entities.Consultation;
import ma.enset.gestionconsultationdb.entities.Patient;

import java.util.List;

public class CabinetService implements ICabinetService{
    @Override
    public void addPatient(Patient patient) {

    }

    @Override
    public void deletePatient(Long id) {

    }

    @Override
    public void updatePatient(Patient patient) {

    }

    @Override
    public List<Patient> getAllPatients() {
        return List.of();
    }

    @Override
    public Patient getPatientById(Long id) {
        return null;
    }

    @Override
    public void addConsultation(Consultation consultation) {

    }

    @Override
    public void deleteConsultation(Long id) {

    }

    @Override
    public void updateConsultation(Consultation consultation) {

    }

    @Override
    public List<Consultation> getAllConsultations() {
        return List.of();
    }

    @Override
    public Consultation getConsultationById(Long id) {
        return null;
    }
}
