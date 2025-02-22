package ma.enset.gestionconsultationdb.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.gestionconsultationdb.dao.ConsultationDao;
import ma.enset.gestionconsultationdb.dao.PatientDao;
import ma.enset.gestionconsultationdb.entities.Patient;
import ma.enset.gestionconsultationdb.service.CabinetService;
import ma.enset.gestionconsultationdb.service.ICabinetService;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PatientController implements Initializable {


    @FXML private TextField textFiledNom;
    @FXML private TextField textFiledPrenom;
    @FXML private TextField textFiledTel;
    @FXML private TextField textFiledSearch;
    @FXML private TableView<Patient> tablePatients;
    @FXML private TableColumn<Patient,Long> columnId;
    @FXML private TableColumn<Patient,String> columnNom;
    @FXML private TableColumn<Patient,String>  columnPrenom;
    @FXML private TableColumn<Patient,String>  columnTel;
    @FXML private Label labelSuccess;

    private ICabinetService cabinetService ;

    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cabinetService = new CabinetService(new PatientDao(),new ConsultationDao());
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columnTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tablePatients.setItems(patients);
        loadPatients();
    }

    public void addPatient() {
        Patient patient = new Patient();
        patient.setNom(textFiledNom.getText());
        patient.setPrenom(textFiledPrenom.getText());
        patient.setTel(textFiledTel.getText());
        cabinetService.addPatient(patient);
        tablePatients.setItems(patients);
        loadPatients();
    }
    public void deletePatient() {
        Patient patient = tablePatients.getSelectionModel().getSelectedItem();
        cabinetService.deletePatient(patient);
        loadPatients();
        labelSuccess.setText("Patient deleted");
    }
    private void loadPatients() {
        patients.setAll(cabinetService.getAllPatients());

    }
    public void updatePatient() {
    }
}
