package Data_Access.DTO;

public class Grades_Activity_game2DTO {
    private Integer id_grade_activity_game2;
    private Integer id_student_course;
    private String  answer1;
    private Integer id_game2;
    private Integer state;
    private String date_created;
    private String date_updated;

    public Grades_Activity_game2DTO() {
    }

    

    public Grades_Activity_game2DTO(Integer id_student_course, String answer1, Integer id_game2, Integer state,
            String date_created, String date_updated) {
        this.id_student_course  = id_student_course;
        this.answer1            = answer1;
        this.id_game2           = id_game2;
        this.state              = state;
        this.date_created       = date_created;
        this.date_updated        = date_updated;
    }



    public Grades_Activity_game2DTO(Integer id_student_course, String answer1, Integer id_game2) {
        this.id_student_course  = id_student_course;
        this.answer1            = answer1;
        this.id_game2           = id_game2;
    }

    public Grades_Activity_game2DTO(Integer id_grade_activity_game2, Integer id_student_course, String answer1,
            Integer id_game2, Integer state, String date_created, String date_updated) {
        this.id_grade_activity_game2    = id_grade_activity_game2;
        this.id_student_course          = id_student_course;
        this.answer1                    = answer1;
        this.id_game2                   = id_game2;
        this.state                      = state;
        this.date_created               = date_created;
        this.date_updated                = date_updated;
    }
    
    public Integer getId_grade_activity_game2() {
        return id_grade_activity_game2;
    }
    public void setId_grade_activity_game2(Integer id_grade_activity_game2) {
        this.id_grade_activity_game2 = id_grade_activity_game2;
    }
    public Integer getId_student_course() {
        return id_student_course;
    }
    public void setId_student_course(Integer id_student_course) {
        this.id_student_course = id_student_course;
    }
    public String getAnswer1() {
        return answer1;
    }
    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }
    public Integer getId_game1() {
        return id_game2;
    }
    public void setId_game1(Integer id_game2) {
        this.id_game2 = id_game2;
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
        +"\n    id_calificacion_activiadad_juego_2: "       +getId_grade_activity_game2()
        +"\n    id_estudiante: "                            +getId_student_course()
        +"\n    id_respuesta: "                             +getAnswer1()
        +"\n    id_juego2: "                                +getId_game1()
        +"\n    Estado: "                                   +getState()
        +"\n    Fecha_creacion: "                           +getDate_created()
        +"\n    Fecha_modificacion: "                       +getDate_updated();
    }

}