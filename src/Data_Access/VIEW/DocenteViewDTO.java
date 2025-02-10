package Data_Access.VIEW;

public class DocenteViewDTO {
    private Integer id;
    private String  profesor;
    private String  institucion;
    private String  amie;
    private String  periodo;
    private String  jornada;
    private String  curso;



    public DocenteViewDTO() {
    }

    public DocenteViewDTO(String profesor, String institucion, String amie, String periodo, String jornada, String curso) {
        this.profesor = profesor;
        this.institucion = institucion;
        this.amie = amie;
        this.periodo = periodo;
        this.jornada = jornada;
        this.curso = curso;
    }



    public DocenteViewDTO(Integer id, String profesor, String institucion, String amie, String periodo, String jornada,
            String curso) {
        this.id = id;
        this.profesor = profesor;
        this.institucion = institucion;
        this.amie = amie;
        this.periodo = periodo;
        this.jornada = jornada;
        this.curso = curso;
    }



    public DocenteViewDTO(String profesor) {
        this.profesor = profesor;
    }



    public DocenteViewDTO(Integer id_docente, String name, String last_name, int id_institution, int id_period,
            int id_jornada, int id_curso) {
        //TODO Auto-generated constructor stub
    }



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
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



    @Override
    public String toString() {
        return getClass().getName()
        + "\n Id:              "        + getId         ()
        + "\n Profesor:        "        + getProfesor   ()
        + "\n Institucion:     "        + getInstitucion()
        + "\n Amie:            "        + getAmie       ()
        + "\n Periodo:         "        + getPeriodo    ()
        + "\n Jornada:         "        + getJornada    ()
        + "\n Curso:           "        + getCurso      ();
    }

    public Object getName_column() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName_column'");
    }

   
    

}
