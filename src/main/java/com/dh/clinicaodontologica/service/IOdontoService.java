package com.dh.clinicaodontologica.service;


import java.util.List;
import java.util.Optional;

public interface IOdontoService<T> {
    T salvar(T t);
    List<T> buscarTodos();
    T buscarPorId(Integer id);
    boolean deletar(Integer id);
    T editar(T t);
    
}
