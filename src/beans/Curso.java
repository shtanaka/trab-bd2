package beans;

public class Curso {
	private int idCurso;
	private String descricao;

	public Curso(int idCurso, String descricao) {
		this.idCurso = idCurso;
		this.descricao = descricao;
	}
	
	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", descricao=" + descricao + "]";
	}

}
