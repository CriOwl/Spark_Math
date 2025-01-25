package Data_Access.DTO;

public class Catalog_levelDTO {
    private Integer id_catalog_level;
    private String name;
    private Integer state;
    private String date_created;
    private String date_update;

    public Catalog_levelDTO() {
    }

    
    public Catalog_levelDTO(String name) {
        this.name = name;
    }
    
    public Catalog_levelDTO(Integer id_catalog_level, String name, Integer state, String date_created,
            String date_update) {
        this.id_catalog_level   = id_catalog_level;
        this.name               = name;
        this.state              = state;
        this.date_created       = date_created;
        this.date_update        = date_update;
    }

    public Integer getId_catalog_level() {
        return id_catalog_level;
    }

    public void setId_catalog_level(Integer id_catalog_level) {
        this.id_catalog_level = id_catalog_level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public String toString(){
        return getClass().getName()
        +"\n    id_catalog_level: "   +getId_catalog_level()
        +"\n    Nombre: "             +getName()
        +"\n    Estado: "             +getState()
        +"\n    Fecha_creacion: "     +getDate_created()
        +"\n    Fecha_modificacion: " +getDate_update();
    }
}
