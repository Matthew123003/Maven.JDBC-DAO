package daos;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<T> {
    public T findById(int id) throws SQLException;
    public List<T> findAll() throws SQLException;
    public T update(T dto);
    public T create(T dto);
    public void delete(int id);
}
