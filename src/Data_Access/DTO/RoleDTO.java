package Data_Access.DTO;

public class RoleDTO {
    private Integer id_Role;
    private String name;
    private Integer state;
    private String date_created;
    private String date_update;

    public RoleDTO(String name) {
        this.name = name;
    }
    public RoleDTO(Integer id_Role, String name, Integer state, String date_created, String date_update) {
        this.id_Role = id_Role;
        this.name = name;
        this.state = state;
        this.date_created = date_created;
        this.date_update = date_update;
    }
    public RoleDTO() {
    }
    
    public Integer getId_Role() {
        return id_Role;
    }
    public void setId_Role(Integer id_Role) {
        this.id_Role = id_Role;
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
        +"\n    id_role"            +getId_Role()
        +"\n    nombre"             +getName()
        +"\n    fecha_creacion"     +getDate_created()
        +"\n    fecha_modificacion" +getDate_update();
    }
}
