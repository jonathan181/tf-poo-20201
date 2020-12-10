package tf_poo_20201;

import java.io.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Locador extends Pessoa {
    private String cpf;
    private String telefone;
    private String livrosLocados;


    public Locador(String numRegistro, String nome, Date dataNascimento, String email, String cpf,
            String telefone, String livrosLocados) {
        super(numRegistro, nome, dataNascimento, email);
        this.cpf = cpf;
        this.telefone = telefone;
        this.livrosLocados = livrosLocados;

    }

    public boolean cadastra(Locador locador) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        try {
            File arquivo = new File("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/locadores.txt");
            FileWriter locadores = new FileWriter(arquivo, true);
            PrintWriter out = new PrintWriter(locadores);
            out.println(super.getNumRegistro());
            out.println(super.getNome());
            out.println(formatador.format(super.getDataNascimento()));
            out.println(super.getEmail());
            out.println(this.cpf);
            out.println(this.telefone);
            out.println(this.livrosLocados);

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

            File arquivoOriginal = new File("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/locadores.txt");
            FileReader locadoresOriginal = new FileReader(arquivoOriginal);
            BufferedReader in = new BufferedReader(locadoresOriginal);

            File arquivoNovo = new File("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/locadoresAux.txt");
            FileWriter locadoresNovo = new FileWriter(arquivoNovo);
            PrintWriter out = new PrintWriter(locadoresNovo);

            String s;
            while ((s = in.readLine()) != null) {
                if (s.equals(numRegistro)) {
                    for (int i = 0; i < 6; i++)
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
            FileReader locadores = new FileReader("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/locadores.txt");
            BufferedReader in = new BufferedReader(locadores);

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
                        String cpf = in.readLine();
                        String telefone = in.readLine();
                        String livrosLocados = in.readLine();

                        return new Locador(numRegistroLocal, nome, data, email, cpf, telefone, livrosLocados);

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

    public boolean altera(Locador locador) throws IOException {
        try {

            File arquivoOriginal = new File("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/locadores.txt");
            FileReader locadoresOriginal = new FileReader(arquivoOriginal);
            BufferedReader in = new BufferedReader(locadoresOriginal);

            File arquivoNovo = new File("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/locadoresAux.txt");
            FileWriter locadoresNovo = new FileWriter(arquivoNovo);
            PrintWriter out = new PrintWriter(locadoresNovo);

            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String s;
            while ((s = in.readLine()) != null) {

                if (s.equals(locador.getNumRegistro())) {
                    s = locador.getNumRegistro();
                    out.println(s);
                    out.flush();

                    s = in.readLine();
                    s = locador.getNome();
                    out.println(s);
                    out.flush();

                    s = in.readLine();
                    s = formatador.format(locador.getDataNascimento());
                    out.println(s);
                    out.flush();

                    s = in.readLine();
                    s = locador.getEmail();
                    out.println(s);
                    out.flush();


                    s = in.readLine();
                    s = locador.getCpf();
                    out.println(s);
                    out.flush();

                    s = in.readLine();
                    s = locador.getTelefone();
                    out.println(s);
                    out.flush();

                    s = in.readLine();
                    s = locador.getLivrosLocados();
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
            FileReader locadores = new FileReader("C:/Users/yuri-/Desktop/TrabalhoPOO/tf_poo_20201/Arquivos/locadores.txt");
            BufferedReader in = new BufferedReader(locadores);

            String s;
            while ((s = in.readLine()) != null) {
                System.out.print(this.consulta(s).toString());
                for (int i = 0; i < 6; i++)
                    s = in.readLine();
            }
            in.close();
            return true;

        } catch (IOException e) {
            System.out.print("Erro: " + e);
            return false;
        }
    }

    public String getLivrosLocados() {
        return this.livrosLocados;
    }

    public void setLivrosLocados(String livrosLocados) {
        this.livrosLocados = livrosLocados;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @Override
    public String toString() {
        return "==========================================================\n" + "Locador " + getNome() + ":\n\n"
                + "Número de Registro: " + getNumRegistro() + "\nNome: " + getNome() + "\nData de Nascimento: "
                + getDataNascimento() + "\nE-mail: " + getEmail() + "\nCPF: " + getCpf()
                + "\nLivros Locados: " + getLivrosLocados() + "\nTelefone: " + getTelefone()
                + "\n==========================================================\n";
    }

}
