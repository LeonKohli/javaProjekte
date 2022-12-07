
//Leon Kohlhaußen
// 2022-12-06
// 1.0
//the basic echo server configuration

//imports
import java.io.*;

public class echoServer extends BasisServer {
    // Spezielle Eigenschaften
    // Spezielles Verhalten

    @Override
    public void schreibeAntwort(PrintWriter stift) {
        stift.println();
        stift.println("Sie haben folgendes geschrieben:");
        stift.println("================================");
        stift.println(hoereFrage());
        stift.println("================================");
        stift.flush();

    }

    // Konstruktor
    public echoServer(int port) {
        super(port);
    }
}