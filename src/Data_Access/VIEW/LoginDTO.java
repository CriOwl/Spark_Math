package Data_Access.VIEW;

public class LoginDTO {
    private Integer id_person;
    private String full_name;
    private String DNI;
    private String email;
    private String password;
    private Integer id_role;
    private String name_role;
    private Integer state;
    private String name_column;
    
    public LoginDTO(Integer id_person, String full_name, String dNI) {
        this.id_person = id_person;
        this.full_name = full_name;
        DNI = dNI;
    }
    public LoginDTO() {
    }
    public LoginDTO(Integer id_person, String full_name, String dNI, String email, String password, Integer id_role,
            String name_role, Integer state) {
        this.id_person = id_person;
        this.full_name = full_name;
        this.DNI = dNI;
        this.email = email;
        this.password = password;
        this.id_role = id_role;
        this.name_role = name_role;
        this.state = state;
    }

    public LoginDTO(String name_column) {
        this.name_column = name_column;
    }
    public Integer getId_person() {
        return id_person;
    }
    public void setId_person(Integer id_person) {
        this.id_person = id_person;
    }
    public String getFull_name() {
        return full_name;
    }
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String dNI) {
        DNI = dNI;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getId_role() {
        return id_role;
    }
    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }
    public String getName_role() {
        return name_role;
    }
    public void setName_role(String name_role) {
        this.name_role = name_role;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    @Override
    public String toString() {
        return getClass().getName()
        + "\n Id_persona: "           + getId_person()
        + "\n Nombre_completo: "      + getFull_name()
        + "\n DNI: "                  + getDNI()
        + "\n Email: "                + getEmail()
        + "\n Clave: "                + getPassword()
        + "\n id_Role: "              + getId_role()
        + "\n Role: "                 + getName_role()
        + "\n Nombre Columna: "       + getName_column()
        + "\n Estado: "               + getState();
    }

    public String getName_column() {
        return name_column;
    }

    public void setName_column(String name_column) {
        this.name_column = name_column;
    }
    

}
