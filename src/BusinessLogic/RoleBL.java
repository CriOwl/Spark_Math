package BusinessLogic;

import java.util.List;

import Data_Access.DAO.RoleDAO;
import Data_Access.DTO.RoleDTO;
import java.util.List;
import java.util.ArrayList;

public class RoleBL{
	private RoleDTO role;
	private RoleDTO rDAO = new RoleDAO();

	public RoleBL(){}

	public List<RoleDTO> getAll() throws Exception{
		return rDAO.readAll();
	}

	public RoleDTO getByid_role(int id_role) throws Exception{
		role = rDAO.readBy(id_role);
		return role;
	}

	public boolean create(role DTO RoleDTO) throws Exception{
		return rDAO.create(RoleDTO);
	}

	public boolean update(Role DTO RoleDTO) throws Exception{
		return rDAO.update(RoleDTO);
	}

	public boolean delete(Role DTO RoleDTO) throws Exception{
		return rDAO.delete(RoleDTO);
	}

	public Integer getMaxRow() throws Exception{
		return rDAO.getMaxRow(RoleDTO);
	}
}