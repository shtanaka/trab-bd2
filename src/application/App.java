package application;

import java.util.List;

import DAOs.CursoDAO;
import DAOs.TurmaDAO;
import beans.Curso;
import beans.Turma;

public class App {

	public static void main(String[] args) {

		// List<Aluno> alunos = AlunoDAO.listAlunos();
		List<Turma> turmas = TurmaDAO.listTurmas();
		List<Curso> cursos = CursoDAO.listCursos();

		printNestedLoop(turmas, cursos);

	}

	private static void printNestedLoop(List<Turma> turmas, List<Curso> cursos) {

		for (Turma turma : turmas) {
			for (Curso curso : cursos) {
				if (turma.getIdCurso() == curso.getIdCurso()) {
					System.out.println(turma.toString() + curso.toString());
				}
			}
		}

	}

}