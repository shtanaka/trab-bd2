package application;

import java.util.List;

import beans.Tupla;
import daos.TuplaDAO;

public class App {

	public static void main(String[] args) {

		List<Tupla> turmas = TuplaDAO.listTuplas("turmas.csv");
		List<Tupla> cursos = TuplaDAO.listTuplas("cursos.csv");
		HashJoin h = new HashJoin(turmas, cursos);
		
		List<Tupla> join = h.doHashJoin(1, 0);
		UtilStaticMethods.printTuplas(join);
		
	}

}
