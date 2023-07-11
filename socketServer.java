import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class socketServer {
	
	private static ServerSocket server;
	private static int port = 8888;

	public static void main(String args[]) throws IOException, ClassNotFoundException {

		if (args.length == 1) {		
			port = Integer.parseInt(args[0]);
		}

		if (!(port >= 1024) && !(port <= 65536)) {
			throw new IndexOutOfBoundsException("Valor para socket precisa estar entre 1024 e 65536");
		}
		server = new ServerSocket(port);
	
		System.out.println("Ouvindo porta " + Integer.toString(port));
		System.out.println("Aguardando conexoes");		
			
		Socket socket = server.accept();

		while (!server.isClosed()) {

			Scanner entrada = new Scanner(socket.getInputStream());			
			
			while (entrada.hasNextLine()) {
				String mensagem = entrada.nextLine();
				System.out.println("Mensagem recebida: " + mensagem);

				if (mensagem.equalsIgnoreCase("sair")){
					System.out.println("Finalizando servidor");
					server.close();
				}
				
			}
		}
		
		socket.close();
	}
}
