package com.investigacion.operaciones.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "sucursal")
@Getter @Setter @NoArgsConstructor
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sucursal;

    @Column(name = "direccion_sucursal", length = 64)
    private String direccion_sucursal;

    @Column(name = "nombre_sucursal", length = 64)
    private String  nombre_sucursal;

    @Column(name = "ubicacion_sucursal", length = 64)
    private String ubicacion_sucursal;

    @Column(name = "estado", length = 1, insertable = false,
            columnDefinition = "default 'A'", updatable = false)
    private String estado;

    @Column(name = "usuario_creacion")
    private String usuario_creacion;// varchar(16),--usar dpi o nit

    @Column(name = "usuario_modificacion")
    private String usuario_modificacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", updatable = false, nullable = false, insertable = false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar fecha_creacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion", updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar fecha_modificacion;

}
