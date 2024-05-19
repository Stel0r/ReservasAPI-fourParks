package com.example.ReservasAPI.Repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.ReservasAPI.Logica.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,String>{
}
