/**
 * Gestionaire des modules nécessaires et à exporter
 */
module org.example.sae_205_ordonnateur {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires jdk.compiler;
    requires java.xml;

    exports modele;
    exports vue;
    exports interfaces;
    exports exception;
}