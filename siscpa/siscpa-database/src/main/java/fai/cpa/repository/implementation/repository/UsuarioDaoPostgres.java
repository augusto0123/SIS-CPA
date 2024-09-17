package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.UsuarioModel;
import port.UsuarioRepositorty;

import java.util.List;
import java.util.Map;

public class UsuarioDaoPostgres implements UsuarioRepositorty {
    @Override
    public UsuarioModel findById(int id) {
        return null;
    }

    @Override
    public List<UsuarioModel> findAll() {
        return null;
    }

    @Override
    public List<UsuarioModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public boolean update(UsuarioModel usuarioModel) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public int create(UsuarioModel usuarioModel) {
        return 0;
    }
}
