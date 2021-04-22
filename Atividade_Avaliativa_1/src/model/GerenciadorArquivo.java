package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.FileWriter;
import java.util.ArrayList;

public class GerenciadorArquivo {
	public BufferedReader CriaEscritor(File filename) {
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(leitor);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return leitor;
	}

	public ArrayList<Manga> criaLeitor(File filename) throws FileNotFoundException {
		BufferedReader leitor = null;
		ArrayList<Manga> lista = new ArrayList<Manga>();
		String data = null;

		int i, j = 0, k = 0;

		try {
			leitor = new BufferedReader(new FileReader(filename));
			while (leitor.ready()) {
				data = leitor.readLine();
			}
			String[] tokens = data.split(";");
			for (i = 0; i < tokens.length; i++) {

				if (k % 3 == 0) {
					Manga manga = new Manga(tokens[i], "");
					lista.add(manga);

				}
				if (k % 3 == 1) {
					lista.get(j).setDescricao(tokens[i]);

				}
				if (k % 3 == 2) {
					lista.get(j).setVolumes(tokens[i]);
					j++;
				}

				k++;
			}

		} catch (

		IOException erro) {
			erro.printStackTrace();
		}
		return lista;
	}

	public ArrayList<Manga> criaLeitor(File filename, ArrayList<Manga> lista) throws FileNotFoundException {
		BufferedReader leitor = null;
		String data = null;

		int i, j = 0, k = 0;

		try {
			leitor = new BufferedReader(new FileReader(filename));
			while (leitor.ready()) {
				data = leitor.readLine();
			}
			String[] tokens = data.split(";");
			for (i = 0; i < tokens.length; i++) {

				if (k % 3 == 0) {
					lista.get(j).setTitulo(tokens[i]);

				}
				if (k % 3 == 1) {
					lista.get(j).setDescricao(tokens[i]);

				}
				if (k % 3 == 2) {
					lista.get(j).setVolumes(tokens[i]);
					j++;

				}
				k++;

			}

		} catch (

		IOException erro) {
			erro.printStackTrace();
		}
		return lista;
	}

	public void escreveTexto(File path, ArrayList<Manga> lista) throws FileNotFoundException, IOException {
		try {
			FileWriter writer = new FileWriter(path);
			for (Manga str : lista) {
				writer.write(str.getTitulo() + ";" + str.getDescricao() + ";" + str.getListaVolumes() + ";");
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
