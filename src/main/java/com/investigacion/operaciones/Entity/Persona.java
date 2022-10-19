package com.investigacion.operaciones.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "persona")
@Getter @Setter
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_persona;

    @Column(name = "tipo_persona", length = 1, updatable = false)
    private String tipo_persona; //  --cliente o proveedor C, P

    @Column(name = "nombre_persona", length = 64)
    private String nombre_persona; // varchar(64),

    @Column(name = "nit", length = 11)
    private String nit;

    @Column(name = "direccion", length = 64)
    private String direccion;

    @Column(name = "celular", length = 16)
    private String celular;

    @Column(name = "telefono_fijo", length = 16)
    private String telefono_fijo;

    @Column(name = "pagina_web", length = 64)
    private String pagina_web; // varchar(64), --no aplica para cliente

    @Column(name = "estado", length = 1, insertable = false, updatable = false,
            columnDefinition = "default 'A'")
    private String estado; // char(1) default 'A',

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
