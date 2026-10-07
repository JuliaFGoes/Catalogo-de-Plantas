/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexao;

import bean.Flor;
import bean.FlorDAO;

/**
 *
 * @author Julia
 */
public class Catalogo {

    public static void main(String[] args) {

        FlorDAO fDAO = new FlorDAO();

        // Flor 1
        Flor f1 = new Flor();
        f1.setNome("Rosa");
        f1.setNomeCientifico("Rosa");
        f1.setTamanho("Média");
        f1.setAltura(80);
        f1.setTipo("Flor");
        f1.setCor("Vermelha");
        f1.setNecessidadeSol("Sol pleno");
        f1.setEmail("rosa@gmail.com");

        fDAO.inserir(f1);


        // Flor 2
        Flor f2 = new Flor();
        f2.setNome("Girassol");
        f2.setNomeCientifico("Helianthus annuus");
        f2.setTamanho("Grande");
        f2.setAltura(200);
        f2.setTipo("Flor");
        f2.setCor("Amarela");
        f2.setNecessidadeSol("Sol pleno");
        f2.setEmail("girassol@gmail.com");

        fDAO.inserir(f2);


        // Flor 3
        Flor f3 = new Flor();
        f3.setNome("Orquídea");
        f3.setNomeCientifico("Orchidaceae");
        f3.setTamanho("Média");
        f3.setAltura(60);
        f3.setTipo("Flor");
        f3.setCor("Roxa");
        f3.setNecessidadeSol("Meia-sombra");
        f3.setEmail("orquidea@gmail.com");

        fDAO.inserir(f3);


        // Flor 4
        Flor f4 = new Flor();
        f4.setNome("Lírio");
        f4.setNomeCientifico("Lilium");
        f4.setTamanho("Média");
        f4.setAltura(90);
        f4.setTipo("Flor");
        f4.setCor("Branca");
        f4.setNecessidadeSol("Sol pleno");
        f4.setEmail("lirio@gmail.com");

        fDAO.inserir(f4);


        // Flor 5
        Flor f5 = new Flor();
        f5.setNome("Lavanda");
        f5.setNomeCientifico("Lavandula");
        f5.setTamanho("Pequena");
        f5.setAltura(50);
        f5.setTipo("Erva");
        f5.setCor("Roxa");
        f5.setNecessidadeSol("Sol pleno");
        f5.setEmail("lavanda@gmail.com");

        fDAO.inserir(f5);


        // Flor 6
        Flor f6 = new Flor();
        f6.setNome("Cacto");
        f6.setNomeCientifico("Cactaceae");
        f6.setTamanho("Pequena");
        f6.setAltura(12);
        f6.setTipo("Suculenta");
        f6.setCor("Verde");
        f6.setNecessidadeSol("Sol");
        f6.setEmail("cacto@gmail.com");

        fDAO.inserir(f6);


        // Flor 7
        Flor f7 = new Flor();
        f7.setNome("Hortênsia");
        f7.setNomeCientifico("Hydrangea macrophylla");
        f7.setTamanho("Grande");
        f7.setAltura(150);
        f7.setTipo("Flor");
        f7.setCor("Azul");
        f7.setNecessidadeSol("Meia-sombra");
        f7.setEmail("hortensia@gmail.com");

        fDAO.inserir(f7);


        // Flor 8
        Flor f8 = new Flor();
        f8.setNome("Jasmim");
        f8.setNomeCientifico("Jasminum");
        f8.setTamanho("Média");
        f8.setAltura(100);
        f8.setTipo("Flor");
        f8.setCor("Branca");
        f8.setNecessidadeSol("Sol pleno");
        f8.setEmail("jasmim@gmail.com");

        fDAO.inserir(f8);

    }
}
