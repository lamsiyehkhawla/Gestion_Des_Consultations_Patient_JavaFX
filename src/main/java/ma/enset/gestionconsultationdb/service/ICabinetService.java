package ma.enset.gestionconsultationdb.service;

import ma.enset.gestionconsultationdb.entities.Consultation;
import ma.enset.gestionconsultationdb.entities.Patient;

import java.util.List;

public interface ICabinetService {
    //Funtions for Patient
    void addPatient(Patient patient);
    void deletePatient(Long id);
    void updatePatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);

    //Funtions for Consultation
    void addConsultation(Consultation consultation);
    void deleteConsultation(Long id);
    void updateConsultation(Consultation consultation);
    List<Consultation> getAllConsultations();
    Consultation getConsultationById(Long id);



}
