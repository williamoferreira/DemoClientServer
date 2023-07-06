import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class socketServer {
	
	private static ServerSocket server;
	private static int port = 8888;

	public static void main(String args[]) throws IOException, ClassNotFoundException {

		server = new ServerSocket(port);
	
		System.out.println("Aguardando conexoes");		
			
		while (!server.isClosed()) {

			Socket socket = server.accept();			
			Scanner entrada = new Scanner(socket.getInputStream());			
			
			while (entrada.hasNextLine()) {
				String mensagem = entrada.nextLine();
				System.out.println("Mensagem recebida: " + mensagem);

				if (mensagem.equalsIgnoreCase("sair")){
					System.out.println("Finalizando servidor");
					server.close();
				}
				
			}

			socket.close();
		}
	}
}
