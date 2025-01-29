package BusinessLogic;

import java.util.List;
import Data_Access.DAO.PersonDAO;
import Data_Access.DTO.PersonDTO;

public class PersonBL{
	private PersonDTO Person;
	private PersonDTO psDAO = new PersonDAO();

	public PersonBL(){}

	public List<PersonDTO> getAll() throws Exception{
		return psDAO.readAll();
	}

	public SexoDTO getByid_person(int id_person) throws Exception{
		Person = psDAO.readBy(id_person);
		return person;
	}

	public boolean create(Person DTO PersonDTO) throws Exception{
		return psDAO.create(PersonDTO);
	}

	public boolean update(Person DTO PersonDTO) throws Exception{
		return psDAO.update(PersonDTO);
	}

	public boolean delete(Person DTO PersonDTO) throws Exception{
		return psDAO.delete(PersonDTO);
	}

	public Integer getMaxRow() throws Exception{
		return psDAO.getMaxRow(PersonDTO);
	}
}
