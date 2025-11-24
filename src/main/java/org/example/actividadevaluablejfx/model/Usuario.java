package org.example.actividadevaluablejfx.model;

import lombok.Data;

import java.util.Date;

@Data
public class Usuario {
    private String correo;
    private String plataforma;
    private Boolean isAdmin;
    private Date fecha;
}
