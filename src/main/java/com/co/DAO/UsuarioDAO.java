
package com.co.DAO;

import com.co.pojo.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioDAO extends CrudRepository <Usuario,Integer> {
       
}
