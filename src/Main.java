import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {
    public static void main(String[] args) {

    }

    private static void servidorUDPMensajes() throws IOException {
        byte[] bufer = new byte[1024];//para recibir el datagrama
        DatagramSocket socket = new DatagramSocket(5010);
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
        System.out.println("Server: esperando Datagrama .......... ");
        while (true) {
            socket.receive(recibo);//recibo datagrama
            int bytesRec = recibo.getLength();//obtengo numero de bytes
            String paquete = new String(recibo.getData());//obtengo String
            System.out.println("Server: numero de Bytes recibidos->" + bytesRec);
            System.out.println("Server: contenido del Paquete->" + paquete.trim());
            System.out.println("Server: puerto origen del mensaje->" + recibo.getPort());
            System.out.println("Server: IP de origen->" + recibo.getAddress().getHostAddress());
            System.out.println("Server: puerto destino del mensaje->" + socket.getLocalPort());
            System.out.println("=============================");
            break;
        }
        socket.close();
    }

}