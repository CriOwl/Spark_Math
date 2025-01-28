package BusinessLogic;
import java.security.Permission;
import java.util.Map;
import java.util.HashMap;
public class Permisos {
    private final Map<String, Runnable> actionMap = new HashMap<>();
    
    public Permisos() {
        permisos_totales();
    }
    private void permisos_totales(){
        actionMap.put("Administrar Docente",this::management_teacher); 
        actionMap.put("Administrar Estudiantes",this::management_student);
        actionMap.put("Administrar Instituciones",this::management_institution);
        actionMap.put("Visualizar Reportes",this::view_report);
        actionMap.put("Administrar Rector",this::management_manage);
        actionMap.put("Realizar Actividades",this::management_Activity);
        actionMap.put("Administrar Pruebas Generales",this::management_general_test);
        actionMap.put("Administrar Pruebas Individuales",this::management_course_test);
        actionMap.put("Administrar Grados",this::management_course);
    }
    private void management_teacher(){
        has_permission();
    }
    private void management_student(){}
    private void management_institution(){}
    private void view_report(){}
    private void management_manage(){}
    private void management_Activity(){}
    private void management_general_test(){}
    private void management_course_test(){}
    private void management_course(){}

    private Runnable action(String permission){
        return actionMap.get(permission);
    }
    public void permission_action(Integer id_role, String permission){
        if()
    }
    
}
