package ma.enset.gestionconsultationdb.entities;

import java.sql.Date;

public class Consultation {
    private  long id;
    private Date dateConsultation;
    private String description;
    private Patient patient;

    public Consultation() {
    }

    public Consultation(Date dateConsultation, String description, Patient patient) {
        this.dateConsultation = dateConsultation;
        this.description = description;
        this.patient = patient;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getPatientId() {
        if (patient != null) {
            return patient.getId();  // Return the patient's ID if patient is not null
        }
        return -1;  // Return a default value if the patient is null
    }
}
