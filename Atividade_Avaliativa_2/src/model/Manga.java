package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Manga implements Serializable {
	private static final long serialVersionUID = 1L;

	String titulo;
	String descricao;
	ArrayList<Integer> listaVolumes = new ArrayList<Integer>();

	public Manga(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public void insereVolume(int volume) throws Exception {

			if (listaVolumes.contains(volume)) {
				throw new Exception();
			} else {
				listaVolumes.add(volume);
				Collections.sort(listaVolumes);
			}

	}

	public void removeVolume(int volume) throws Exception {

			if (listaVolumes.contains(volume)) {
				listaVolumes.remove(Integer.valueOf(volume));
				Collections.sort(listaVolumes);
			} else {
				throw new Exception();
			}

	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setListaVolumes (ArrayList<Integer> listaVolumes) {
		this.listaVolumes = listaVolumes;
		
	}
	
	public ArrayList<Integer> getListaVolumes() {
		if (listaVolumes == null) {
			return null;
		} else
		return listaVolumes;
	}

}
