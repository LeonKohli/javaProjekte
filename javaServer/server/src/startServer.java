//Leon Kohlhaußen 
// 2022-12-06
// This is the main class 

public class startServer {
    public static void main(String[] args) {
        Thread t1 = new Thread(new halloServer(2000));
        t1.start();
        Thread t2 = new Thread(new dialogTestServer(3000));
        t2.start();
        Thread t3 = new Thread(new textDateiServer(4000));
        t3.start();
        Thread t4 = new Thread(new echoServer(5000));
        t4.start();

    }
}