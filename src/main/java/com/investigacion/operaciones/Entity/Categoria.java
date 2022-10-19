package com.investigacion.operaciones.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "categoria")
@Getter @Setter
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;

    @Column(name = "descripcion_cat", length = 64)
    private String descripcion_cat;

    @Column(name = "estado", length = 1, insertable = false, updatable = false, columnDefinition = "default 'A'")
    private String estado;// char(1) default 'A',

    @Column(name = "usuario_creacion")
    private String usuario_creacion;// varchar(16),--usar dpi o nit

    @Column(name = "usuario_modificacion")
    private String usuario_modificacion; // varchar(16), --usar dpi o nit

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", insertable = false, updatable = false, nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar fecha_creacion; // timestamp default current_timestamp,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion", insertable = false, updatable = false, nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar fecha_modificacion; // timestamp default current_timestamp,

}
