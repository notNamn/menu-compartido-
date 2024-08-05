module inicio {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    exports inicio;
    exports inicio.controller;
    opens inicio.controller to javafx.fxml;
}

