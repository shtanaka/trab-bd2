package DAOs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import beans.Turma;

public class TurmaDAO {

	private final static String PATH = "turmas.csv";
	
	public static List<Turma> listTurmas() {

		List<Turma> retorno = new ArrayList<Turma>();
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
				int idTurma = Integer.parseInt(data[0]);
				int idCurso = Integer.parseInt(data[1]);
				String desc = data[2];
				retorno.add(new Turma(idTurma, idCurso, desc));
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
