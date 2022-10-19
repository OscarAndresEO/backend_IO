package com.investigacion.operaciones.Entity;

import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "marca")
@Getter @Setter
@NoArgsConstructor
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_marca;

    @Column(name = "descripcion", length = 64)
    private String descripcion;

    @Column(name = "estado", length = 1, insertable = false,
            columnDefinition = "default 'A'", updatable = false)
    private String estado;

    @Column(name = "usuario_creacion")
    private String usuario_creacion;// varchar(16),--usar dpi o nit

    @Column(name = "usuario_modificacion")
    private String usuario_modificacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false, insertable = false, updatable = false,
    columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar fecha_creacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion", nullable = false, insertable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar fecha_modificacion;
}
