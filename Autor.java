package tf_poo_20201;

import java.io.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Autor extends Pessoa {
    private String principaisObras;
    private String nacionalidade;

    public Autor(String numRegistro, String nome, Date dataNascimento, String email, String principaisObras,
            String nacionalidade) {
        super(numRegistro, nome, dataNascimento, email);
        this.principaisObras = principaisObras;
        this.nacionalidade = nacionalidade;
    }

    public boolean cadastra(Autor autor) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        try {
            File arquivo = new File("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/autores.txt");
            FileWriter autores = new FileWriter(arquivo, true);
            PrintWriter out = new PrintWriter(autores);
            out.println(super.getNumRegistro());
            out.println(super.getNome());
            out.println(formatador.format(super.getDataNascimento()));
            out.println(super.getEmail());
            out.println(this.principaisObras);
            out.println(this.nacionalidade);

            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean exclui(String numRegistro) throws IOException {
        try {

            File arquivoOriginal = new File("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/autores.txt");
            FileReader autoresOriginal = new FileReader(arquivoOriginal);
            BufferedReader in = new BufferedReader(autoresOriginal);

            File arquivoNovo = new File("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/autoresAux.txt");
            FileWriter autoresNovo = new FileWriter(arquivoNovo);
            PrintWriter out = new PrintWriter(autoresNovo);

            String s;
            while ((s = in.readLine()) != null) {
                if (s.equals(numRegistro)) {
                    for (int i = 0; i < 5; i++)
                        s = in.readLine();
                } else {
                    out.println(s);
                    out.flush();
                }
            }
            in.close();
            out.close();

            if (arquivoOriginal.exists()) {
                arquivoOriginal.delete();
            }

            arquivoNovo.renameTo(arquivoOriginal);

            return true;
        } catch (IOException e) {
            System.out.print("Erro: " + e);
            return false;
        }
    }

    @Override
    public Object consulta(String numRegistro) throws IOException {
        try {
            FileReader autores = new FileReader("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/autores.txt");
            BufferedReader in = new BufferedReader(autores);

            String s;
            while ((s = in.readLine()) != null) {
                if (s.equals(numRegistro)) {

                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date data;

                    try {
                        String numRegistroLocal = s;
                        String nome = in.readLine();
                        data = (Date) formato.parse(in.readLine());
                        String email = in.readLine();
                        String principaisObras = in.readLine();
                        String nacionalidade = in.readLine();

                        return new Autor(numRegistroLocal, nome, data, email, principaisObras, nacionalidade);

                    } catch (ParseException e) {
                        System.out.println("Erro: " + e);
                    }

                }
            }

            in.close();

            return true;
        } catch (IOException e) {
            System.out.print("Erro: " + e);
            return false;
        }
    }

    public boolean altera(Autor autor) throws IOException {
        try {

            File arquivoOriginal = new File("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/autores.txt");
            FileReader autoresOriginal = new FileReader(arquivoOriginal);
            BufferedReader in = new BufferedReader(autoresOriginal);

            File arquivoNovo = new File("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/autoresAux.txt");
            FileWriter autoresNovo = new FileWriter(arquivoNovo);
            PrintWriter out = new PrintWriter(autoresNovo);

            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String s;
            while ((s = in.readLine()) != null) {

                if (s.equals(autor.getNumRegistro())) {
                    s = autor.getNumRegistro();
                    out.println(s);
                    out.flush();

                    s = in.readLine();
                    s = autor.getNome();
                    out.println(s);
                    out.flush();

                    s = in.readLine();
                    s = formatador.format(autor.getDataNascimento());
                    out.println(s);
                    out.flush();

                    s = in.readLine();
                    s = autor.getEmail();
                    out.println(s);
                    out.flush();

                    s = in.readLine();
                    s = autor.getPrincipaisObras();
                    out.println(s);
                    out.flush();

                    s = in.readLine();
                    s = autor.getNacionalidade();
                    out.println(s);
                    out.flush();
                } else {
                    out.println(s);
                    out.flush();
                }

            }
            in.close();
            out.close();

            if (arquivoOriginal.exists()) {
                arquivoOriginal.delete();
            }

            arquivoNovo.renameTo(arquivoOriginal);

            return true;
        } catch (IOException e) {
            System.out.print("Erro: " + e);
            return false;
        }
    }

    public boolean lista() throws IOException {
        try {
            FileReader autores = new FileReader("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/autores.txt");
            BufferedReader in = new BufferedReader(autores);

            String s;
            while ((s = in.readLine()) != null) {
                System.out.print(this.consulta(s).toString());
                for (int i = 0; i < 5; i++)
                    s = in.readLine();
            }
            in.close();
            return true;

        } catch (IOException e) {
            System.out.print("Erro: " + e);
            return false;
        }
    }

    public String getPrincipaisObras() {
        return this.principaisObras;
    }

    public void setPrincipaisObras(String principaisObras) {
        this.principaisObras = principaisObras;
    }

    public String getNacionalidade() {
        return this.nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "==========================================================\n" + "Autor " + getNome() + ":\n\n"
                + "Número de Registro: " + getNumRegistro() + "\nNome: " + getNome() + "\nData de Nascimento: "
                + getDataNascimento() + "\nE-mail: " + getEmail() + "\nPrincipais Obras: " + getPrincipaisObras()
                + "\nNacionalidade: " + getNacionalidade()
                + "\n==========================================================\n";
    }

}
