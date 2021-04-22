package control;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.GerenciadorArquivo;
import model.Manga;
import view.Janela_Main;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ArrayList<Manga> lista = new ArrayList<Manga>();
		String path = System.getProperty("user.dir") + "/mangas.obj";
		File arquivo = new File(path);
		boolean existe = false;
		if (!arquivo.exists()) {
			ObjectOutputStream saida = GerenciadorArquivo.CriaEscritor(arquivo);
			saida.writeObject(lista);
			saida.close();
			existe = false;
		} else {
			ObjectInputStream entrada = GerenciadorArquivo.CriaLeitor(arquivo);
			@SuppressWarnings("unchecked")
			ArrayList<Manga> listaLeitura = (ArrayList<Manga>) GerenciadorArquivo.LeObjeto(entrada);
			lista = listaLeitura;
			existe = true;
		}
		ArrayList<Manga> listaPassa = lista;

		if (!existe) {
			Controller_Janela_Main controller = new Controller_Janela_Main();
			controller.popularInicial(listaPassa, arquivo);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela_Main frame = new Janela_Main(listaPassa, arquivo);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
