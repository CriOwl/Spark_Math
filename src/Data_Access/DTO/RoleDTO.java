package Data_Access.DTO;

public class RoleDTO {
    private Integer id_Role;
    private String name;
    private Integer state;
    private String date_created;
    private String date_update;
    private Integer id_hierarchy;
    private String name_hierarchy;

    public RoleDTO(Integer id_hierarchy) {
        this.id_hierarchy = id_hierarchy;
    }

    public RoleDTO(Integer id_Role, String name, Integer state, Integer id_hierarchy, String name_hierarchy) {
        this.id_Role = id_Role;
        this.id_hierarchy = id_hierarchy;
        this.name = name;
        this.name_hierarchy = name_hierarchy;
        this.state = state;
    }

    public Integer getId_hierarchy() {
        return id_hierarchy;
    }

    public void setId_hierarchy(Integer id_hierarchy) {
        this.id_hierarchy = id_hierarchy;
    }

    public RoleDTO(String name, Integer id_hierarchy, Integer state) {
        this.name = name;
        this.state = state;
        this.id_hierarchy = id_hierarchy;
    }
    public RoleDTO(Integer id_Role,String name, Integer id_hierarchy, Integer state) {
        this.id_Role = id_Role;
        this.name = name;
        this.state = state;
        this.id_hierarchy = id_hierarchy;
    }

    public RoleDTO() {
    }

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

    public RoleDTO(Integer id_Role, String name) {
        this.id_Role = id_Role;
        this.name = name;
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
    public String toString() {
        return getClass().getName()
                + "\n    id_role: " + getId_Role()
                + "\n    Nombre: " + getName()
                + "\n    Estado: " + getState()
                + "\n    Fecha_creacion: " + getDate_created()
                + "\n    Fecha_modificacion: " + getDate_update();
    }

    public String getName_hierarchy() {
        return name_hierarchy;
    }

    public void setName_hierarchy(String name_hierarchy) {
        this.name_hierarchy = name_hierarchy;
    }
}
