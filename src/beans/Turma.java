package beans;

public class Turma {

	private int idTurma, idCurso;
	private String descricao;
	
	public Turma(int idTurma, int idCurso, String descricao) {
		this.idTurma = idTurma;
		this.idCurso = idCurso;
		this.descricao = descricao;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
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
		return "Turma [idTurma=" + idTurma + ", idCurso=" + idCurso
				+ ", descricao=" + descricao + "]";
	}

}
