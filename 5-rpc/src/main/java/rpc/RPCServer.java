package rpc;
import java.io.*;
import java.net.*;




public class RPCServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println(" RPC server listening in port 5000...");

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new RPCHandler(socket)).start();
            }
        }
    }
}

class RPCHandler implements Runnable {
    private Socket socket;

    public RPCHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        ) {
            String methodName = dis.readUTF();

            if (methodName.equals("sumar")) {
                int params = dis.readInt();
                int []v = new int[params];
                for(int i = 0; i < params; i++)
                    v[i] = dis.readInt();
                int result = sumar(v);
                dos.writeInt(result);
            } else {
                dos.writeUTF("The method is not implemented");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // The method that will be called 
    public int sumar(int []v) {
        int res = 0;
        for(int i : v)
            res += i;
        return res;
    }
}
