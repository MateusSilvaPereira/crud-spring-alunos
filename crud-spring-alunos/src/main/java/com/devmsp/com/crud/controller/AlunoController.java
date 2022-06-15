package com.devmsp.com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devmsp.com.crud.entity.Aluno;
import com.devmsp.com.crud.service.AlunoService;

@Controller
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/alunos")
	public String listarAlunos(Model model) {
		model.addAttribute("alunos", alunoService.getAllAlunos() );
		return "alunos.html";
	}
	
	@GetMapping("/alunos/cadastro")
	public String cadastrarAlunoViaForm(Model model) {
		Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		return "cadastrarAluno.html";
	}
	
	@PostMapping("/alunos")
	public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
		alunoService.salvarAluno(aluno);
		return "redirect:/alunos.html";
	}
	
	@GetMapping("/alunos/editar/{id}")
	public String editarAluno(@PathVariable Long id, Model model) {
		model.addAttribute("aluno", alunoService.getAlunoById(id));
		return "atualizarAluno.html";
	}
	
	@PostMapping("/alunos/{id}")
	public String atualizarAluno(@PathVariable Long id, @ModelAttribute("aluno") Aluno aluno, Model model) {
		
		Aluno existenciaDeAluno = alunoService.getAlunoById(id);
		existenciaDeAluno.setId(id);
		existenciaDeAluno.setNome(aluno.getNome());
		existenciaDeAluno.setSobrenome(aluno.getSobrenome());
		existenciaDeAluno.setIdade(aluno.getIdade());
		existenciaDeAluno.setEmail(aluno.getEmail());
		
		alunoService.atualizarAluno(existenciaDeAluno);
		return "redirect:/alunos";
	}
	
	@DeleteMapping("/alunos/excluir/{id}")
	public String excluirAluno(@PathVariable Long id) {
		alunoService.excluirAlunoById(id);
		return "redirect:/alunos.html";
	}
	
}
