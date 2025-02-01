package BusinessLogic.BL_USER;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permisos{
    private final Map<String,Method> mapa_permisos;
    private final Method_permissions method;
    public Permisos(List<String> name_permisions,List<String> name_method) {
        this.mapa_permisos=new HashMap<>();
        this.method=new Method_permissions();
        try {
            System.out.println("cargando...metodos");
            for (int i = 0; i < name_permisions.size(); i++) {
                mapa_permisos.put(name_permisions.get(i), Method_permissions.class.getMethod(name_method.get(i)));
            }
        } catch (Exception e) {
            System.out.println("Existe un permiso que no cuenta con el metodo");
        }
    }
    public void ejecutarAccion(String permiso) {
        Method metodo = mapa_permisos.get(permiso);
        if (metodo != null) {
            try {
                metodo.invoke(method);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Acción no encontrada para el permiso: " + permiso);
        }
    }
    
}
