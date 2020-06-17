//pacote
package servidortcp;

//importando a bibliotecas
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import clientetcp.Pessoa;

//classe Servidor TCP
public class ServidorTCP {

    public static void main(String[] args) {
        int porta = 11111;

        ObjectOutputStream saida;
        ObjectInputStream entrada;
        boolean sair = false;
        Pessoa p1 = new Pessoa();

        try {
            // criando um servidor
            ServerSocket servidor = new ServerSocket(porta, 20);
            
            while (!sair) {
                System.out.println("Ouvindo na porta: " + porta);

                // Ficará bloqueado até algum cliente se conectar
                Socket conexao;
                conexao = servidor.accept();
                threadservidor tc = new threadservidor();
                tc.setConexao(conexao);
				new Thread(tc).start();
            }

        } catch (IOException e) {
            System.err.println("Erro: " + e.toString());
            System.exit(0);
        }

    }
}
