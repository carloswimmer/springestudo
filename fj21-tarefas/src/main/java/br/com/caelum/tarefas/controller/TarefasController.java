package br.com.caelum.tarefas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.jdbc.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.model.Tarefa;

@Controller
public class TarefasController {
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		
		if(result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		
		return "tarefa/adicionada";
	}

	
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}
}