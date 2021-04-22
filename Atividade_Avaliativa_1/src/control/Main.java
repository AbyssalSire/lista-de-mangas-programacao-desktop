package control;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import model.GerenciadorArquivo;
import model.Manga;
import view.Janela_Main;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ArrayList<Manga> lista = new ArrayList<Manga>();
		String path = System.getProperty("user.dir") + "/mangas.txt";
		Controller_Janela_Main controller = new Controller_Janela_Main();
		var gerenciador = new GerenciadorArquivo();

		File arquivo = new File(path);

		if (!arquivo.exists()) {
			// POPULAR COM 3 MANGÁS INSTANTANEAMENTE
			controller.popularInicial(lista, arquivo);
			lista = gerenciador.criaLeitor(arquivo, lista);

		} else {
			lista = gerenciador.criaLeitor(arquivo);

		}
		ArrayList<Manga> ListaPassa = lista;


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Janela_Main frame = new Janela_Main(ListaPassa, arquivo);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
