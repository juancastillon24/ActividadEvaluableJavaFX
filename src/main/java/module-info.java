module org.example.actividadevaluablejfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens org.example.actividadevaluablejfx to javafx.fxml;
    exports org.example.actividadevaluablejfx;
    exports org.example.actividadevaluablejfx.utils;
    opens org.example.actividadevaluablejfx.utils to javafx.fxml;
    exports org.example.actividadevaluablejfx.controllers;
    opens org.example.actividadevaluablejfx.controllers to javafx.fxml;
    exports org.example.actividadevaluablejfx.model;
    opens org.example.actividadevaluablejfx.model to javafx.fxml;
}