package ma.enset.gestionconsultationdb.service;

import ma.enset.gestionconsultationdb.dao.ConsultationDao;
import ma.enset.gestionconsultationdb.dao.PatientDao;
import ma.enset.gestionconsultationdb.entities.Patient;

import java.util.List;

public class ServiceTest {
    public static void main(String[] args) {
        ICabinetService service =new CabinetService(new PatientDao(), new ConsultationDao());
        //Patient patient = new Patient();
        //List<Patient> patients = service.getAllPatients();
        //for (Patient patient : patients) {
           // System.out.println(patient);
        //}
        Patient patient = service.getPatientById(1L);
        System.out.println(patient);
        patient.setTel("062541444");
        service.updatePatient(patient);
        System.out.println(patient);

    }

}
