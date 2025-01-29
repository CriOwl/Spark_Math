package BusinessLogic;

import java.util.List;
import Data_Access.DAO.PermissionRoleDAO;
import Data_Access.DTO.Permission_roleDTO;

public class SexoBL{
	private Permission_roleDTO Permission_role;
	private Permission_roleDTO prDAO = new PermissionRoleDAO();

	public Permission_roleBL(){}

	public List<Permission_roleDTO> getAll() throws Exception{
		return prDAO.readAll();
	}

	public Permission_roleDTO getByid_permission_role(int id_permission_role) throws Exception{
		Permission_role = prDAO.readBy(id_permission_role);
		return Permission_role;
	}

	public boolean create(Permission_role DTO Permission_roleDTO) throws Exception{
		return prDAO.create(Permission_roleDTO);
	}

	public boolean update(Permission_role DTO Permission_roleDTO) throws Exception{
		return prDAO.update(Permission_roleDTO);
	}

	public boolean delete(Permission_role DTO Permission_roleDTO) throws Exception{
		return prDAO.delete(Permission_roleDTO);
	}

	public Integer getMaxRow() throws Exception{
		return prDAO.getMaxRow(Permission_roleDTO);
	}
}