package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.AlunoDao;
import br.senac.rj.backend.entity.Aluno;

import jakarta.ws.rs.core.Response;

public class AlunoService {
    private final AlunoDao dao = new AlunoDao();

    public Response salvar(Aluno aluno) {
        Aluno alunoSalvo = dao.salvar(aluno);
        if (alunoSalvo == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(alunoSalvo).build();
    }

    public Response buscar(Long id) {
        Aluno AlunoObtido = dao.buscarPorId(id);
        if (AlunoObtido == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(AlunoObtido).build();
    }
}
