module com.pooespol.proyecto2pbedoyadiegoroldanjustyn {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.pooespol.proyecto2pbedoyadiegoroldanjustyn to javafx.fxml;
    exports com.pooespol.proyecto2pbedoyadiegoroldanjustyn;
}
