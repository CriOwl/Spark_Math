package Data_Access.VIEW;


public class InstitutionViewDTO  {
    private Integer id_institution;
    private Integer id_manager;
    private String name;
    private String amie;
    private Integer state;
    private String name_column;
    private String name_manager;
    
    
    public String getName_manager() {
        return name_manager;
    }


    public void setName_manager(String name_manager) {
        this.name_manager = name_manager;
    }


    public InstitutionViewDTO() {
    }
    

    
    public InstitutionViewDTO(Integer id_institution, Integer id_manager, String name, String amie, Integer state) {
        this.id_institution = id_institution;
        this.id_manager = id_manager;
        this.name = name;
        this.amie = amie;
        this.state = state;
    }


    public InstitutionViewDTO(String name_column) {
        this.name_column = name_column;
    }


    public InstitutionViewDTO(String name, String amie) {
        this.name = name;
        this.amie = amie;
    }
    
    public InstitutionViewDTO(Integer id_institution, Integer id_manager, String name, String amie) {
        this.id_institution = id_institution;
        this.id_manager = id_manager;
        this.name = name;
        this.amie = amie;
    }


    public InstitutionViewDTO(Integer id_institution, String name, String amie, String name_manager) {
        this.id_institution = id_institution;
        this.name = name;
        this.amie = amie;
        this.name_manager = name_manager;
    }


    public InstitutionViewDTO(Integer id_institution, Integer id_manager, String name, String amie, Integer state,
            String name_column) {
        this.id_institution = id_institution;
        this.id_manager = id_manager;
        this.name = name;
        this.amie = amie;
        this.state = state;
        this.name_column = name_column;
    }


    public String getName_column() {
        return name_column;
    }

    public void setName_column(String name_column) {
        this.name_column = name_column;
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

    @Override
    public String toString(){
        return getClass().getName()
        +"\n Id_institution: "      + getId_institution()
        +"\n Nombre: "              + getName()
        +"\n Id_manager: "          + getId_manager()
        +"\n Amie "                 + getAmie()
        +"\n Nombre Columna: "      + getName_column()
        +"\n Estado: "              + getState();
    }

}
