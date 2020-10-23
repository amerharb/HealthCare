import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String [] args) throws RemoteException{

        HealthCare healthCare = new HealthCare();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("Recommender", healthCare);
    }
}
