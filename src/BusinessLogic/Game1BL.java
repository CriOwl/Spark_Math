package BusinessLogic;

import java.util.List;
import DataAccess.DAO.Game1DAO;
import DataAccess.DTO.Game1DTO;

public class Game1BL{
	private Game1DTO game1;
	private Game1DTO g1DAO = new Game1DAO();

	public Game1BL(){}

	public List<Game1DTO> getAll() throws Exception{
		return g1DAO.readAll();
	}

	public Game1DTO getByid_game1(int id_game1) throws Exception{
		game1 = g1DAO.readBy(id_game1);
		return game1;
	}

	public boolean create(Game1 DTO Game1DTO) throws Exception{
		return g1DAO.create(Game1DTO);
	}

	public boolean update(Game1 DTO Game1DTO) throws Exception{
		return g1DAO.update(Game1DTO);
	}

	public boolean delete(Game1 DTO Game1DTO) throws Exception{
		return g1DAO.delete(Game1DTO);
	}

	public Integer getMaxRow() throws Exception{
		return g1DAO.getMaxRow(Game1DTO);
	}
}