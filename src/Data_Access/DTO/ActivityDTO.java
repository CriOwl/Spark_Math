package Data_Access.DTO;

public class ActivityDTO {
    private Integer id_activity;
    private String name;
    private Integer id_course;
    private Integer id_catalog_activity_type;
    private String  description;
    private Integer state;
    private String date_created;
    private String date_update;
    
    public ActivityDTO(String name, Integer id_course, Integer id_catalog_activity_type, String description) {
        this.name = name;
        this.id_course = id_course;
        this.id_catalog_activity_type = id_catalog_activity_type;
        this.description = description;
    }

    public ActivityDTO() {
    }

    public ActivityDTO(Integer id_activity, String name, Integer id_course, Integer id_catalog_activity_type,
            String description, Integer state, String date_created, String date_update) {
        this.id_activity = id_activity;
        this.name = name;
        this.id_course = id_course;
        this.id_catalog_activity_type = id_catalog_activity_type;
        this.description = description;
        this.state = state;
        this.date_created = date_created;
        this.date_update = date_update;
    }

    public Integer getId_activity() {
        return id_activity;
    }

    public void setId_activity(Integer id_activity) {
        this.id_activity = id_activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId_course() {
        return id_course;
    }

    public void setId_course(Integer id_course) {
        this.id_course = id_course;
    }

    public Integer getId_catalog_activity_type() {
        return id_catalog_activity_type;
    }

    public void setId_catalog_activity_type(Integer id_catalog_activity_type) {
        this.id_catalog_activity_type = id_catalog_activity_type;
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

    public String getDate_update() {
        return date_update;
    }

    public void setDate_update(String date_update) {
        this.date_update = date_update;
    }
    @Override
    public String toString(){
        return getClass().getName()
        +"\n id_actividad"          +getId_activity()
        +"\n nombre"                +getName()
        +"\n id_curso"              +getId_course()
        +"\n Tipo_de_actividad"     +getId_catalog_activity_type()
        +"\n Descripcion"           +getDescription()
        +"\n    estado"             +getState()
        +"\n Fecha_creacion"        +getDate_created()
        +"\n fecha_modificacion"    +getDate_update();
    }
}