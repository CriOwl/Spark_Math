package Data_Access.DTO;

public class CatalogDTO {
    private Integer id_catalog;
    private String name;
    private Integer id_catalog_level;
    private String name_catalog_type;
    private Integer state;
    private String date_created;
    private String date_update;

    public CatalogDTO() {
    }

    public CatalogDTO(Integer id_catalog, String name, Integer id_catalog_level, Integer state, String date_created,
            String date_update) {
        this.id_catalog = id_catalog;
        this.name = name;
        this.id_catalog_level = id_catalog_level;
        this.state = state;
        this.date_created = date_created;
        this.date_update = date_update;
    }

    public CatalogDTO(String name, Integer id_catalog_level) {
        this.name = name;
        this.id_catalog_level = id_catalog_level;
    }

    public CatalogDTO(Integer id_catalog, String name, Integer id_catalog_level, String name_catalog_type,Integer state) {
        this.id_catalog = id_catalog;
        this.id_catalog_level = id_catalog_level;
        this.name = name;
        this.name_catalog_type = name_catalog_type;
        this.state = state;
    }

    public Integer getId_catalog() {
        return id_catalog;
    }

    public void setId_catalog(Integer id_catalog) {
        this.id_catalog = id_catalog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId_catalog_level() {
        return id_catalog_level;
    }

    public void setId_catalog_level(Integer id_catalog_level) {
        this.id_catalog_level = id_catalog_level;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_update() {
        return date_update;
    }

    public void setDate_update(String date_update) {
        this.date_update = date_update;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n id_catalago: " + getId_catalog()
                + "\n Nombre: " + getName()
                + "\n id_catalogo_padre: " + getId_catalog_level()
                + "\n Estado: " + getState()
                + "\n Fecha_creacion: " + getDate_created()
                + "\n Fecha_modificacion: " + getDate_update();
    }

    public String getName_catalog_type() {
        return name_catalog_type;
    }

    public void setName_catalog_type(String name_catalog_type) {
        this.name_catalog_type = name_catalog_type;
    }
}
