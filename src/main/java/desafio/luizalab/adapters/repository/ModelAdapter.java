package desafio.luizalab.adapters.repository;

public interface ModelAdapter<T, E> {

    E toModel(T entity);

    T toEntity(E model);
}
