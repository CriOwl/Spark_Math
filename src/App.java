import BusinessLogic.User;

public class App {
    public static void main(String[] args) throws Exception {
           /*  PersonDAO person=new PersonDAO();
            person.delete(11); */
            User system=new User();
            system.sistema(); 
            /* PermissionRoleDAO consulta=new PermissionRoleDAO();
            for (Permission_roleDTO registo : consulta.role_permission_read(1)) {
                System.out.println(registo.getPermission_name());
            } */
    }

}
