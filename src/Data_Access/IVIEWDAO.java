package Data_Access;

import java.util.List;

public interface IVIEWDAO<T>{
    public T readby(Integer id) throws Exception;
    public T readby(String id) throws Exception;
    public List<T> readall()throws Exception;
    public List<T> read_column()throws  Exception;
    public List<T> search_read(String DNI)throws  Exception;
    public List<T> read_combobox ()throws  Exception;
}
