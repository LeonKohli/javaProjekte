//Leon Kohlhaußen 
// 2022-12-06
// This is the main class 

public class startServer {
    public static void main(String[] args) {
        // BasisServer server = new BasisServer(80);
        // server.verbindungMitClient();
        new BasisServer(80).verbindungMitClient();
    }
}