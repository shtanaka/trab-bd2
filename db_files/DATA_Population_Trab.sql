insert into CURSOS values (0, 'Computacao')
insert into CURSOS values (1, 'Artes')
insert into CURSOS values (2, 'Medicina')
insert into CURSOS values (3, 'Direito')
insert into CURSOS values (4, 'Letras')

select * from Cursos

insert into ALUNOS values (0, 'João', 20)
insert into ALUNOS values (1, 'Pedro', 21)
insert into ALUNOS values (2, 'Lucas', 22)
insert into ALUNOS values (3, 'Amarildo', 22)
insert into ALUNOS values (4, 'Victor', 21)
insert into ALUNOS values (5, 'Thais', 20)
insert into ALUNOS values (6, 'Alisson', 20)
insert into ALUNOS values (7, 'Maria', 22)
insert into ALUNOS values (8, 'Luisa', 23)
insert into ALUNOS values (9, 'Claudia', 22)
insert into ALUNOS values (10, 'Andressa', 27)
insert into ALUNOS values (11, 'Bianca', 22)
insert into ALUNOS values (12, 'Carlos', 20)
insert into ALUNOS values (13, 'Leticia', 20)
insert into ALUNOS values (14, 'Bilbo', 21)
insert into ALUNOS values (15, 'Sandro', 21)
insert into ALUNOS values (16, 'Saori', 20)
insert into ALUNOS values (17, 'Kepler', 20)
insert into ALUNOS values (18, 'Verissimo', 18)
insert into ALUNOS values (19, 'Lorena', 19)
insert into ALUNOS values (20, 'Sara', 22)

select * from ALUNOS where idade = 22

insert into TURMAS values (0, 0, 'Banco de dados');
insert into TURMAS values (1, 0, 'Grafos');
insert into TURMAS values (2, 0, 'Computação Gráfica');
insert into TURMAS values (3, 0, 'Inteligencia A');
insert into TURMAS values (4, 1, 'Pintura de Quadros');
insert into TURMAS values (5, 1, 'Historia da arte');
insert into TURMAS values (6, 2, 'Anatomia');
insert into TURMAS values (7, 2, 'Cardiologia');
insert into TURMAS values (8, 3, 'Civil');
insert into TURMAS values (9, 3, 'Trabalhista');
insert into TURMAS values (10, 4, 'Inglês');
insert into TURMAS values (11, 4, 'Espanhol');

select * from TURMAS

insert into ALUNO_TURMA values (0, 0)
insert into ALUNO_TURMA values (0, 1)
insert into ALUNO_TURMA values (0, 2)
insert into ALUNO_TURMA values (0, 3)
insert into ALUNO_TURMA values (1, 0)
insert into ALUNO_TURMA values (1, 1)
insert into ALUNO_TURMA values (1, 5)
insert into ALUNO_TURMA values (1, 3)
insert into ALUNO_TURMA values (1, 4)
insert into ALUNO_TURMA values (2, 3)
insert into ALUNO_TURMA values (2, 4)
insert into ALUNO_TURMA values (3, 1)
insert into ALUNO_TURMA values (3, 5)
insert into ALUNO_TURMA values (4, 6)
insert into ALUNO_TURMA values (4, 7)
insert into ALUNO_TURMA values (4, 8)
insert into ALUNO_TURMA values (5, 6)
insert into ALUNO_TURMA values (5, 7)
insert into ALUNO_TURMA values (6, 9)
insert into ALUNO_TURMA values (6, 11)
insert into ALUNO_TURMA values (7, 9)
insert into ALUNO_TURMA values (7, 10)
insert into ALUNO_TURMA values (7, 11)
insert into ALUNO_TURMA values (8, 12)
insert into ALUNO_TURMA values (8, 13)
insert into ALUNO_TURMA values (8, 14)
insert into ALUNO_TURMA values (8, 15)
insert into ALUNO_TURMA values (8, 16)
insert into ALUNO_TURMA values (9, 14)
insert into ALUNO_TURMA values (9, 15)
insert into ALUNO_TURMA values (9, 16)
insert into ALUNO_TURMA values (10, 17)
insert into ALUNO_TURMA values (10, 18)
insert into ALUNO_TURMA values (10, 19)
insert into ALUNO_TURMA values (11, 20)

select * from aluno_TURMA

select c.descricao, a.nome from ALUNOS a, ALUNO_TURMA b, TURMAS c where a.matricula=b.matricula_aluno and b.id_turma=1 and c.id_turma=b.id_turma order by a.nome

select c.descricao, d.nome from TURMAS c inner join (select a.nome, b.id_turma from ALUNOS a inner join ALUNO_TURMA b on a.matricula=b.matricula_aluno) d
on d.id_turma=c.id_turma order by c.id_turma , d.nome