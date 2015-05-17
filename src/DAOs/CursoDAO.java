package DAOs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import beans.Curso;

public class CursoDAO {
	
	private final static String PATH = "cursos.csv";
	
	public static List<Curso> listCursos() {

		List<Curso> retorno = new ArrayList<Curso>();
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
				String descricao = data[1];
				retorno.add(new Curso(id, descricao));
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
