package model;

public class Manga {

	String titulo;
	String descricao;
	String listaVolumes;

	public Manga(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public Manga(String titulo, String descricao, String listaVolumes) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.listaVolumes = listaVolumes;
	}

	public void insereVolume(int volume) {
		if (listaVolumes == null || listaVolumes == "") {
			listaVolumes = Integer.toString(volume);
		} else
			listaVolumes = listaVolumes + "," + volume;
	}

	public void removeVolume(int volume) throws Exception {
		String vol1 = Integer.toString(volume) + ",";
		String vol2 = Integer.toString(volume);

		if (listaVolumes.contains(vol1)) {
			String replace = listaVolumes.replace(vol1, "");
			listaVolumes = replace;
		} else if (listaVolumes.contains(vol2)) {

			String replace = listaVolumes.replace(vol2, "");
			listaVolumes = replace;

			if (listaVolumes == "") {
				listaVolumes = null;
			}
		} else {
			throw new Exception();
		}

	}

	public void setVolumes(String lista) {
		this.listaVolumes = lista;
	}

	public String getListaVolumes() {
		return listaVolumes;
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

}
