package BusinessLogic;

import java.util.List;
import Data_Access.DAO.Game2DAO;
import Data_Access.DTO.Game2DTO;

public class Game2BL{
	private Game2DTO game2;
	private Game2DTO g2DAO = new Game2DAO();

	public Game2BL(){}

	public List<Game2DTO> getAll() throws Exception{
		return g2DAO.readAll();
	}

	public Game2DTO getByid_game2(int id_game2) throws Exception{
		game2 = g2DAO.readBy(id_game2);
		return game2;
	}

	public boolean create(Game2 DTO Game2DTO) throws Exception{
		return g2DAO.create(Game2DTO);
	}

	public boolean update(Game2 DTO Game2DTO) throws Exception{
		return g2DAO.update(Game2DTO);
	}

	public boolean delete(Game2 DTO Game2DTO) throws Exception{
		return g2DAO.delete(Game2DTO);
	}

	public Integer getMaxRow() throws Exception{
		return g2DAO.getMaxRow(Game2DTO);
	}
}