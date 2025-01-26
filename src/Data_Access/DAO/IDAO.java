package Data_Access.DAO;
import java.util.List;
public interface IDAO<T>{
    public T readby(Integer id)throws Exception;
    public List<T> readall()throws Exception;
    public boolean created(T entity)throws Exception;
    public boolean update(T entity)throws Exception;
    public boolean delete(Integer id)throws Exception;
}