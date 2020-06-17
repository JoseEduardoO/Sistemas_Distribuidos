//pacote
package clientetcp;

//importando as bibliotecas
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

//classe Cliente TCP

public class ClienteTCP {

    public static void main(String[] args) {
        String endereco = "localhost";
        int porta = 11111;
        ObjectOutputStream saida;
        ObjectInputStream entrada;
        Socket conexao;
        Scanner ler = new Scanner(System.in);
        Pessoa p = new Pessoa();
        try {
            conexao = new Socket(endereco, porta);
            System.out.println("Realizando a Conexão ao servidor " + endereco + ", na porta: " + porta);
            System.out.println("Digite: FIM para encerrar a conexao");

            // Obtendo as conexoes de saida e de entrada
            saida = new ObjectOutputStream(conexao.getOutputStream());
            entrada = new ObjectInputStream(conexao.getInputStream());

            do {
                // Realizando a leitura dos dados do objeto de saída
                System.out.print("..Digite o seu nome aluno: ");
                p.setNome(ler.next());
                System.out.print("..Digite a sua matricula: ");
                p.setMatricula(ler.nextInt());
                
                saida.writeObject(p);
                saida.flush();

                // Fazendo a leiturado do objeto alterado que foi enviado pelo servidor
                p = (Pessoa) entrada.readObject();
                System.out.println("Servidor>> \n" + p.toString());
                
                //Se digitar Fim, acaba encerrando o programa
            } while (!p.getNome().equals("FIM"));

            saida.close();
            entrada.close();
            conexao.close();
            
            //Caso de excessão para erros
        } catch (Exception e) {
            System.err.println("erro: " + e.toString());
        }
    }
}
