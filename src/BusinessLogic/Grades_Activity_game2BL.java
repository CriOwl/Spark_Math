package BusinessLogic;

import java.util.List;
import Data_Access.DAO.Grades_Activity_game2DAO;
import Data_Access.DTO.Grades_Activity_game2DTO;

public class Grades_Activity_game2BL{
	private Grades_Activity_game2DTO grades_Activity_game2;
	private Grades_Activity_game2DTO gag2DAO = new Grades_Activity_game2DAO();

	public Grades_Activity_game2BL(){}

	public List<Grades_Activity_game2DTO> getAll() throws Exception{
		return gag2DAO.readAll();
	}

	public SexoDTO getByid_grade_activity_game2(int id_grade_activity_game2) throws Exception{
		grades_Activity_game2 = gag2DAO.readBy(id_grade_activity_game2);
		return grades_Activity_game2;
	}

	public boolean create(Grades_Activity_game2 DTO Grades_Activity_game2DTO) throws Exception{
		return gag2DAO.create(Grades_Activity_game2DTO);
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