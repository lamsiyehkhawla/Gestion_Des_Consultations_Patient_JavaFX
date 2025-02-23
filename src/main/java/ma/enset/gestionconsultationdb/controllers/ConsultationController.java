package ma.enset.gestionconsultationdb.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    @FXML
    private DatePicker dateConsultation;
    @FXML
    private ComboBox<Patient> comboPatient;
    @FXML
    private TextArea textFiledDescription;
    @FXML
    private TableView<Consultation> tableConsultation;
    @FXML
    private TableColumn columnId;
    @FXML
    private TableColumn<Consultation, Date> columnDateConsultation;
    @FXML
    private TableColumn<Consultation, String> columnDescription;
    @FXML
    private TableColumn<Consultation, String> columnPatient;
    private ICabinetService cabinetService;
    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    private ObservableList<Consultation> consultations = FXCollections.observableArrayList(); // Correct type
    private Consultation selectedConsultation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cabinetService = new CabinetService(new PatientDao(), new ConsultationDao());
        comboPatient.setItems(patients);
        patients.setAll(cabinetService.getAllPatients());
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnDateConsultation.setCellValueFactory(new PropertyValueFactory<>("dateConsultation"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        // Set the cell value factory for the Patient column to display the patient's ID
        columnPatient.setCellValueFactory(cellData -> new SimpleStringProperty(
                String.valueOf(cellData.getValue().getPatient().getNom())
        ));
        tableConsultation.setItems(consultations);
        loadConsultation();
        tableConsultation.getSelectionModel().selectedItemProperty().addListener((observable, oldConsultation, newConsultation) -> {
            if (newConsultation != null) {
                // Initialize or update the selectedConsultation when a new row is selected
                selectedConsultation = newConsultation;

                // Set the values to the UI elements (Date, Description, etc.)
                dateConsultation.setValue(newConsultation.getDateConsultation().toLocalDate());
                textFiledDescription.setText(newConsultation.getDescription());

                // If the selectedConsultation is not null, set its patient from the ComboBox
                if (selectedConsultation != null) {
                    selectedConsultation.setPatient(comboPatient.getSelectionModel().getSelectedItem());
                }

                // Optionally, select the patient in the ComboBox (this is useful if the ComboBox is populated based on the Consultation's patient)
                comboPatient.setItems(patients); // This could be done in the initialize() method already.
                comboPatient.getSelectionModel().select(newConsultation.getPatient());
            }
        });

    }

    public void addConsultation() {
        Consultation consultation = new Consultation();
        consultation.setDescription(textFiledDescription.getText());
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

    public void deleteConsultation() {
         Consultation consultation= tableConsultation.getSelectionModel().getSelectedItem();
        cabinetService.deleteConsultation(consultation);
        loadConsultation();
    }

    public void updateConsultation() {
        Consultation selectedConsultation = tableConsultation.getSelectionModel().getSelectedItem();

        if (selectedConsultation != null) {
            // Update the selected consultation with the new values
            selectedConsultation.setDescription(textFiledDescription.getText());
            selectedConsultation.setDateConsultation(Date.valueOf(dateConsultation.getValue()));
            selectedConsultation.setPatient(comboPatient.getSelectionModel().getSelectedItem());

            // Call the service to update the consultation in the database
            cabinetService.updateConsultation(selectedConsultation);

            // Refresh the table after update
            loadConsultation();
        }
    }
}
