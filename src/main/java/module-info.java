module org.example.sae_205_ordonnateur {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires jdk.compiler;

    opens org.example.sae_205_ordonnateur to javafx.fxml;
    exports org.example.sae_205_ordonnateur;
    exports modele;
    exports vue;
}