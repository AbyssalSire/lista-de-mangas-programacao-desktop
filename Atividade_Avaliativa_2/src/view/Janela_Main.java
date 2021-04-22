package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller_Janela_Main;
import model.Manga;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTextArea;

public class Janela_Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTituloPesquisa;
	private JTextField txtTituloAdicao;

	/**
	 * Create the frame.
	 */
	public Janela_Main(ArrayList<Manga> lista, File arquivo) {
		Controller_Janela_Main controller = new Controller_Janela_Main();
		setResizable(false);
		setTitle("Lista de Mangás");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnIrParaAdicionar = new JButton("Adicionar mangá");
		btnIrParaAdicionar.setBounds(110, 277, 150, 23);
		contentPane.add(btnIrParaAdicionar);

		JLabel lblPesquisa = new JLabel("Pesquisa por título");
		lblPesquisa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPesquisa.setBounds(10, 0, 150, 30);
		contentPane.add(lblPesquisa);

		txtTituloPesquisa = new JTextField();
		txtTituloPesquisa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTituloPesquisa.getText().equals("Insira título aqui...")) {
					txtTituloPesquisa.setText("");
					txtTituloPesquisa.setForeground(Color.black);
					txtTituloPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 11));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTituloPesquisa.getText().equals("")) {
					txtTituloPesquisa.setForeground(Color.gray);
					txtTituloPesquisa.setFont(new Font("Tahoma", Font.ITALIC, 11));
					txtTituloPesquisa.setText("Insira título aqui...");
				}
			}
		});
		txtTituloPesquisa.setText("Insira título aqui...");

		txtTituloPesquisa.setToolTipText("");
		txtTituloPesquisa.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtTituloPesquisa.setBounds(10, 30, 150, 20);
		contentPane.add(txtTituloPesquisa);
		txtTituloPesquisa.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manga mangaDaPesquisa = controller.pesquisaManga(txtTituloPesquisa.getText(), lista, contentPane);
				if (mangaDaPesquisa != null)
					new Janela_Manga(arquivo, lista, mangaDaPesquisa).setVisible(true);
				controller.resetaTitulo(txtTituloPesquisa, false);
			}
		});
		btnPesquisar.setBounds(160, 29, 100, 22);
		contentPane.add(btnPesquisar);

		JLabel lblAdicionar = new JLabel("Adicionar novo mangá à lista");
		lblAdicionar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdicionar.setBounds(10, 94, 239, 30);
		contentPane.add(lblAdicionar);

		txtTituloAdicao = new JTextField();
		txtTituloAdicao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTituloAdicao.getText().equals("Insira título aqui...")) {
					controller.resetaTitulo(txtTituloAdicao, true);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTituloAdicao.getText().equals("")) {
					controller.resetaTitulo(txtTituloAdicao, false);
				}
			}
		});
		txtTituloAdicao.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtTituloAdicao.setText("Insira título aqui...");
		txtTituloAdicao.setBounds(10, 135, 250, 20);
		contentPane.add(txtTituloAdicao);
		txtTituloAdicao.setColumns(10);

		JButton btnMostrarTodos = new JButton("Mostrar todos os mangás");

		btnMostrarTodos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new Janela_Mostrar_Todos(lista).setVisible(true);
				controller.resetaTitulo(txtTituloPesquisa, false);
			}
		});

		btnMostrarTodos.setBounds(70, 60, 190, 23);
		contentPane.add(btnMostrarTodos);

		JTextArea textAreaDescricao = new JTextArea();
		textAreaDescricao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textAreaDescricao.getText().equals("Insira a descrição aqui")) {
					controller.resetaDescricao(textAreaDescricao, true);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textAreaDescricao.getText() == "" || textAreaDescricao.getText() == "Insira a descrição aqui") {
					controller.resetaDescricao(textAreaDescricao, false);
				}
			}
		});
		textAreaDescricao.setFont(new Font("Tahoma", Font.ITALIC, 11));
		textAreaDescricao.setLineWrap(true);
		textAreaDescricao.setText("Insira a descrição aqui");
		textAreaDescricao.setBounds(10, 166, 250, 100);
		contentPane.add(textAreaDescricao);
		btnIrParaAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTituloAdicao.getText().equals("") || txtTituloAdicao.getText().equals("Insira título aqui...")) {
					JOptionPane.showMessageDialog(contentPane, "Área de título é obrigatória", "Mensagem de erro",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (textAreaDescricao.getText() == "" || textAreaDescricao.getText() == "Insira a descrçãoo aqui") {
						textAreaDescricao.setText("sem descrição");
					}
					controller.criaEAdiciona(txtTituloAdicao.getText(), textAreaDescricao.getText(), lista, arquivo,
							contentPane);
					controller.resetaTitulo(txtTituloAdicao, false);
					controller.resetaDescricao(textAreaDescricao, false);
				}
			}
		});
	}
}
