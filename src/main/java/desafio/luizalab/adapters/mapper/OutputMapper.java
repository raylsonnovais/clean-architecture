package desafio.luizalab.adapters.mapper;

public interface OutputMapper<T, E> {

    E fromEntity(T entity);
}

