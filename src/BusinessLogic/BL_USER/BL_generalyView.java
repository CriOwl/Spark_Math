package BusinessLogic.BL_USER;

import Data_Access.IVIEWDAO;
import java.util.List;
import java.util.function.Supplier;

public class BL_generalyView<T> {
    private final IVIEWDAO<T> DAO;

    public BL_generalyView(Supplier<IVIEWDAO<T>> supplier) {
        this.DAO = supplier.get();
    }

    public List<T> getAll() throws Exception {
        return DAO.readall();
    }

    public T getBy(String DNI) throws Exception {
        return DAO.readby(DNI);
    }
    public T getBy(Integer id) throws Exception {
        return DAO.readby(id);
    }

    public List<T> getColumn() throws Exception {
        return DAO.read_column();
    }
    public List<T> search(String DNI) throws Exception {
        return DAO.search_read(DNI);
    }
    public List<T> read_elments()throws Exception {
        return DAO.read_combobox();
    }
}
