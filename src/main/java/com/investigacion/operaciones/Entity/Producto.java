package com.investigacion.operaciones.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "producto")
@Getter @Setter
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;

    @Column(name = "nombre_producto", length = 64)
    private String nombre_producto; // varchar(64),

   /* @ManyToOne
    @Join*/@Column(name = "id_marca")
    private int id_marca;

    @Column //nombre de la marca
    private String descripcion;

    @Column(name = "linea", length = 64)
    private String linea;// varchar(64),

    @Column(name = "modelo")
    private int modelo;// int,

    @Column(name = "cilindraje")
    private int cilindraje; // int,

    @Column(name = "espec_tecnicas", length = 1000)
    private String espec_tecnicas; // varchar(1000),

    @Column(name = "existencias")
    private int existencias; // int,

    @Column(name = "precio")
    private Double precio; // numeric(8,2),

   /* @ManyToOne
    @Join*/@Column(name = "id_categoria")
    private int id_categoria; // int,

    @Column
    private String descripcion_cat;

    /*@ManyToOne
    @Join*/@Column(name = "id_usuario", updatable = false) //cambiar in
    private int id_usuario; // int,

    @Column(name = "nombre_usuario") //nombre del usuario en inner join
    private String nombre_usuario;

    /*@ManyToOne
    @Join*/@Column(name = "id_persona")
    private int id_persona; // int, --proveedor

   @Column
   private String nombre_persona;

    @Column(name = "estado", length = 1, insertable = false, updatable = false,
            columnDefinition = "default 'A'")
    private String estado;

    @Column(name = "usuario_creacion")
    private String usuario_creacion;// varchar(16),--usar dpi o nit

    @Column(name = "usuario_modificacion")
    private String usuario_modificacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", insertable = false, updatable = false, nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar fecha_creacion; // timestamp default current_timestamp,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion", insertable = false, updatable = false, nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar fecha_modificacion; // timestamp default current_timestamp,
}
