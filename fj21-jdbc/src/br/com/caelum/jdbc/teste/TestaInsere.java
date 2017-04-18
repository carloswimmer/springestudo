package br.com.caelum.jdbc.teste;

import java.sql.SQLException;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaInsere {

	public static void main(String[] args) throws SQLException {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Susie");
		funcionario.setUsuario("tatata");
		funcionario.setSenha("jfkslajf74589");
		
		FuncionarioDao dao = new FuncionarioDao();
		dao.adiciona(funcionario);
		
		System.out.println("Gravado " + funcionario.getNome() );
	}
}
