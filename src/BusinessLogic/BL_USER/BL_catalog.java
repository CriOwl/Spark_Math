package BusinessLogic.BL_USER;



import java.util.List;

import Data_Access.DAO.DAO_C.CatalogDAO;
import Data_Access.DTO.CatalogDTO;

public class BL_catalog {
    private CatalogDAO catalogdao;

    public BL_catalog(CatalogDAO catalog) {
        this.catalogdao = catalog;
    }

    public List<CatalogDTO> getAll() throws Exception {
        return catalogdao.readall();
    }

    public CatalogDTO getBy(Integer id) throws Exception {
        return catalogdao.readby(id);
    }

    public List<CatalogDTO> read_elments_role() throws Exception {
        return catalogdao.read_combobox_role();
    }

    public boolean cretated_elements(CatalogDTO entity) throws Exception {
        return catalogdao.created(entity);
    }

    public boolean update_elements(CatalogDTO entity) throws Exception {
        return catalogdao.update(entity);
    }

    public boolean delete(Integer id) throws Exception {
        return catalogdao.delete(id);
    }
    public CatalogDTO search_single(String DNI) throws Exception{
        return catalogdao.search_read_single(DNI);
    }

}
