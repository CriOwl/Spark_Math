package Data_Access.DTO;

public class InstitutionDTO {
    private Integer id_institution;
    private Integer id_manager;
    private String name;
    private String amie;
    private Integer state;
    private String date_created;
    private String date_updated;
    
    public InstitutionDTO() {
    }

    public InstitutionDTO(String amie, String date_created, String date_updated, Integer id_institution, Integer id_manager, String name, Integer state) {
        this.amie           = amie;
        this.date_created   = date_created;
        this.date_updated   = date_updated;
        this.id_institution = id_institution;
        this.id_manager     = id_manager;
        this.name           = name;
        this.state          = state;
    }

    public InstitutionDTO(String name, String amie) {
        this.name = name;
        this.amie = amie;
    }

    public Integer getId_institution() {
        return id_institution;
    }

    public void setId_institution(Integer id_institution) {
        this.id_institution = id_institution;
    }

    public Integer getId_manager() {
        return id_manager;
    }

    public void setId_manager(Integer id_manager) {
        this.id_manager = id_manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmie() {
        return amie;
    }

    public void setAmie(String amie) {
        this.amie = amie;
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
        +"\n Director: "              +getId_manager()
        +"\n Registro Unico: "        +getAmie()
        +"\n Nombre: "                +getName()
        +"\n Estado: "                +getState()
        +"\n Fecha_creacion: "        +getDate_created()
        +"\n Fecha_modificacion: "    +getDate_updated();
    }

}
