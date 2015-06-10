package application;

import java.util.ArrayList;
import java.util.List;

import beans.Bucket;
import beans.Tupla;

public class HashJoin {

	private List<Tupla> A, B;

	public HashJoin(List<Tupla> A, List<Tupla> B) {
		this.A = A;
		this.B = B;
	}

	public List<Tupla> doHashJoin(int indexA, int indexB) {
		List<Tupla> join = new ArrayList<Tupla>();
		List<Bucket> buckets = generateBuckets(A, indexA);
		List<Bucket> bucketsb = generateBuckets(B, indexB);

		for (Bucket b1 : buckets) {
			for (Bucket b2 : bucketsb) {
				List<Tupla> aux = doNestedLoop(b1.getTuplas(), b2.getTuplas(),
						indexA, indexB);
				join.addAll(aux);
			}
		}
		return join;
	}

	private List<Bucket> generateBuckets(List<Tupla> tuplas, int index) {

		List<Bucket> retorno = new ArrayList<Bucket>();

		for (Tupla t : tuplas) {

			int att = UtilStaticMethods.parseComparable(t.getColunas()[index]);
			int bkt = (int) Math.floor(att / 2);

			if (bkt >= retorno.size()) {
				Bucket b = new Bucket();
				b.addTupla(t);
				retorno.add(bkt, b);
			} else if (retorno.get(bkt) == null) {
				Bucket b = new Bucket();
				b.addTupla(t);
				retorno.set(bkt, b);
			} else {
				Bucket b = retorno.get(bkt);
				b.addTupla(t);
				retorno.set(bkt, b);
			}

		}

		return retorno;
	}

	private List<Tupla> doNestedLoop(List<Tupla> a, List<Tupla> b, int indexA,
			int indexB) {

		List<Tupla> retorno = new ArrayList<Tupla>();

		for (Tupla t1 : a) {
			for (Tupla t2 : b) {
				if (t1.getColunas()[indexA].equals(t2.getColunas()[indexB])) {

					Tupla aux = new Tupla(t1.getNumColunas()
							+ t2.getNumColunas());

					for (int i = 0; i < t1.getNumColunas(); i++) {
						aux.definirColuna(i, t1.getColunas()[i]);
					}

					for (int i = t1.getNumColunas(); i < t2.getNumColunas()
							+ t1.getNumColunas(); i++) {
						aux.definirColuna(i,
								t2.getColunas()[i - t1.getNumColunas()]);
					}

					retorno.add(aux);

				}
			}
		}

		return retorno;
	}

	public List<Tupla> doFullNestedLoop(int indexA, int indexB) {

		List<Tupla> retorno = new ArrayList<Tupla>();

		for (Tupla t1 : A) {
			for (Tupla t2 : B) {
				if (t1.getColunas()[indexA].equals(t2.getColunas()[indexB])) {

					System.out.println(t1.toString() + t2.toString());

					Tupla aux = new Tupla(t1.getNumColunas()
							+ t2.getNumColunas());

					for (int i = 0; i < t1.getNumColunas(); i++) {
						aux.definirColuna(i, t1.getColunas()[i]);
					}

					for (int i = t1.getNumColunas(); i < t2.getNumColunas()
							+ t1.getNumColunas(); i++) {
						aux.definirColuna(i,
								t2.getColunas()[i - t1.getNumColunas()]);
					}

					retorno.add(aux);

				}
			}
		}

		return retorno;
	}

}
