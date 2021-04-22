package control;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.GerenciadorArquivo;
import model.Manga;

public class Controller_Janela_Main {

	GerenciadorArquivo manager = new GerenciadorArquivo();

	public void criaEAdiciona(String txtTituloAdicao, String textAreaDescricao, ArrayList<Manga> lista, File arquivo,
			JPanel contentPane) {
		Manga manga = new Manga(txtTituloAdicao, textAreaDescricao);
		var erro = false;
		for (Manga i : lista) {
			if (i.getTitulo().equals(txtTituloAdicao)) {

				JOptionPane.showMessageDialog(contentPane, "Título já adicionado à lista", "Mensagem de erro",
						JOptionPane.ERROR_MESSAGE);

				erro = true;
			}
		}
		if (!erro) {
			lista.add(manga);
			ObjectOutputStream saida = GerenciadorArquivo.CriaEscritor(arquivo);
			try {
				saida.writeObject(lista);
				saida.close();
				JOptionPane.showMessageDialog(contentPane, "Mangá adicionado com sucesso", "Mensagem de sucesso",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			manga = null;
			System.gc();
		}
	}

	public Manga pesquisaManga(String txtTituloPesquisa, ArrayList<Manga> lista, JPanel contentPane) {
			for (Manga i : lista) {
				if (i.getTitulo().equalsIgnoreCase(txtTituloPesquisa)||i.getTitulo().toLowerCase().contains(txtTituloPesquisa)) {
					return i;
				}
		}
		JOptionPane.showMessageDialog(contentPane, "Título não encontrado na lista", "Mensagem de erro",
				JOptionPane.ERROR_MESSAGE);
		return null;

	}

	public void resetaTitulo(JTextField txtTitulo, boolean focus) {
		if (focus) {
			txtTitulo.setText("");
			txtTitulo.setForeground(Color.black);
			txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		} else {
			txtTitulo.setForeground(Color.gray);
			txtTitulo.setFont(new Font("Tahoma", Font.ITALIC, 11));
			txtTitulo.setText("Insira título aqui...");
		}
	}

	public void resetaDescricao(JTextArea textAreaDescricao, boolean focus) {
		if (focus) {
			textAreaDescricao.setText("");
			textAreaDescricao.setForeground(Color.BLACK);
			textAreaDescricao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		} else {
			textAreaDescricao.setForeground(Color.GRAY);
			textAreaDescricao.setFont(new Font("Tahoma", Font.ITALIC, 11));
			textAreaDescricao.setText("Insira a descrição aqui");
		}

	}

	public void PopularTabela(JTable table, ArrayList<Manga> lista) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		Object rowData[] = new Object[3];
		for (int i = 0; i < lista.size(); i++) {
			rowData[0] = lista.get(i).getTitulo();
			rowData[1] = lista.get(i).getDescricao();
			rowData[2] = lista.get(i).getListaVolumes().toString();

			model.addRow(rowData);
		}

	}

	public void adicionarVolume(File arquivo, ArrayList<Manga> lista, Manga manga, String valor, JPanel contentPane) {
		try {
			manga.insereVolume(Integer.parseInt(valor));
			ObjectOutputStream saida = GerenciadorArquivo.CriaEscritor(arquivo);
			saida.writeObject(lista);
			saida.close();
			JOptionPane.showMessageDialog(contentPane, "Adicionado com sucesso", "Mensagem de sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPane, "Apenas números por favor", "Mensagem de erro",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Numero já adicionado", "Mensagem de erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void RemoverVolume(File arquivo, ArrayList<Manga> lista, Manga manga, String valor, JPanel contentPane) {
		try {
			manga.removeVolume(Integer.parseInt(valor));
			ObjectOutputStream saida = GerenciadorArquivo.CriaEscritor(arquivo);
			saida.writeObject(lista);
			saida.close();
			JOptionPane.showMessageDialog(contentPane, "Removido com sucesso", "Mensagem de sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPane, "Apenas números por favor", "Mensagem de erro",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Volume não está na lista", "Mensagem de erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void AlteraDescricao(File arquivo, ArrayList<Manga> lista, Manga manga, String descricao,
			JPanel contentPane) {
		try {
			manga.setDescricao(descricao);

			ObjectOutputStream saida = GerenciadorArquivo.CriaEscritor(arquivo);
			saida.writeObject(lista);
			saida.close();
			JOptionPane.showMessageDialog(contentPane, "Descrição alterada com sucesso", "Mensagem de sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getStackTrace(), "Mensagem de erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void removerManga(File arquivo, ArrayList<Manga> lista, Manga manga, JPanel contentPane) {
		try {
			lista.remove(manga);
			ObjectOutputStream saida = GerenciadorArquivo.CriaEscritor(arquivo);
			saida.writeObject(lista);
			saida.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getStackTrace(), "Mensagem de erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// INSERINDO MANUALMENTE 3 MANG�S E VOLUMES
	public void popularInicial(ArrayList<Manga> lista, File arquivo) {
		Manga manga1 = new Manga("Berserk", "Excelente história de dark fantasy");
		Manga manga2 = new Manga("Vinland Saga", "Excelente história sobre Vikings");
		Manga manga3 = new Manga("Alita: Anjo de Combate", "Excelente ficção científica");

		ArrayList<Integer> listaVolumes1 = new ArrayList<>();
		listaVolumes1.add(1);
		listaVolumes1.add(3);
		listaVolumes1.add(20);
		listaVolumes1.add(35);
		ArrayList<Integer> listaVolumes2 = new ArrayList<Integer>();
		listaVolumes2.add(6);
		listaVolumes2.add(19);
		listaVolumes2.add(1);
		listaVolumes2.add(22);
		ArrayList<Integer> listaVolumes3 = new ArrayList<>();
		listaVolumes3.add(1);
		Collections.sort(listaVolumes1);
		Collections.sort(listaVolumes2);
		Collections.sort(listaVolumes3);
		manga1.setListaVolumes(listaVolumes1);
		manga2.setListaVolumes(listaVolumes2);
		manga3.setListaVolumes(listaVolumes3);

		lista.add(manga1);
		lista.add(manga2);
		lista.add(manga3);
		ObjectOutputStream saida = GerenciadorArquivo.CriaEscritor(arquivo);
		try {
			saida.writeObject(lista);
			saida.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
