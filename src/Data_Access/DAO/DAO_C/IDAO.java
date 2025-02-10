package Data_Access.DAO.DAO_C;
import java.util.List;

import Data_Access.DTO.Student_courseDTO;
public interface IDAO<T>{
    public T readby(Integer id)throws Exception;
    public List<T> readall()throws Exception;
    public List<T> read_combobox()throws Exception;
    public List<T> read_combobox2()throws Exception;
    public boolean created(T entity)throws Exception;
    public boolean update(T entity)throws Exception;
    public List<T> read_column()throws  Exception;
    public List<T> search_read(String DNI)throws  Exception;
    public T search_read_single(String DNI)throws  Exception;
    public boolean delete(Integer id)throws Exception;
    
}