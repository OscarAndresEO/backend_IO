package com.investigacion.operaciones.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "usuario")
@Getter @Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Column(name = "nombre", length = 64)
    private String nombre;

    @Column(name = "direccion", length = 64)
    private String direccion;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "cui", length = 13)
    private String cui;

    @Column(name = "username", length = 16)
    private String username;

    @Column(name = "clave", length = 16)
    private String clave;

    @Column(name = "rol", length = 2)
    private String rol;


    @Column(name = "estado", length = 1, insertable = false,
            columnDefinition = "default 'A'", updatable = false)
    private String estado;

   /* @ManyToOne()
    @Join*/@Column(name = "id_sucursal")
    private Integer id_sucursal;

    @Column(name = "usuario_creacion")
    private String usuario_creacion;//varchar(16),--usar dpi o nit

    @Column(name = "usuario_modificacion")
    private String usuario_modificacion;// varchar(16),

    @Column(name = "nombre_sucursal")
    private String nombre_sucursal;

    @Column(name = "ubicacion_sucursal")
    private String ubicacion_sucursal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion",nullable = false, insertable = false, updatable = false,
            columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private Calendar fecha_creacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion", nullable = false, insertable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar fecha_modificacion;
}
