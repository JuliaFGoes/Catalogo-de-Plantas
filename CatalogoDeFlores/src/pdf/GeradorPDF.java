package pdf;

import bean.Flor;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class GeradorPDF {

    public static String gerarPDF(Flor flor) {

        String pasta = "pdfs";

        File diretorio = new File(pasta);

        if (!diretorio.exists()) {
            diretorio.mkdir();
        }

        String nomeArquivo = flor.getNome() + ".pdf";
        String caminho = pasta + File.separator + nomeArquivo;

        try {

            PDDocument documento = new PDDocument();

            PDPage pagina = new PDPage();

            documento.addPage(pagina);

            PDPageContentStream conteudo =
                    new PDPageContentStream(documento, pagina);

            conteudo.beginText();

            conteudo.setFont(
                    new PDType1Font(
                            Standard14Fonts.FontName.HELVETICA_BOLD
                    ),
                    20
            );

            conteudo.newLineAtOffset(180, 750);

            conteudo.showText("CATALOGO DE FLORES");

            conteudo.endText();

            conteudo.beginText();

            conteudo.setFont(
                    new PDType1Font(
                            Standard14Fonts.FontName.HELVETICA
                    ),
                    12
            );

            conteudo.newLineAtOffset(70, 690);

            conteudo.showText(
                    "Nome: " + flor.getNome()
            );

            conteudo.newLineAtOffset(0, -30);

            conteudo.showText(
                    "Nome cientifico: "
                    + flor.getNomeCientifico()
            );

            conteudo.newLineAtOffset(0, -30);

            conteudo.showText(
                    "Tipo: " + flor.getTipo()
            );

            conteudo.newLineAtOffset(0, -30);

            conteudo.showText(
                    "Cor: " + flor.getCor()
            );

            conteudo.newLineAtOffset(0, -30);

            conteudo.showText(
                    "Tamanho: " + flor.getTamanho()
            );

            conteudo.newLineAtOffset(0, -30);

            conteudo.showText(
                    "Altura maxima: "
                    + flor.getAltura()
                    + " cm"
            );

            conteudo.newLineAtOffset(0, -30);

            conteudo.showText(
                    "Necessidade de sol: "
                    + flor.getNecessidadeSol()
            );

            conteudo.newLineAtOffset(0, -30);

            conteudo.showText(
                    "E-mail: " + flor.getEmail()
            );

            conteudo.endText();

            conteudo.close();

            documento.save(caminho);

            documento.close();

            System.out.println(
                    "PDF criado com sucesso!"
            );

            return caminho;

        } catch (IOException e) {

            System.out.println(
                    "Erro ao criar PDF: "
                    + e.getMessage()
            );

            return null;
        }
    }
}