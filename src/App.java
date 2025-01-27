import Data_Access.DAO.*;

public class App {
    public static void main(String[] args) throws Exception {
        // try {
        // PersonDAO pdsa = new PersonDAO();
        // for (PersonDTO asdasd : pdsa.readall()) {
        // System.out.println(asdasd.toString());
        // }
        // } catch (Exception e) {
        // } finally {
        // }
        Student_courseDAO asdasd = new Student_courseDAO();
        System.out.println(asdasd.readby(2).toString());
        
    }
}
