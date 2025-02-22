module ma.enset.gestionconsultationdb.gestionconsultationdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens ma.enset.gestionconsultationdb.controllers to javafx.fxml;
    opens ma.enset.gestionconsultationdb.entities to javafx.base, javafx.fxml;
    exports ma.enset.gestionconsultationdb;
}