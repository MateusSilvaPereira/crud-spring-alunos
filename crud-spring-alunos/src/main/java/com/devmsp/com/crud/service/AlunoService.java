package com.devmsp.com.crud.service;

import java.util.List;

import com.devmsp.com.crud.entity.Aluno;

public interface AlunoService {

	List<Aluno> getAllAlunos();
	
	Aluno salvarAluno(Aluno aluno);
	
	Aluno getAlunoById(Long id);
	
	Aluno atualizarAluno(Aluno aluno);
	
	void excluirAlunoById(Long id);
}
