package BusinessLogic.BL_USER;

import Data_Access.DAO.DAO_C.IDAO;
import java.util.List;
import java.util.function.Supplier;

public class BL_generalyTable<T> {
    private final IDAO<T> dao;

    public BL_generalyTable(Supplier<IDAO<T>> suplier) {
        this.dao = suplier.get();
    }

    public List<T> getAll() throws Exception {
        return dao.readall();
    }

    public T getBy(Integer id) throws Exception {
        return dao.readby(id);
    }

    public List<T> getColumn() throws Exception {
        return dao.read_column();
    }

    public List<T> search(String DNI) throws Exception {
        return dao.search_read(DNI);
    }

    public List<T> read_elments() throws Exception {
        return dao.read_combobox();
    }

    public boolean cretated_elements(T entity) throws Exception {
        return dao.created(entity);
    }

    public boolean update_elements(T entity) throws Exception {
        return dao.update(entity);
    }

    public boolean delete(Integer id) throws Exception {
        return dao.delete(id);
    }

}
