package Data_Access.DTO;

public class PermissionDTO {
    private Integer id_permission;
    private String name;
    private String description;
    private String name_method;
    private Integer state;
    private String date_created;
    private String date_updated;

    public PermissionDTO(String name, String description, String name_method) {
        this.name = name;
        this.description = description;
        this.name_method = name_method;
    }

    public String getName_method() {
        return name_method;
    }

    public void setName_method(String name_method) {
        this.name_method = name_method;
    }

    public PermissionDTO() {
    }

    public PermissionDTO(String name, String description) {
        this.name           = name;
        this.description    = description;
    }

    public PermissionDTO(Integer id_permission, String name, String description, Integer state, String date_created,
            String date_updated) {
        this.id_permission  = id_permission;
        this.name           = name;
        this.description    = description;
        this.state          = state;
        this.date_created   = date_created;
        this.date_updated   = date_updated;
    }
    public Integer getId_permission() {
        return id_permission;
    }
    public void setId_permission(Integer id_permission) {
        this.id_permission = id_permission;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public String getDate_updated() {
        return date_updated;
    }
    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }
    
    @Override
    public String toString(){
        return getClass().getName()
        +"\n    id_permiso: "             +getId_permission()
        +"\n    Nombre: "                 +getName()
        +"\n    Descripcion: "            +getDescription()
        +"\n    Metodo"                   +getName_method()
        +"\n    Estado: "                 +getState()
        +"\n    Fecha_creacion: "         +getDate_created()
        +"\n    Fecha_modificacion: "     +getDate_updated();
    }
}
