package BusinessLogic;

import java.util.List;
import Data_Access.DAO.Grades_Activity_game1DAO;
import Data_Access.DTO.Grades_Activity_game1DTO;

public class Grades_Activity_game1BL{
	private Grades_Activity_game1DTO grades_Activity_game1;
	private Grades_Activity_game1DTO gag1DAO = new Grades_Activity_game1DAO();
	public Grades_Activity_game1BL(){}

	public List<Grades_Activity_game1DTO> getAll() throws Exception{
		return gag1DAO.readAll();
	}

	public SexoDTO getByid_grade_activity_game1(int id_grade_activity_game1) throws Exception{
		grades_Activity_game1 = gag1DAO.readBy(id_grade_activity_game1);
		return grades_Activity_game1;
	}

	public boolean create(Grades_Activity_game1 DTO Grades_Activity_game1DTO) throws Exception{
		return gag1DAO.create(Grades_Activity_game1DTO);
	}

	public boolean update(Grades_Activity_game1 DTO Grades_Activity_game1DTO) throws Exception{
		return gag1DAO.update(Grades_Activity_game1DTO);
	}

	public boolean delete(Grades_Activity_game1 DTO Grades_Activity_game1DTO) throws Exception{
		return gag1DAO.delete(Grades_Activity_game1DTO);
	}

	public Integer getMaxRow() throws Exception{
		return gag1DAO.getMaxRow(Grades_Activity_game1DTO);
	}
}
