package com.devmsp.com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmsp.com.crud.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
