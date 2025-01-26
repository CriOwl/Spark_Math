package Data_Access.DTO;

public class Game1DTO {
    private Integer id_game1;
    private String question;
    private String answer1;
    private String answer2;
    private Integer correct_answer;
    private Integer state;
    private String date_created;
    private String date_updated;

    public Game1DTO() {
    }

    public Game1DTO(String question, String answer1, String answer2, Integer correct_answer) {
        this.question           = question;
        this.answer1            = answer1;
        this.answer2            = answer2;
        this.correct_answer     = correct_answer;
    }

    public Game1DTO(Integer id_game1, String question, String answer1, String answer2, Integer correct_answer,
            Integer state, String date_created, String date_updated) {
        this.id_game1       = id_game1;
        this.question       = question;
        this.answer1        = answer1;
        this.answer2        = answer2;
        this.correct_answer = correct_answer;
        this.state          = state;
        this.date_created   = date_created;
        this.date_updated   = date_updated;
    }

    public Integer getId_game1() {
        return id_game1;
    }
    public void setId_game1(Integer id_game1) {
        this.id_game1 = id_game1;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer1() {
        return answer1;
    }
    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }
    public String getAnswer2() {
        return answer2;
    }
    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }
    public Integer getCorrect_answer() {
        return correct_answer;
    }
    public void setCorrect_answer(Integer correct_answer) {
        this.correct_answer = correct_answer;
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
        +"\n id_game1: "            +getId_game1()
        +"\n Pregunta: "            +getQuestion()
        +"\n Respuesta1: "          +getAnswer1()
        +"\n Respuesta2: "          +getAnswer2()
        +"\n Respuesta_Correcta: "  +getCorrect_answer()
        +"\n Estado: "              +getState()
        +"\n Fecha_creacion: "      +getDate_created()
        +"\n Fecha_modificacion: "  +getDate_updated();
    }
}
