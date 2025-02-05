package Data_Access.DTO;

public class PuntajeDTO {
    private Integer IdPuntaje;
    private Integer IdUsuario;
    private String FechaJuego;
    
    private Integer Aciertos;
    private Integer Errores;
    
    private String Estado;
    private String Fecha_creacion;
    private String Fecha_modificacion;
    
    
    public PuntajeDTO(){}
    
    public PuntajeDTO(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    public PuntajeDTO( Integer idUsuario, 
    Integer aciertos, Integer errores) {
        IdUsuario = idUsuario;
        Aciertos = aciertos;
        Errores = errores;
    }
    
    public PuntajeDTO( Integer idUsuario, 
    String fechaJuego, Integer aciertos, Integer errores) {
        IdUsuario = idUsuario;
        FechaJuego = fechaJuego;
        Aciertos = aciertos;
        Errores = errores;
    }

    public PuntajeDTO(Integer idPuntaje, Integer idUsuario,
    String fechaJuego, Integer aciertos, Integer errores,
    String estado, String fecha_creacion, String fecha_modificacion) {
        IdPuntaje = idPuntaje;
        IdUsuario = idUsuario;
        FechaJuego = fechaJuego;
        Aciertos = aciertos;
        Errores = errores;
        Estado = estado;
        Fecha_creacion = fecha_creacion;
        Fecha_modificacion = fecha_modificacion;
    }
    
    public Integer getIdPuntaje() {
        return IdPuntaje;
    }
    public void setIdPuntaje(Integer IdPuntaje) {
        this.IdPuntaje = IdPuntaje;
    }
    public Integer getIdUsuario() {
        return IdUsuario;
    }
    public void setIdUsuario(Integer IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getFechaJuego() {
        return FechaJuego;
    }

    public void setFechaJuego(String fechaJuego) {
        FechaJuego = fechaJuego;
    }
    public Integer getAciertos() {
        return Aciertos;
    }
    public void setAciertos(Integer Aciertos) {
        this.Aciertos = Aciertos;
    }
    
    public Integer getErrores() {
        return Errores;
    }
    public void setErrores(Integer id_catalogo_nive) {
        this.Errores = id_catalogo_nive;
    }


    public String getEstado() {
        return Estado;
    }
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    public String getFecha_creacion() {
        return Fecha_creacion;
    }
    public void setFecha_creacion(String Fecha_creacion) {
        this.Fecha_creacion = Fecha_creacion;
    }
    public String getFecha_modificacion() {
        return Fecha_modificacion;
    }
    public void setFecha_modificacion(String Fecha_modificacion) {
        this.Fecha_modificacion = Fecha_modificacion;
    }

    public String toString() {
        return getClass().getName()
        + "\n IdPuntaje:            " + getIdPuntaje()
        + "\n IdUsuario:            " + getIdUsuario()
        + "\n FechaJuego:           " + getFechaJuego()
        + "\n Aciertos:             " + getAciertos()
        + "\n Errores:              " + getErrores()

        + "\n Estado:               " + getEstado()
        + "\n FechaCreacion:        " + getFecha_creacion()
        + "\n Fecha_modificacion=   " + getFecha_modificacion();
    }
}
