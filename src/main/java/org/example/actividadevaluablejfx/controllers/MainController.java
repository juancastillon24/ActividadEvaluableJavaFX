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
import java.util.ArrayList;
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

    private List<Usuario> usuarios = new ArrayList<>();

    private ObservableList<String> plataformas= FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private Label txtEror;


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
        if(txtCorreo.getText().isEmpty()){
            txtEror.setText("Faltan Datos");
        }
        else usuario.setCorreo(txtCorreo.getText());

        if(comboPlataforma.getValue().toString().isEmpty()){
            txtEror.setText("Faltan Datos");
        }
        else usuario.setPlataforma(comboPlataforma.getValue().toString());
        usuario.setIsAdmin(checkAdmin.isSelected());
        usuarios.add(usuario);
        refreshTable();
        txtCorreo.clear();
        comboPlataforma.getSelectionModel().clearSelection();
        checkAdmin.setSelected(false);


    }
}
