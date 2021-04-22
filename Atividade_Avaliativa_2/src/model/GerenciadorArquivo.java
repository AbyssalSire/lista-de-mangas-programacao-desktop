package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.ArrayList;

/*
 * CLASSE FORNECIDA PELO PROFESSOR DA DISCIPLINA
 * @author fabricio@utfpr.edu.br
 * 
 * os métodos imprimeManga() e pesquisaTitulo() são de minha autoria 
 * e foram utilizados para testes antes da implementação das janelas
 * mas como não são mais necessários após a implementação das janelas os deixei comentados
 * 
 * */

public class GerenciadorArquivo {

	public static ObjectOutputStream CriaEscritor(File arquivo) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(arquivo);
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			System.err.print("Erro ao criar arquivo: " + e);
		}
		return oos;
	}

	public static ObjectInputStream CriaLeitor(File arquivo) {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream(arquivo);
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			System.err.println("Erro ao ler arquivo: " + e);
		}
		return ois;
	}

	public static void EscreveObjeto(ObjectOutputStream oos, Object obj, boolean flush) {
		try {
			oos.writeObject(obj);
			if (flush) {
				oos.flush();
			}
		} catch (IOException e) {
			System.err.println("Erro na escrita: " + e);
		}
	}

	@SuppressWarnings("finally")
	public static Object LeObjeto(ObjectInputStream ois) {
		Object obj = null;
		try {
			obj = ois.readObject();
		} catch (ClassNotFoundException e) {
			System.err.println("Classe não encontrada: " + e);
		} catch (java.io.EOFException e) {
			System.err.println("Fim de arquivo: " + e);
		} catch (IOException e) {
			System.err.println("Erro na leitura do objeto: " + e);
		} finally {
			return obj;
		}
	}
/*	Métodos usados para testar antes da implementação das janelas
	public static void imprimeManga(ArrayList<Manga> listaLeitura) {
		if (listaLeitura == null) {
			System.err.println("Nenhum mangá adicionado");
		} else {
			for (Manga i : listaLeitura) {
				System.out.println(i.getTitulo() + " " + i.getListaVolumes());

			}
		}
	}

	public static Manga pesquisaTitulo(ArrayList<Manga> lista, String titulo) {
		for (Manga i : lista) {
			String temp = i.getTitulo();
			System.out.println(temp);
			if (i.getTitulo().compareTo(titulo) == 0) {
				System.out.println("achou");
				return i;
			}
		}
		return null;
	}
*/
}
