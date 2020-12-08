
package tf_poo_20201;

import java.io.*;

import java.util.Calendar;
import java.util.StringTokenizer;



public abstract class Pessoa {
    private String numRegistro;
    private String nome;
    private Calendar dataNascimento;
    private String email;


    public Pessoa(String nome, String numRegistro, Calendar dataNascimento, String email) {
        this.nome = nome;
        this.numRegistro = numRegistro;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public boolean excluiPessoa(String numRegistro) throws IOException{
        FileReader autores = new FileReader("Arquivos/autores.txt");
        FileReader locadores = new FileReader("Arquivos/locadores/txt");

        BufferedReader inAutores = new BufferedReader(autores);
        BufferedReader inLocadores = new BufferedReader(locadores);

        String s;
        
        //percorrendo arquivo autores linha por linha.
        while((s = inAutores.readLine()) != null){
            //como cada linha em autores.txt possui os dados de um autor,
            //verifico se os quatro (quantidade de caracteres de um número de registro) 
            //primeiros caracteres da linha coincidem com o numRegistro recebido para executar a exclusão. 
            if(s.substring(0,4).equals(numRegistro)){
                s="";
                return true;
            }
        }

        //percorrendo arquivo locadores linha por linha.
        while((s = inLocadores.readLine()) != null){
            //como cada linha em locadores.txt possui os dados de um locador,
            //verifico se os quatro (quantidade de caracteres de um número de registro) 
            //primeiros caracteres da linha coincidem com o numRegistro recebido para executar a exclusão. 
            if(s.substring(0,1).equals(numRegistro)){
                s="";
                return true;
            }
        }

        //caso não encontre alguma pessoa com tal núemero de registro, retorna-se falso. Exclusão falha.
        return false;
    }

    public Object consultaPessoa(String numRegistro) throws IOException{
        FileReader autores = new FileReader("Arquivos/autores.txt");
        FileReader locadores = new FileReader("Arquivos/locadores/txt");

        BufferedReader inAutores = new BufferedReader(autores);
        BufferedReader inLocadores = new BufferedReader(locadores);

        String s;
        
        //percorrendo arquivo autores linha por linha.
        while((s = inAutores.readLine()) != null){
            if(s.substring(0,4).equals(numRegistro)){
                //Os comandos abaixo percorrerão a linha para pegar os dados do autor e criarão o objeto 
                //a ser retornado.
                String[] infosAutor;
                //Separando a String s com base no delimitador espaço.
                StringTokenizer tokenizer = new StringTokenizer(s, " ");
                int i=0;
                //Salvando cada sub string no vetor infosAutor para facilitar a criação do objeto autor a ser retornado.
                while (tokenizer.hasMoreElements()) {
                    infosAutor[i]=tokenizer.nextToken();
                    i++;
                }
                Autor autor = new Autor(infosAutor[0], infosAutor[1], infosAutor[2], infosAutor[3], infosAutor[4], infosAutor[5]);
                return autor;
            }
        }

        //percorrendo arquivo locadores linha por linha.
        while((s = inLocadores.readLine()) != null){
            if(s.substring(0,4).equals(numRegistro)){
                //Os comandos abaixo percorrerão a linha para pegar os dados do locador e criarão o objeto 
                //a ser retornado.
                String[] infosLocador;
                //Separando a String s com base no delimitador espaço.
                StringTokenizer tokenizer = new StringTokenizer(s, " ");
                int i=0;
                //Salvando cada sub string no vetor infosLocador para facilitar a criação do objeto locador a ser retornado.
                while (tokenizer.hasMoreElements()) {
                    infosLocador[i]=tokenizer.nextToken();
                    i++;
                }
                Locador locador = new Locador(infosLocador[0], infosLocador[1], infosLocador[2], infosLocador[3], infosLocador[4], infosLocador[5]);
                return locador;
            }
        }

        return false;
    }

    public String getNumRegistro() {
        return this.numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
