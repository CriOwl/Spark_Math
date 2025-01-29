package BusinessLogic;

import java.util.List;
import Data_Access.DAO.Student_courseDAO;
import Data_Access.DTO.Student_courseDTO;

public class Student_courseBL{
	private Student_courseDTO Student_course;
	private Student_courseDTO scDAO = new Student_courseDAO();

	public Student_courseBL(){}

	public List<Student_courseDTO> getAll() throws Exception{
		return scDAO.readAll();
	}

	public Student_courseDTO getByIdSexo(int id_student_course) throws Exception{
		Student_course = scDAO.readBy(id_student_course);
		return Student_course;
	}

	public boolean create(Student_course DTO Student_courseDTO) throws Exception{
		return scDAO.create(Student_courseDTO);
	}

	public boolean update(Student_course DTO Student_courseDTO) throws Exception{
		return scDAO.update(Student_courseDTO);
	}

	public boolean delete(Student_course DTO Student_courseDTO) throws Exception{
		return scDAO.delete(Student_courseDTO);
	}

	public Integer getMaxRow() throws Exception{
		return scDAO.getMaxRow(Student_courseDTO);
	}
}