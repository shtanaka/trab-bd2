package application;

import java.util.List;

import beans.Tupla;
import daos.TuplaDAO;

public class App {

	public static void main(String[] args) {

		List<Tupla> turmas = TuplaDAO.listTuplas("turmas.csv");
		List<Tupla> cursos = TuplaDAO.listTuplas("cursos.csv");
		HashJoin h = new HashJoin(turmas, cursos);

		/*
		 * 1o att: coluna da tabela 1; 2o att: coluna da tabela 2;
		 * 3o att: condicao do join; 4oatt: operador a ser aplicado a condicao
		 * polimorfismo do join: 
		 * doHashJoin(a, b) -> join sem condição
		 * doHashJoin(a, b, value) -> join com condicao em cima do value
		 * doHashJoin(a, b, value, operador) -> join com condicao em cima do value
		 * 		e com a operacao do operador
		 */
		List<Tupla> join2 = h.doHashJoin(1, 0, 2, ">=");
		UtilStaticMethods.printTuplas(join2);

	}

}
