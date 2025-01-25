package Data_Access.DTO;

public class Permission_roleDTO {
    private Integer id_permission_role;
    private Integer id_role;
    private Integer id_permission;
    private Integer state;
    private String date_created;
    private String date_updated;
    public Permission_roleDTO() {
    }
    public Permission_roleDTO(Integer id_permission_role, Integer id_role, Integer id_permission, Integer state,
            String date_created, String date_updated) {
        this.id_permission_role = id_permission_role;
        this.id_role = id_role;
        this.id_permission = id_permission;
        this.state = state;
        this.date_created = date_created;
        this.date_updated = date_updated;
    }
    
    public Integer getId_permission_role() {
        return id_permission_role;
    }
    public void setId_permission_role(Integer id_permission_role) {
        this.id_permission_role = id_permission_role;
    }
    public Integer getId_role() {
        return id_role;
    }
    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }
    public Integer getId_permission() {
        return id_permission;
    }
    public void setId_permission(Integer id_permission) {
        this.id_permission = id_permission;
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
        +"\n    id_permiso_role"        +getId_permission_role()
        +"\n    id_rol"                 +getId_role()
        +"\n    id_permiso"             +getId_permission()
        +"\n    Estado"                 +getState()
        +"\n    fecha_creacion"         +getDate_created()
        +"\n    fecha_modificacion"     +getDate_updated();
    }
}
