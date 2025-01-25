package Data_Access.DTO;

public class ActivityDTO {
    private Integer id_activity;
    private Integer id_course;
    private Integer id_catalog_activity_type;
    private String description;
    private Integer state;
    private String date_created;
    private String date_updated;

    public ActivityDTO() {
    }
    
    public ActivityDTO(Integer id_activity, Integer id_course, Integer id_catalog_activity_type, String description,
            Integer state, String date_created, String date_updated) {
        this.id_activity = id_activity;
        this.id_course = id_course;
        this.id_catalog_activity_type = id_catalog_activity_type;
        this.description = description;
        this.state = state;
        this.date_created = date_created;
        this.date_updated = date_updated;
    }

    public Integer getId_activity() {
        return id_activity;
    }

    public void setId_activity(Integer id_activity) {
        this.id_activity = id_activity;
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

    public String getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }

    @Override
    public String toString() {
        return getClass().getName() 
    +"\n    id_activity"                + getId_activity()
    +"\n    id_course"                  + getId_course()
    +"\n    id_catalog_activity_type"   + getId_catalog_activity_type()
    +"\n    description"                + getDescription()
    +"\n    state"                      + getState()
    +"\n    date_created"               + getDate_created()
    +"\n    date_updated"               + getDate_updated();
    }
}
