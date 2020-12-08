package tf_poo_20201;

public class Autor{
    private ArrayList<Livro> principaisObras;
    private String nacionalidade;
    
    public ArrayList<Livro> getPrincipaisObras() {
        return this.principaisObras;
    }

    public void setPrincipaisObras(ArrayList<Livro> principaisObras) {
        this.principaisObras = principaisObras;
    }

    public String getNacionalidade() {
        return this.nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
