package Data_Access.VIEW;

public class DocentesViewDTO {
    private Integer id_course;
    private String profesor;
    private String institucion;
    private String amie;
    private String periodo;
    private String jornada;
    private String curso;
    private Integer state;
    private String name_column;

    
    public DocentesViewDTO() {
    }

    public DocentesViewDTO(Integer id_course, String profesor, String institucion, String amie, String periodo, String jornada, String curso) {
        this.id_course = id_course;
        this.profesor = profesor;
        this.institucion = institucion;
        this.amie = amie;
        this.periodo = periodo;
        this.jornada = jornada;
        this.curso = curso;
    }

    public DocentesViewDTO(String name_column) {
        this.name_column = name_column;
    }

    

    public DocentesViewDTO(Integer id_course, String profesor, String institucion, String amie, String periodo,
            String jornada, String curso, Integer state) {
        this.id_course = id_course;
        this.profesor = profesor;
        this.institucion = institucion;
        this.amie = amie;
        this.periodo = periodo;
        this.jornada = jornada;
        this.curso = curso;
        this.state = state;
    }

    public DocentesViewDTO(Integer id_course, String profesor, String institucion, String amie, String periodo, String jornada,
            String curso, Integer state, String name_column) {
        this.id_course = id_course;
        this.profesor = profesor;
        this.institucion = institucion;
        this.amie = amie;
        this.periodo = periodo;
        this.jornada = jornada;
        this.curso = curso;
        this.state = state;
        this.name_column = name_column;
    }

    public Integer getId_course() {
        return id_course;
    }

    public void setId_course(Integer id_course) {
        this.id_course = id_course;
    }


    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
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

    public String getName_column() {
        return name_column;
    }

    public void setName_column(String name_column) {
        this.name_column = name_column;
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
        +"\n Id: "         + getId_course()
        +"\n Profesor: "   + getProfesor()
        +"\n Institucion: "+ getInstitucion()
        +"\n Amie: "       + getAmie()
        +"\n Periodo: "    + getPeriodo()
        +"\n Jornada: "    + getJornada()
        +"\n Curso: "      + getCurso()
        +"\n Estado: "      + getState()
        +"\n Name_column: "+ getName_column();
    }

    


}
