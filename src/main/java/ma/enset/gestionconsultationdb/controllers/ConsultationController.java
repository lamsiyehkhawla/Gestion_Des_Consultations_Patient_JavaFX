package ma.enset.gestionconsultationdb.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.gestionconsultationdb.dao.ConsultationDao;
import ma.enset.gestionconsultationdb.dao.PatientDao;
import ma.enset.gestionconsultationdb.entities.Consultation;
import ma.enset.gestionconsultationdb.entities.Patient;
import ma.enset.gestionconsultationdb.service.CabinetService;
import ma.enset.gestionconsultationdb.service.ICabinetService;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ConsultationController implements Initializable {
    @FXML private DatePicker dateConsultation;
    @FXML private  ComboBox comboPatient;
    @FXML private TextArea testFiledDescription;
    @FXML private  TableView tableConsultation;
    @FXML private  TableColumn columnId;
    @FXML private  TableColumn columnDateConsultation;
    @FXML private  TableColumn columnDescription;
    @FXML private  TableColumn columnPatient;
    private ICabinetService cabinetService ;
    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    private ObservableList<Consultation> consultations = FXCollections.observableArrayList(); // Correct type


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cabinetService = new CabinetService(new PatientDao(),new ConsultationDao());
        comboPatient.setItems(patients);
        patients.setAll(cabinetService.getAllPatients());

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnDateConsultation.setCellValueFactory(new PropertyValueFactory<>("dateConsultation"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        columnPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));
        tableConsultation.setItems(consultations);
        loadConsultation();
    }
    public void addConsultation(){
        Consultation consultation = new Consultation();
        consultation.setDescription(testFiledDescription.getText());
        consultation.setDateConsultation(Date.valueOf(dateConsultation.getValue()));
        consultation.setPatient((Patient) comboPatient.getSelectionModel().getSelectedItem());
        cabinetService.addConsultation(consultation);
        loadConsultation();
    }

    private void loadConsultation() {
        List<Consultation> allConsultations = cabinetService.getAllConsultations();  // Returns List<Consultation>
        consultations.setAll(allConsultations);  // Set the ObservableList with the fetched data
        tableConsultation.setItems(consultations);  // Set the TableView items
    }

}
