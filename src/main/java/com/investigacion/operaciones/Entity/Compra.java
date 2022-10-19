package com.investigacion.operaciones.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_compra;

    @Column(name = "id_persona")
    private int id_persona; // --proveedor

    @Column(name = "id_usuario")
    private int id_usuario; // --usuario que realiza ingreso

    @Column(name = "estado", length = 1, insertable = false, updatable = false,
            columnDefinition = "default 'A'")
    private String estado; // char(1) default 'A',

    @Column(name = "usuario_modificacion", length = 16)
    private String usuario_modificacion; //varchar(16), --usar dpi o nit

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", insertable = false, updatable = false, nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fecha_compra; //timestamp default current_timestamp,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion", insertable = false, updatable = false, nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date total_compra; //numeric(9,2) default 0.0,

}
