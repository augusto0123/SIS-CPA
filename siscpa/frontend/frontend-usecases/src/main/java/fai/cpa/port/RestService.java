package fai.cpa.port;

import fai.cpa.entities.UsuarioModel;

import java.util.List;

public interface RestService <T> {
    List<T> get(final String resource);
    List<T> get(final String resource, final T entity);
    int post(final String resource, final T entity);

    UsuarioModel login(final String resource);

    boolean logout(final String resource);

    boolean put(final String resource, final T entity);

    boolean delete(final String resource);
    T getById(final String resource, Class<T> clazz);
}
