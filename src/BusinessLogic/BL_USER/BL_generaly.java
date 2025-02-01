package BusinessLogic.BL_USER;

import Data_Access.IVIEWDAO;
import java.util.List;
import java.util.function.Supplier;

public class BL_generaly<T> {
    private final IVIEWDAO<T> DAO;

    public BL_generaly(Supplier<IVIEWDAO<T>> supplier) {
        this.DAO = supplier.get();
    }

    public List<T> getAll() throws Exception {
        return DAO.readall();
    }

    public T getBy(String DNI) throws Exception {
        return DAO.readby(DNI);
    }

    public List<T> getColumn() throws Exception {
        return DAO.read_column();
    }
    public List<T> search(String DNI) throws Exception {
        return DAO.search_read(DNI);
    }
}
