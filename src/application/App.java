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

/*
 * for (int i = 0; i < buckets.length; i++) {
 * 
 * if (buckets[i] != null) { List<Tupla> l = buckets[i].getTuplas(); for (Tupla
 * t : l) { System.out.println(t.getColunas()[0]); } System.out.println(); } }
 */