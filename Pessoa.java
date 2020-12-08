
package tf_poo_20201;

import java.util.Calendar;


public class Pessoa {
    private String nome;
    private String numRegistro;
    private Calendar dataNascimento;
    private String email;


    public Pessoa(String nome, String numRegistro, Calendar dataNascimento, String email) {
        this.nome = nome;
        this.numRegistro = numRegistro;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public void excluiPessoa(String numRegistro){
        
    }

    public void consultaPessoa(String numRegistro){

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumRegistro() {
        return this.numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
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
