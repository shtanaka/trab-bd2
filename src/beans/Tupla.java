package beans;

public class Tupla {
	private String colunas[];
	int numColunas;
	
	public int getNumColunas() {
		return numColunas;
	}
	
	public Tupla(int numColunas) {
		colunas = new String[numColunas];
		this.numColunas = numColunas;
	}

	public String[] getColunas() {
		return colunas;
	}

	public void definirColuna(int coluna, String valor) {
		colunas[coluna] = valor;
	}

	public String toString() {
		String retorno = "";

		for (int i = 0; i < colunas.length; i++) {
			retorno = retorno + colunas[i] + " | ";
		}

		return retorno;

	}

}
