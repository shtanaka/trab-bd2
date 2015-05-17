CREATE TABLE ALUNOS (
matricula int not null,
nome varchar(40) not null,
idade int,
constraint pk_aluno
	primary key (matricula) 
);

CREATE TABLE CURSOS (
id_curso int not null,
descricao varchar(20) not null,
constraint pk_curso
	primary key (id_curso)
)

CREATE TABLE TURMAS (

id_turma int not null,
id_curso int not null,
descricao varchar(20) not null,
constraint pk_turma
	primary key (id_turma),
constraint fk_turma
	foreign key (id_curso) references CURSOS on update cascade
);

CREATE TABLE ALUNO_TURMA (
id_turma int not null,
matricula_aluno int not null,
constraint pk_aluno_turma
	primary key (id_turma, matricula_aluno),
constraint fk_id_turma
	foreign key (id_turma) references TURMAS on update cascade,
constraint fk_matricula_aluno
	foreign key (matricula_aluno) references ALUNOS on update cascade
);

