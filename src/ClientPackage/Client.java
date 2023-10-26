package ClientPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			int op , choix =0 ;
			//création de l'objet socket coté client
			Socket socket = new Socket("localhost", 123);
			System.out.println("je suis connecté");
			
			//le client est demandé de taper un entier x au clavier
			Scanner sc = new Scanner(System.in);
			System.out.println("Donner un entier"+"\\n  " + "nb= ");
			int  x= sc.nextInt();
			
			//envoi cet entier au serveur
			OutputStream os = socket.getOutputStream();
			os.write(x);
			System.out.println("la reponse envoyer au serveur est: "+x);

			//choix de operation
			do {
				System.out.println("Menu: ");
				System.out.println("choix 1: addition");
				System.out.println("choix 2: soustraction");
				System.out.println("choix 3: division");
				System.out.println("choix 4: multiplication");
				
				System.out.println("Entrer vous choix: ");
				
				if( sc.hasNextInt()) {
					choix = sc.nextInt();
					sc.nextLine();
					if(choix < 1 || choix > 4 ) System.out.println("invalid il faut choisir 1, 2, 3 ou 4");
					
				}
				
			}
			while(choix < 1 || choix > 4);
			InputStream is = socket.getInputStream();
			switch (choix) {
			case 1: os.write(1);
					System.out.println("j'attend la reponse de serveur");
					op = is.read();
					System.out.println("resultat: "+ x +"+5="+op);
					break;
			case 2 : os.write(2);
					System.out.println("j'attend la reponse de serveur");
					op = is.read();
					System.out.println("resultat: "+ x +"- 5="+op);
					break;
			case 3: os.write(3);
					System.out.println("j'attend la reponse de serveur");
					op = is.read();
					System.out.println("resultat: "+ x +"/ 5="+op);
					break;
			case 4 :os.write(4);
					System.out.println("j'attend la reponse de serveur");
					op = is.read();
					System.out.println("resultat: "+ x +"* 5="+op);
					break;
			default: System.out.println("choix invalide");
			}
			
			// fermer la socket
			socket.close();
			
		}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}

