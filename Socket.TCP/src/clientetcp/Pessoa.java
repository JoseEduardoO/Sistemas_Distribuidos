//pacote
package clientetcp;

//importando biblioteca

import java.io.Serializable;

 
// Criando a classe pessoa e implementando Serializable
public class Pessoa implements Serializable{
  
 //Tendo os atributos nome e matricula   
    
  private String nome;
  private int matricula;
  
  //Construtor da Classe Pessoa, tendo os atributos de nome e mátricula
  
  public Pessoa(String nome, int matricula){
    super();
    this.nome = nome;
    this.matricula = matricula;
  }
  
  public Pessoa(){
    super();
    this.nome = "";
    this.matricula = 0;
  }

  // Todos Gets e Sets do nome e da matricula
  
  public String getNome(){
    return nome;
  }
  
  public void setNome(String nome){
    this.nome = nome;
  }
  
  public int getMatricula() {
    return matricula;
 }

  public void setMatricula(int matricula) {
    this.matricula = matricula;
  }
  
  // Método String aonde vai conter o returno do nome e a matricula
  public String toString(){
    return this.nome  +"\n" + "Matricula: " + this.matricula;
  }

}