package com.example.demo.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.dao.ClienteDAO;

public class ClasePrincipal {
    public static void main(String[] args) {
        // Leer la configuracion de sprint
        AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
        // Obtener ell been del contenedor spring
        ClienteDAO elCliente = contexto.getBean("clienteDAO", ClienteDAO.class);
        // llamar metodo
        elCliente.insertarCliente();
        // cerraar contexto
        contexto.close();
    }    
}
