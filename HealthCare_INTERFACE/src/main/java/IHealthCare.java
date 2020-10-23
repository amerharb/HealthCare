import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHealthCare extends Remote{

    int diet(int age, int height, int weight, String gender) throws RemoteException;
    int exercise(int age, int height, int weight, String gender) throws RemoteException;
    boolean vitamins(int age, String gender) throws RemoteException;
}
