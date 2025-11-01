package br.senac.rj.backend.config;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.core.Application;

public class JaxRsApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        // adiciona recursos REST
        resources.add(br.senac.rj.backend.controller.AlunoController.class);
        resources.add(br.senac.rj.backend.controller.TurmaController.class);
        resources.add(br.senac.rj.backend.controller.UsuarioController.class);
        return resources;
    }
}
