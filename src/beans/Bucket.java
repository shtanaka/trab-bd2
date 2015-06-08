package beans;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
	
	private List<Tupla> tuplas;
	
	public Bucket() {
		tuplas = new ArrayList<Tupla>();
	}
	
	public List<Tupla> getTuplas() {
		return tuplas;
	}
	
	public void addTupla(Tupla t) {
		tuplas.add(t);
	}

}
