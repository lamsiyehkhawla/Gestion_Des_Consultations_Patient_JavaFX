package ma.enset.gestionconsultationdb.service;

import ma.enset.gestionconsultationdb.entities.Consultation;
import ma.enset.gestionconsultationdb.entities.Patient;

import java.util.List;

public interface ICabinetService {
    //Funtions for Patient
    void addPatient(Patient patient);
    void deletePatient(Patient patient);
    void updatePatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    List<Patient> serachPatientByQuery(String query);
    //Funtions for Consultation
    void addConsultation(Consultation consultation);
    void deleteConsultation(Consultation consultation);
    void updateConsultation(Consultation consultation);
    List<Consultation> getAllConsultations();
    Consultation getConsultationById(Long id);



}
