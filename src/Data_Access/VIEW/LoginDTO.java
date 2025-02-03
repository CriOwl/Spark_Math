package Data_Access.VIEW;

public class LoginDTO {
    private Integer id_person;
    private String name;
    private String last_name;
    private String DNI;
    private String email;
    private String password;
    private Integer id_role;
    private String name_role;
    private Integer state;
    private String name_column;
    
    public LoginDTO() {
    }
    
<<<<<<< HEAD
    public LoginDTO(Integer id_person, String full_name, String dNI, String email, String password, Integer id_role,
            String name_role, Integer state) {
=======
    public LoginDTO(Integer id_person, String name, String last_name, String dNI, String email, String password,
            Integer id_role, String name_role, Integer state) {
>>>>>>> 424ffbe0808212f93b2f8038541ad4df898f3250
        this.id_person = id_person;
        this.name = name;
        this.last_name = last_name;
        DNI = dNI;
        this.email = email;
        this.password = password;
        this.id_role = id_role;
        this.name_role = name_role;
        this.state = state;
    }


    public LoginDTO(String name_column) {
        this.name_column = name_column;
    }


    public LoginDTO(Integer id_person, String name, String last_name, String dNI) {
        this.id_person = id_person;
        this.name = name;
        this.last_name = last_name;
        DNI = dNI;
    }


    public LoginDTO(Integer id_person, String name, String last_name, String dNI, String email, String password,
            Integer id_role) {
        this.id_person = id_person;
        this.name = name;
        this.last_name = last_name;
        DNI = dNI;
        this.email = email;
        this.password = password;
        this.id_role = id_role;
    }


    public Integer getId_person() {
        return id_person;
    }


    public void setId_person(Integer id_person) {
        this.id_person = id_person;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getLast_name() {
        return last_name;
    }


    public void setLast_name(String last_name) {
        this.last_name = last_name;
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


    public String getName_column() {
        return name_column;
    }


    public void setName_column(String name_column) {
        this.name_column = name_column;
    }


    @Override
    public String toString() {
        return getClass().getName()
        + "\n Id_persona: "           + getId_person()
        + "\n Nombre         : "      + getFull_name()
        + "\n Apellido       : "      + getFull_name()
        + "\n DNI: "                  + getDNI()
        + "\n Email: "                + getEmail()
        + "\n Clave: "                + getPassword()
        + "\n id_Role: "              + getId_role()
        + "\n Role: "                 + getName_role()
        + "\n Nombre Columna: "       + getName_column()
        + "\n Estado: "               + getState();
    }

   
    

}
