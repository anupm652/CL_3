import java.rmi.Naming;

public class StringConcatenatorClient {
    public static void main(String[] args) {
        try {
            int port = 1098; // Change the port if needed
            String url = "//localhost:" + port + "/StringConcatenator";
            
            // Look up the remote object from the RMI registry
            StringConcatenator concatService = (StringConcatenator) Naming.lookup(url);
            
            // Invoke the remote method
            String result = concatService.concatenateStrings("Hello, ", "world!");
            System.out.println("Concatenated String: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
