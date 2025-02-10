package Data_Access.VIEW;

public class EstudianteViewDTO {
    private Integer id_student_course;
    private String estudiante;
    private String dni;
    private String email;
    private String institucion;
    private String amie;
    private String periodo;
    private String jornada;
    private String curso;
    private String profesor;
    public String getProfesor() {
        return profesor;
    }
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    private Integer state;
    private String name_column;
    
    public EstudianteViewDTO(Integer id_student_course, String estudiante, String dni, String email, String institucion,
            String amie, String periodo, String jornada, String curso, Integer state) {
        this.id_student_course = id_student_course;
        this.estudiante = estudiante;
        this.dni = dni;
        this.email = email;
        this.institucion = institucion;
        this.amie = amie;
        this.periodo = periodo;
        this.jornada = jornada;
        this.curso = curso;
        this.state = state;
    }
    public EstudianteViewDTO(String name_column) {
        this.name_column = name_column;
    }

    public EstudianteViewDTO(Integer id_student_course, String estudiante, String dni, String email, String institucion,
            String amie, String periodo, String jornada, String curso, String profesor) {
        this.id_student_course = id_student_course;
        this.estudiante = estudiante;
        this.dni = dni;
        this.email = email;
        this.institucion = institucion;
        this.amie = amie;
        this.periodo = periodo;
        this.jornada = jornada;
        this.curso = curso;
        this.profesor = profesor;
    }

    public EstudianteViewDTO(){}
    
    
    public EstudianteViewDTO(Integer id_student_course, String estudiante, String dni, String email, String institucion,
            String amie, String periodo, String jornada, String curso, Integer state, String name_column) {
        this.id_student_course = id_student_course;
        this.estudiante = estudiante;
        this.dni = dni;
        this.email = email;
        this.institucion = institucion;
        this.amie = amie;
        this.periodo = periodo;
        this.jornada = jornada;
        this.curso = curso;
        this.state = state;
        this.name_column = name_column;
    }
    public Integer getId_student_course() {
        return id_student_course;
    }
    public void setId_student_course(Integer id_student_course) {
        this.id_student_course = id_student_course;
    }
    public String getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getInstitucion() {
        return institucion;
    }
    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
    public String getAmie() {
        return amie;
    }
    public void setAmie(String amie) {
        this.amie = amie;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public String getJornada() {
        return jornada;
    }
    public void setJornada(String jornada) {
        this.jornada = jornada;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
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



    
    
}
