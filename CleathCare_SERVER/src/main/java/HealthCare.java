import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HealthCare extends UnicastRemoteObject implements IHealthCare{
    protected HealthCare() throws RemoteException {
       super();
    }

    public int diet(int age, int height, int weight, String gender) throws RemoteException {
        int result;
        if (age < 20) {
            result = 600;
        } else {
            result = 600 - (int) ( 3 * bmi(weight, height));
        }
        if (gender.equals("M")) result += 100;

        return result;
    }

    public int exercise(int age, int height, int weight, String gender) throws RemoteException {
        int result;
        if (age < 30) {
            result = 45;
        } else {
            result = 35 + (int) ( 2.3 * bmi(weight, height));
        }
        if (gender.equals("F")) result += 5;

        return result;
    }

    public boolean vitamins(int age, String gender) throws RemoteException {
        return gender.equals("F") || age > 40;
    }

    private double bmi(int weight, int height){
        double heightByMeter = (double) height / 100;
        return weight / (heightByMeter * heightByMeter);
    }
}
