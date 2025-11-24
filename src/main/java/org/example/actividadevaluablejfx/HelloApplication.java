package org.example.actividadevaluablejfx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.actividadevaluablejfx.utils.JavaFXUtil;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        JavaFXUtil.initStage(stage);
        JavaFXUtil.setScene("/org/example/actividadevaluablejfx/main-view.fxml");
    }
}
