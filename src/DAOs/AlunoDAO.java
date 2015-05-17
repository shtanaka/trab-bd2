package DAOs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import beans.Aluno;

public class AlunoDAO {
	
	private final static String PATH = "alunos.csv";
	
	public static List<Aluno> listAlunos() {

		List<Aluno> retorno = new ArrayList<Aluno>();
		BufferedReader br = null;
		try {
			String sCurrentLine;
			InputStreamReader isr = new InputStreamReader(new FileInputStream(
					PATH), "UTF-8");
			br = new BufferedReader(isr);
			boolean first = true;
			while ((sCurrentLine = br.readLine()) != null) {
				String data[] = sCurrentLine.split(",");
				if(first){
					data[0] = data[0].substring(1);
					first = false;
				}
				int id = Integer.parseInt(data[0]);
				String nome = data[1];
				int idade = Integer.parseInt(data[2]);
				retorno.add(new Aluno(id, nome, idade));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return retorno;

	}

}
