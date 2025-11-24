package org.example.actividadevaluablejfx.controllers;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.actividadevaluablejfx.model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Stage stage;
    @javafx.fxml.FXML
    private TableColumn<Usuario,String> cPlataforma;
    @javafx.fxml.FXML
    private TableColumn<Usuario,String> cCorreo;
    @javafx.fxml.FXML
    private TableColumn<Usuario,Boolean> cAdministrador;
    @javafx.fxml.FXML
    private TableView tabla;
    @javafx.fxml.FXML
    private Button btnAñadir;
    @javafx.fxml.FXML
    private TextField txtCorreo;
    @javafx.fxml.FXML
    private ComboBox comboPlataforma;
    @javafx.fxml.FXML
    private CheckBox checkAdmin;

    private List<Usuario> usuarios;

    private ObservableList<String> plataformas= FXCollections.observableArrayList();

    public MainController(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cCorreo.setCellValueFactory((row)->{
            return new SimpleStringProperty(row.getValue().getCorreo().toString());
        });
        cPlataforma.setCellValueFactory((row)->{
            return new SimpleStringProperty(row.getValue().getPlataforma().toString());
        });
        cAdministrador.setCellValueFactory((row)->{
            return new SimpleBooleanProperty(row.getValue().getIsAdmin());
        });
        plataformas.addAll("Windows","Linux","MacOS");
        comboPlataforma.setItems(plataformas);


    }

    private void refreshTable(){
        tabla.getItems().clear();
        tabla.getItems().addAll(usuarios);
    }

    @javafx.fxml.FXML
    public void añadirUsuario(ActionEvent actionEvent) throws IOException {

        Usuario usuario = new Usuario();
        usuario.setCorreo(txtCorreo.getText());
        usuario.setPlataforma(comboPlataforma.getValue().toString());
        usuario.setIsAdmin(checkAdmin.isSelected());
        usuarios.add(usuario);
        tabla.getItems().addAll(usuarios);
        refreshTable();
    }
}
