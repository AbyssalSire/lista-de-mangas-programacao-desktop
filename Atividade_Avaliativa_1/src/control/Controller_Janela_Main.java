package control;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
			JPanel contentPane) throws IOException {
		Manga manga = new Manga(txtTituloAdicao, textAreaDescricao, "");
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
			FileWriter writer = new FileWriter(arquivo);
			for (Manga str : lista) {
				writer.write(str.getTitulo() + ";" + str.getDescricao() + ";" + str.getListaVolumes() + ";");
			}
			writer.close();
			JOptionPane.showMessageDialog(contentPane, "Mangá adicionado com sucesso", "Mensagem de sucesso",
					JOptionPane.INFORMATION_MESSAGE);
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

		Object rowData[] = new Object[lista.size() + 1];
		for (int i = 0; i < lista.size(); i++) {
			rowData[0] = lista.get(i).getTitulo();
			rowData[1] = lista.get(i).getDescricao();
			rowData[2] = lista.get(i).getListaVolumes();

			model.addRow(rowData);
		}

	}

	public void AlteraDescricao(File arquivo, ArrayList<Manga> lista, Manga manga, String descricao,
			JPanel contentPane) {
		try {
			manga.setDescricao(descricao);

			for (Manga str : lista) {
				if (str.getTitulo() == manga.getTitulo()) {
					str.setDescricao(descricao);
				}
			}
			FileWriter writer = new FileWriter(arquivo);
			for (Manga str : lista) {
				writer.write(str.getTitulo() + ";" + str.getDescricao() + ";" + str.getListaVolumes() + ";");
			}
			writer.close();

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
			manager.escreveTexto(arquivo, lista);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getStackTrace(), "Mensagem de erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void adicionarVolume(File arquivo, ArrayList<Manga> lista, Manga manga, String valor, JPanel contentPane) {
		try {
			
			manga.insereVolume(Integer.parseInt(valor));			
			manager.escreveTexto(arquivo, lista);
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
			manager.escreveTexto(arquivo, lista);

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

	// INSERINDO MANUALMENTE 3 MANGÁS E VOLUMES
	public void popularInicial(ArrayList<Manga> lista, File arquivo) throws FileNotFoundException, IOException {
		var gerenciador = new GerenciadorArquivo();
		Manga manga1 = new Manga("Berserk", "Excelente história de dark fantasy", "1, 2, 3, 4");
		Manga manga2 = new Manga("Vinland Saga", "Excelente história sobre Vikings", "3, 4");
		Manga manga3 = new Manga("Alita: Anjo de Combate", "Excelente ficção científica", "3");

		lista.add(manga1);
		lista.add(manga2);
		lista.add(manga3);

		gerenciador.escreveTexto(arquivo, lista);

	}

}
