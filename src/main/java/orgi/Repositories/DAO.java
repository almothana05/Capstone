package orgi.Repositories;

import java.util.List;

public interface DAO<T> {
    public void save(T p);
    public T findById(Long id);
    public List<T> listAll();
    public void removeTuple(T p);
    public void removeById(Long id);

}
