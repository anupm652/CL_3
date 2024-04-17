import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringConcatenatorImpl extends UnicastRemoteObject implements StringConcatenator {
    public StringConcatenatorImpl() throws RemoteException {
        super();
    }

    @Override
    public String concatenateStrings(String s1, String s2) throws RemoteException {
        return s1 + s2;
    }

    public static void main(String[] args) {
        try {
            int port = 1098; // Change the port if needed
            String url = "rmi://localhost:" + port + "/StringConcatenator";
            
            // Create the RMI registry on the specified port
            java.rmi.registry.LocateRegistry.createRegistry(port);

            // Create an instance of StringConcatenatorImpl and bind it to the registry
            StringConcatenatorImpl concatService = new StringConcatenatorImpl();
            Naming.rebind(url, concatService);
            
            System.out.println("Server ready at " + url);
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
