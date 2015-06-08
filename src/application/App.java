package application;

import java.util.List;

import beans.Bucket;
import beans.Tupla;
import daos.TuplaDAO;

public class App {

	public static void main(String[] args) {

		// List<Aluno> alunos = AlunoDAO.listAlunos();
		List<Tupla> turmas = TuplaDAO.listTuplas("turmas.csv");
		List<Tupla> cursos = TuplaDAO.listTuplas("cursos.csv");

		// printNestedLoop(turmas, cursos);
		printHashJoin(turmas, cursos);

	}

	private static void printHashJoin(List<Tupla> a, List<Tupla> b) {
		Bucket[] buckets = generateBuckets(a, 0);
		for (int i = 0; i < buckets.length; i++) {

			if (buckets[i] != null) {
				List<Tupla> l = buckets[i].getTuplas();
				for (Tupla t : l) {
					System.out.println(t.getColunas()[0]);
				}
				System.out.println();
			}
		}

	}

	private static Bucket[] generateBuckets(List<Tupla> tuplas, int index) {

		Bucket[] retorno = new Bucket[1000];

		for (Tupla t : tuplas) {
			int att = UtilStaticMethods.parseComparable(t.getColunas()[index]);
			int bkt = (int) Math.floor(att / 2);
			if (retorno[bkt] == null) {
				Bucket b = new Bucket();
				b.addTupla(t);
				retorno[bkt] = b;
			} else {
				Bucket b = retorno[bkt];
				b.addTupla(t);
				retorno[bkt] = b;
			}
		}

		return retorno;
	}

	private static void printNestedLoop(List<Tupla> a, List<Tupla> b) {
		for (Tupla t1 : a) {
			for (Tupla t2 : b) {
				if (t1.getColunas()[1].equals(t2.getColunas()[0])) {
					System.out.println(t1.toString() + t2.toString());
				}
			}
		}
	}

}