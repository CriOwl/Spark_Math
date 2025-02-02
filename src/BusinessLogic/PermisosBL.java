package BusinessLogic;

import java.util.List;
import Data_Acces.DAO.PermissionDAO;
import Data_Acces.DTO.PermissionDTO;
import java.security.Permission;
import java.util.Map;
import java.util.HashMap;

public class PermisosBL {
	private PermissionDTO Permission;
   	private PermissionDTO pDAO = new PermissionDAO();

  	public PermisosBL(){}

  	public List<PermissionDTO> getAll() throws Exception{
       		return pDAO.readAll();
   	}

   	public PermissionDTO getByid_role(int id_permission) throws Exception{
		Permission = pDAO.readBy(id_permission);
		return Permission;
	}

	public boolean create(Permission DTO PermissionDTO) throws Exception{
		return pDAO.create(PermissionDTO);
	}

	public boolean update(Permission DTO PermissionDTO) throws Exception{
		return pDAO.update(PermissionDTO);
	}

	public boolean delete(Permission DTO PermissionDTO) throws Exception{
		return pDAO.delete(PermissionDTO);
	}

	public Integer getMaxRow() throws Exception{
		return pDAO.getMaxRow(PermissionDTO);
	}
    
}
