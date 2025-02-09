package Data_Access.VIEW;

public class CatalogoViewDTO{
    private Integer id_catalog;
    private String catalogo_name;
    private Integer id_catalog_level;
    private String name_catalog_level;
    private Integer state;
    private String name_column;

    public CatalogoViewDTO(){}

    

    public CatalogoViewDTO(Integer id_catalog, String catalogo_name, String name_catalog_level) {
        this.id_catalog = id_catalog;
        this.catalogo_name = catalogo_name;
        this.name_catalog_level = name_catalog_level;
    }

    public CatalogoViewDTO(String name_column) {
        this.name_column = name_column;
    }


    public CatalogoViewDTO(String catalogo_name, String name_catalog_level) {
        this.catalogo_name = catalogo_name;
        this.name_catalog_level = name_catalog_level;
    }


    public CatalogoViewDTO(Integer id_catalog, String catalogo_name, Integer id_catalog_level,
            String name_catalog_level, Integer state) {
        this.id_catalog = id_catalog;
        this.catalogo_name = catalogo_name;
        this.id_catalog_level = id_catalog_level;
        this.name_catalog_level = name_catalog_level;
        this.state = state;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId_catalog() {
        return id_catalog;
    }

    public void setId_catalog(Integer id_catalog) {
        this.id_catalog = id_catalog;
    }

    public String getCatalogo_name() {
        return catalogo_name;
    }

    public void setCatalogo_name(String catalogo_name) {
        this.catalogo_name = catalogo_name;
    }

    public Integer getId_catalog_level() {
        return id_catalog_level;
    }

    public void setId_catalog_level(Integer id_catalog_level) {
        this.id_catalog_level = id_catalog_level;
    }

    public String getName_catalog_level() {
        return name_catalog_level;
    }

    public void setName_catalog_level(String name_catalog_level) {
        this.name_catalog_level = name_catalog_level;
    }

    public String getName_column() {
        return name_column;
    }

    public void setName_column(String name_column) {
        this.name_column = name_column;
    }


    @Override
    public String toString(){
        return getClass().getName()
        +"\n Id_catalogo: "         + getId_catalog()
        +"\n Nombre: "              + getCatalogo_name()
        +"\n Id_catalogo_nivel: "   + getId_catalog_level()
        +"\n Nombre nivel: "        + getName_catalog_level()
        +"\n Nombre Columna: "      + getName_column()
        +"\n Estado: "              + getState();
    }

}
