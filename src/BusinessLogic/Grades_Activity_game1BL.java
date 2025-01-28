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

	public SexoDTO getByIdSexo(int id_grade_activity_game2) throws Exception{
		grades_Activity_game2 = gag2DAO.readBy(id_grade_activity_game2);
		return grades_Activity_game2;
	}

	public boolean create(Grades_Activity_game2 DTO Grades_Activity_game2DTO) throws Exception{
		return sgag2DAO.create(Grades_Activity_game2DTO);
	}

	public boolean update(Grades_Activity_game2 DTO Grades_Activity_game2DTO) throws Exception{
		return gag2DAO.update(Grades_Activity_game2DTO);
	}

	public boolean delete(Grades_Activity_game2 DTO Grades_Activity_game2DTO) throws Exception{
		return gag2DAO.delete(Grades_Activity_game2DTO);
	}

	public Integer getMaxRow() throws Exception{
		return gag2DAO.getMaxRow(Grades_Activity_game2DTO);
	}
}