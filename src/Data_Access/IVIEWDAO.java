package Data_Access;

import java.util.List;

public interface  IVIEWDAO<T>{
    public T readby(Integer id) throws Exception;
    public List<T> readall()throws Exception;
}
