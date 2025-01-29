package BusinessLogic;

import java.util.List;
import Data_Access.DAO.CourseDAO;
import Data_Access.DTO.CourseDTO;

public class CourseBL{
	private CourseDTO course;
	private CourseDTO cDAO = new CourseDAO();

	public CourseBL(){}

	public List<CourseDTO> getAll() throws Exception{
		return cDAO.readAll();
	}

	public CourseDTO getByid_course(int id_course) throws Exception{
		course = cDAO.readBy(id_course);
		return course;
	}

	public boolean create(Course DTO CourseDTO) throws Exception{
		return cDAO.create(CourseDTO);
	}

	public boolean update(Course DTO CourseDTO) throws Exception{
		return cDAO.update(CourseDTO);
	}

	public boolean delete(Course DTO CourseDTO) throws Exception{
		return cDAO.delete(CourseDTO);
	}

	public Integer getMaxRow() throws Exception{
		return cDAO.getMaxRow(CourseDTO);
	}
}