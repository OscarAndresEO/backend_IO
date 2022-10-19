package com.investigacion.operaciones.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="catalogo")
@Getter @Setter @NoArgsConstructor
public class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_catalogo;

    private String tipo_catalogo; //char(2),
    private String nombre_catalogo; //varchar(16),
    private String descripcion; //varchar(16),
    private String estado;
    private String usuario_creacion; //varchar(16),--usar dpi o nit
    private String usuario_modificacion; //varchar(16), --usar dpi o nit
    private Calendar fecha_creacion; //timestamp default current_timestamp,
    private Calendar fecha_modificacion; //timestamp default current_timestamp,
}
