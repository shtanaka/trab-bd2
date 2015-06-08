package daos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import beans.Tupla;

public class TuplaDAO {

	public static List<Tupla> listTuplas(String path) {

		List<Tupla> retorno = new ArrayList<Tupla>();
		BufferedReader br = null;
		try {
			String sCurrentLine;
			InputStreamReader isr = new InputStreamReader(new FileInputStream(
					path), "UTF-8");
			br = new BufferedReader(isr);
			boolean first = true;
			while ((sCurrentLine = br.readLine()) != null) {
				String data[] = sCurrentLine.split(",");
				if (first) {
					data[0] = data[0].substring(1);
					first = false;
				}

				Tupla t = new Tupla(data.length);
				for (int i = 0; i < data.length; i++) {
					t.definirColuna(i, data[i]);
				}
				retorno.add(t);
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
