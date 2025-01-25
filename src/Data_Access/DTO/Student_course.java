package Data_Access.DTO;

public class Student_course {
    private Integer id_student_course;
    private Integer id_student;
    private Integer id_course;
    private Integer state;
    private String date_created;
    private String date_update;

    public Student_course() {
    }

    public Student_course(Integer id_student_course, Integer id_student, Integer id_course, Integer state,
            String date_created, String date_update) {
        this.id_student_course  = id_student_course;
        this.id_student         = id_student;
        this.id_course          = id_course;
        this.state              = state;
        this.date_created       = date_created;
        this.date_update        = date_update;
    }
    
    public Student_course(Integer id_student, Integer id_course) {
        this.id_student = id_student;
        this.id_course  = id_course;
    }


    public Integer getId_student_course() {
        return id_student_course;
    }
    public void setId_student_course(Integer id_student_course) {
        this.id_student_course = id_student_course;
    }
    public Integer getId_student() {
        return id_student;
    }
    public void setId_student(Integer id_student) {
        this.id_student = id_student;
    }
    public Integer getId_course() {
        return id_course;
    }
    public void setId_course(Integer id_course) {
        this.id_course = id_course;
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
        +"\n    id_estudiante_curso: "       +getId_student_course()
        +"\n    id_estudiante: "             +getId_student()
        +"\n    id_curso: "                  +getId_course()
        +"\n    Estado: "                    +getState()
        +"\n    Fecha_creacion: "            +getDate_created()
        +"\n    Fecha_modificacion: "        +getDate_update();
    }
}
