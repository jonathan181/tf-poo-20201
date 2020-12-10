package tf_poo_20201;

import java.util.Date;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        try {
            data = (Date) formato.parse("23/11/2040");
            Locador locador = new Locador("0003", "Yuri Rambo", data, "yurireis@disente.ufg.br", "12345667789", "1234568","Livro 1 Livro 5");
            locador.cadastra(locador);
            try {
                locador.lista();
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (ParseException e) {
            System.out.println("Erro:" + e);
        }

    }
}
