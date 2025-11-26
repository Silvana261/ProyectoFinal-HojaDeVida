package com.pagina.Interfaces;
import com.pagina.Modelos.Perfil;


public interface IRepositorioPerfil {
    Perfil obtener();
    void guardar(Perfil perfil);
}