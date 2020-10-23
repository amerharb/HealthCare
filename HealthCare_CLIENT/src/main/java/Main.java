import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        IHealthCare myHealthCare = (IHealthCare) Naming.lookup("rmi://localhost:1099/Recommender");

        System.out.println("connection estabtioned to Health Care Server");

        Scanner scanner = new Scanner(System.in);
        int age = readNumber("enter age:");
        int height = readNumber("enter height (cm):");
        int weight = readNumber("enter weight (kg):");
        String gender = readGender("enter gender (M/F):");

        int diet = myHealthCare.diet(age, height, weight, gender);
        System.out.println("diet is: " + diet);
    }

    private static int readNumber(String msg) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println(msg);
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("exit")) System.exit(0);
                return Integer.parseInt(line);
            } catch (Exception exception) {
                System.out.println("invalid try again");
            }
        } while (true);
    }

    private static String readGender(String msg) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println(msg);
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("exit")) System.exit(0);
                if (line.equalsIgnoreCase("m")) return "M";
                if (line.equalsIgnoreCase("f")) return "F";
                System.out.println("invalid try again");
            } catch (Exception exception) {
                System.out.println("invalid try again");
            }
        } while (true);
    }
}
