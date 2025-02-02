package BusinessLogic;

import java.util.List;

import Data_Access.DAO.DAO_C.InstitutionDAO;
import Data_Access.DTO.InstitutionDTO;

public class InstitutionBL{
	private InstitutionDTO institution;
	private InstitutionDTO sDAO = new InstitutionDAO();

	public InstitutionBL(){}

	public List<InstitutionDTO> getAll() throws Exception{
		return iDAO.readAll();
	}

	public InstitutionDTO getByid_institution(int id_institution) throws Exception{
		institution = iDAO.readBy(id_institution);
		return institution;
	}

	public boolean create(Institution DTO InstitutionDTO) throws Exception{
		return iDAO.create(InstitutionDTO);
	}

	public boolean update(Institution DTO InstitutionDTO) throws Exception{
		return iDAO.update(InstitutionDTO);
	}

	public boolean delete(Institution DTO InstitutionDTO) throws Exception{
		return iDAO.delete(InstitutionDTO);
	}

	public Integer getMaxRow() throws Exception{
		return iDAO.getMaxRow(InstitutionDTO);
	}
}