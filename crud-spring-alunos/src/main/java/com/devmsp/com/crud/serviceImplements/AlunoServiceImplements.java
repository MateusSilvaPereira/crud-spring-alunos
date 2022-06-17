package com.devmsp.com.crud.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmsp.com.crud.entity.Aluno;
import com.devmsp.com.crud.repository.AlunoRepository;
import com.devmsp.com.crud.service.AlunoService;

@Service
public class AlunoServiceImplements implements AlunoService{

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}

	@Override
	public Aluno salvarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno getAlunoById(Long id) {
		return alunoRepository.findById(id).get();
	}

	@Override
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public void excluirAlunoById(Long id) {
		alunoRepository.deleteById(id);
		
	}


}
