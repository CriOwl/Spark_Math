package Data_Access.DTO;

public class CourseDTO {
    public CourseDTO(Integer id_course, String level, String parallel) {
        this.id_course = id_course;
        this.level = level;
        this.parallel = parallel;
    }

    private Integer id_course;
    private Integer id_teacher;
    private Integer id_catalog_level;
    private String  level;
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    private Integer id_catalog_parallel;
    private String  parallel;
    public String getParallel() {
        return parallel;
    }

    public void setParallel(String parallel) {
        this.parallel = parallel;
    }

    private Integer id_institution;
    private Integer id_catalog_time;
    private Integer id_catalog_period;
    private Integer state;
    private String date_created;
    private String date_update;

    public CourseDTO() {
    }
    
    public CourseDTO(Integer id_teacher, Integer id_catalog_level, Integer id_catalog_parallel, Integer id_institucion, Integer id_catalog_time,
            Integer id_catalog_period) {
        this.id_teacher             = id_teacher;
        this.id_catalog_level       = id_catalog_level;
        this.id_catalog_parallel    = id_catalog_parallel;
        this.id_institution         = id_institucion;
        this.id_catalog_time        = id_catalog_time;
        this.id_catalog_period      = id_catalog_period;
    }

    public CourseDTO(Integer id_course, Integer id_teacher, Integer id_catalog_level, Integer id_catalog_parallel,
            Integer id_institution, Integer id_catalog_time, Integer id_catalog_period, Integer state,
            String date_created, String date_update) {
        this.id_course              = id_course;
        this.id_teacher             = id_teacher;
        this.id_catalog_level       = id_catalog_level;
        this.id_catalog_parallel    = id_catalog_parallel;
        this.id_institution         = id_institution;
        this.id_catalog_time        = id_catalog_time;
        this.id_catalog_period      = id_catalog_period;
        this.state                  = state;
        this.date_created           = date_created;
        this.date_update            = date_update;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId_course() {
        return id_course;
    }

    public void setId_course(Integer id_course) {
        this.id_course = id_course;
    }

    public Integer getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(Integer id_teacher) {
        this.id_teacher = id_teacher;
    }

    public Integer getId_catalog_level() {
        return id_catalog_level;
    }

    public void setId_catalog_level(Integer id_catalog_level) {
        this.id_catalog_level = id_catalog_level;
    }

    public Integer getId_catalog_parallel() {
        return id_catalog_parallel;
    }

    public void setId_catalog_parallel(Integer id_catalog_parallel) {
        this.id_catalog_parallel = id_catalog_parallel;
    }

    public Integer getId_institution() {
        return id_institution;
    }

    public void setId_institution(Integer id_institution) {
        this.id_institution = id_institution;
    }

    public Integer getId_catalog_time() {
        return id_catalog_time;
    }

    public void setId_catalog_time(Integer id_catalog_time) {
        this.id_catalog_time = id_catalog_time;
    }

    public Integer getId_catalog_period() {
        return id_catalog_period;
    }

    public void setId_catalog_period(Integer id_catalog_period) {
        this.id_catalog_period = id_catalog_period;
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
        +"\n    id_curso: "               +getId_course()
        +"\n    id_profesor: "            +getId_teacher()
        +"\n    id_nivel: "               +getId_catalog_level()
        +"\n    id_paralelo: "            +getId_catalog_parallel()
        +"\n    id_institucion: "         +getId_institution()
        +"\n    id_jornada: "             +getId_catalog_time()
        +"\n    id_periodo: "             +getId_catalog_period()
        +"\n    Estado: "                 +getState()
        +"\n    Fecha_creacion: "         +getDate_created()
        +"\n    Fecha_modificacion: "     +getDate_update();
    }
}
