package Data_Access.DTO;

public class Grades_Activity_game1DTO {
    private Integer id_grade_activity_game1;
    private Integer id_student_course;
    private String  answer;
    private Integer id_game1;
    private Integer state;
    private String date_created;
    private String date_update;
    public Grades_Activity_game1DTO() {
    }
    public Grades_Activity_game1DTO(Integer id_grade_activity_game1, Integer id_student_course, String answer,
            Integer id_game1, Integer state, String date_created, String date_update) {
        this.id_grade_activity_game1 = id_grade_activity_game1;
        this.id_student_course = id_student_course;
        this.answer = answer;
        this.id_game1 = id_game1;
        this.state = state;
        this.date_created = date_created;
        this.date_update = date_update;
    }
    public Grades_Activity_game1DTO(Integer id_student_course, String answer, Integer id_game1) {
        this.id_student_course = id_student_course;
        this.answer = answer;
        this.id_game1 = id_game1;
    }
    public Integer getId_grade_activity_game1() {
        return id_grade_activity_game1;
    }
    public void setId_grade_activity_game1(Integer id_grade_activity_game1) {
        this.id_grade_activity_game1 = id_grade_activity_game1;
    }
    public Integer getId_student_course() {
        return id_student_course;
    }
    public void setId_student_course(Integer id_student_course) {
        this.id_student_course = id_student_course;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public Integer getId_game1() {
        return id_game1;
    }
    public void setId_game1(Integer id_game1) {
        this.id_game1 = id_game1;
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
        +"\n id_calificacion_activiadad_juego_1"+getId_grade_activity_game1()
        +"\n id_estudiante"+getId_student_course()
        +"\n id_respuesta"+getAnswer()
        +"\n id_juego1"+getId_game1()
        +"\n    estado"             +getState()
        +"\n Fecha_creacion"        +getDate_created()
        +"\n fecha_modificacion"    +getDate_update();
    }
    
}
