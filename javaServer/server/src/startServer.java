//Leon Kohlhaußen 
// 2022-12-06
// This is the main class 

public class startServer {
    public static void main(String[] args)
    {
        Server server = new Server();
        server.start();
        ServerGUI serverGUI = new ServerGUI(server);
        serverGUI.start();
    }
}