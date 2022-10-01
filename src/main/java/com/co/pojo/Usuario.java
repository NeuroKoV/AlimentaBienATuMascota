
package com.co.pojo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
  
    @Id
    private Integer idusuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String user;
    private String password;
    
}
