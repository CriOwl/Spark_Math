package Data_Access.VIEW;

public class PermisoRoleViewDTO {

    private Integer id;
    private String rol;
    private String permiso;
    private String name_column;

    public PermisoRoleViewDTO() {
    }

    
    public PermisoRoleViewDTO(String name_column) {
        this.name_column = name_column;
    }


    public PermisoRoleViewDTO(Integer id, String rol, String permiso) {
        this.id = id;
        this.rol = rol;
        this.permiso = permiso;
    }

    public PermisoRoleViewDTO(Integer id, String rol, String permiso, String name_column) {
        this.id = id;
        this.rol = rol;
        this.permiso = permiso;
        this.name_column = name_column;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getName_column() {
        return name_column;
    }

    public void setName_column(String name_column) {
        this.name_column = name_column;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n Id: " + getId()
                + "\n Rol: " + getRol()
                + "\n Permiso: " + getPermiso()
                + "\n Name_column: " + getName_column();
    }

}
