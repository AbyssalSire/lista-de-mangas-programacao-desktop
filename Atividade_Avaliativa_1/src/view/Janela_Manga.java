package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import control.Controller_Janela_Main;
import model.Manga;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import java.awt.Color;

public class Janela_Manga extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField volumeAdicionar;

	/**
	 * Create the frame.
	 */
	public Janela_Manga(File arquivo, ArrayList<Manga> lista, Manga manga) {

		Controller_Janela_Main controller = new Controller_Janela_Main();
		setTitle(manga.getTitulo());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel(manga.getTitulo());
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(4, 11, 414, 30);
		contentPane.add(lblTitulo);

		JPanel panelDescricao = new JPanel();
		panelDescricao
				.setBorder(new TitledBorder(null, "Descrição", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDescricao.setBounds(4, 52, 426, 195);
		contentPane.add(panelDescricao);
		panelDescricao.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 15, 406, 135);
		panelDescricao.add(panel);
		panel.setLayout(null);

		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setBounds(0, 0, 406, 135);
		panel.add(txtDescricao);
		txtDescricao.setLineWrap(true);
		txtDescricao.setText(manga.getDescricao());
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JButton btnAlterarDescricao = new JButton("Alterar descrição");
		btnAlterarDescricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.AlteraDescricao(arquivo, lista, manga, txtDescricao.getText(), contentPane);
			}
		});
		btnAlterarDescricao.setBounds(266, 161, 150, 23);
		panelDescricao.add(btnAlterarDescricao);

		JPanel panelListaVolume = new JPanel();
		panelListaVolume.setBorder(
				new TitledBorder(null, "Lista de Volumes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelListaVolume.setBounds(4, 258, 426, 139);
		contentPane.add(panelListaVolume);
		panelListaVolume.setLayout(null);

		volumeAdicionar = new JTextField();
		volumeAdicionar.setBounds(180, 11, 45, 45);
		volumeAdicionar.setColumns(10);
		panelListaVolume.add(volumeAdicionar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 406, 52);
		panelListaVolume.add(scrollPane);

		JTextPane textListaVolumes = new JTextPane();
		textListaVolumes.setText(manga.getListaVolumes());
		textListaVolumes.setEditable(false);
		scrollPane.setViewportView(textListaVolumes);

		JButton btnAdicionaVolume = new JButton("+");
		btnAdicionaVolume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.adicionarVolume(arquivo, lista, manga, volumeAdicionar.getText(), contentPane);
				volumeAdicionar.setText("");
				textListaVolumes.setText(manga.getListaVolumes().toString());
			}
		});
		btnAdicionaVolume.setBounds(235, 11, 45, 45);
		btnAdicionaVolume.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelListaVolume.add(btnAdicionaVolume);

		JButton btnRemoveVolume = new JButton("-");
		btnRemoveVolume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RemoverVolume(arquivo, lista, manga, volumeAdicionar.getText(), contentPane);
				volumeAdicionar.setText("");

				textListaVolumes.setText(manga.getListaVolumes());
			}
		});
		btnRemoveVolume.setBounds(125, 11, 45, 45);
		btnRemoveVolume.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelListaVolume.add(btnRemoveVolume);

		JButton btnApagar = new JButton("Remover mangá da lista");
		btnApagar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnApagar.setBackground(Color.RED);
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.removerManga(arquivo, lista, manga, panel);
				dispose();
			}
		});
		btnApagar.setBounds(121, 406, 203, 25);
		contentPane.add(btnApagar);
	}
}
