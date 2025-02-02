package Data_Access.DTO;

public class PersonDTO {
    
    private Integer id_person;
    private String name;
    private String last_name;
    private String DNI;
    private String email;
    private String password;
    private String birthdate;
    private Integer id_role;
    private String name_role;
    private Integer state;
    private String date_created;
    private Integer id_institution;
    
    public PersonDTO(String name, String last_name, String dNI, String email, String password, String birthdate,
            Integer id_role, Integer id_institution) {
        this.name = name;
        this.last_name = last_name;
        DNI = dNI;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.id_role = id_role;
        this.id_institution = id_institution;
    }

    public Integer getId_institution() {
        return id_institution;
    }

    public void setId_institution(Integer id_institution) {
        this.id_institution = id_institution;
    }

    private String date_update;
    
    public PersonDTO() {
    }
    
    public PersonDTO(Integer id_person, String name, String last_name, String dNI, String email, String password,
            String birthdate, String name_role, Integer state, String date_created, String date_update) {
        this.id_person = id_person;
        this.name = name;
        this.last_name = last_name;
        DNI = dNI;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.name_role = name_role;
        this.state = state;
        this.date_created = date_created;
        this.date_update = date_update;
    }
    public PersonDTO(String name, String last_name, String DNI, String email, String password, String birthdate, Integer id_role) {
        this.name       = name;
        this.last_name  = last_name;
        this.DNI        = DNI;
        this.email      = email;
        this.password   = password;
        this.birthdate  = birthdate;
        this.id_role    = id_role;
    }

    public PersonDTO(Integer id_person, String name, String last_name, String dNI, String email, String password,
            String birthdate, Integer id_role, Integer state, String date_created,
            String date_update) {
        this.id_person      = id_person;
        this.name           = name;
        this.last_name      = last_name;
        this.DNI            = dNI;
        this.id_role        = id_role;
        this.email          = email;
        this.password       = password;
        this.birthdate      = birthdate;
        this.state          = state;
        this.date_created   = date_created;
        this.date_update    = date_update;
    }
    

    
    public PersonDTO(Integer id_person, String name, String last_name, String dNI,String password,
            Integer id_role) {
        this.id_person = id_person;
        this.name = name;
        this.last_name = last_name;
        DNI = dNI;
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

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getId_state() {
        return state;
    }

    public void setId_state(Integer state) {
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

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    @Override
    public String toString() {
        return getClass().getName()
        + "\n Id_persona: "           + getId_person()
        + "\n Nombre: "               + getName()
        + "\n Apellido: "             + getLast_name()
        + "\n DNI: "                  + getDNI()
        + "\n Email: "                + getEmail()
        + "\n Clave: "                + getPassword()
        + "\n Fecha_Nacimiento: "     + getBirthdate()
        + "\n id_Role: "              + getId_role()
        + "\n Role: "                 + getName_role()
        + "\n Estado: "               + getId_state()
        + "\n Fecha_creacion: "       + getDate_created()
        + "\n Fecha_modificacion: "   + getDate_update();
    }

    public String getName_role() {
        return name_role;
    }

    public void setName_role(String name_role) {
        this.name_role = name_role;
    }
}