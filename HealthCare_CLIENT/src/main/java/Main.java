import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        IHealthCare myHealthCare = (IHealthCare) Naming.lookup("rmi://localhost:1099/Recommender");

        int diet = myHealthCare.diet(40,170, 100, "F");
        System.out.println("diet is: " + diet);
    }
}
