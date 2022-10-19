package com.investigacion.operaciones.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    private int id_usuario;

    private String nombre;

    private String direccion;

    private String email;

    private String cui;

    private String username;

    private String clave;

    private String rol;

    private String estado;

    private int id_sucursal;

    private Calendar fecha_creacion;
}
