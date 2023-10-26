package ServerPackage;
 import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Serveur {
	public static void main(String[] args) throws IOException {
		try {
		// création de l'objet ServerSockcet
		ServerSocket socketServeur = new ServerSocket(123);
		System.out.println("Le serveur attend la connexion d'un client");
		//attend la connexion de client 
		//création de l'objet Socket coté serveur suite a la connexion de client
		
		Socket socket = socketServeur.accept();
		System.out.println("Le client est connecté");
		
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		//attend de nombre x (l'entie envoyer par le client)
		System.out.println("j'attend un nbr x= ");
		int x = is.read();
		
		/*
		//le serveur calcul le produit x*5
		int nb = x*5;
		*/
		//le serveur envoie le résultat au client	
		System.out.println("la réponse = "+ x);
		
		int choix = is.read();
		int op;
		switch(choix) {
		case 1: System.out.println("le client selectionée l'opperation + ");
		op = x+5;
		os.write(op);
		break;
		case 2: System.out.println("le client selectionée l'operation - ");
		op = x-5;
		os.write(op);
		break;
		case 3 : System.out.println("le client selectionée l'opertion /");
		op = x/5;
		os.write(op);
		break;
		case 4 : System.out.println("\"le client selectionée l'opertion  *");
		op = x * 5 ;
		os.write(op);
		break;
		default: System.out.println("Retourne au client");
		}
		
		// fermer la socket
				socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
