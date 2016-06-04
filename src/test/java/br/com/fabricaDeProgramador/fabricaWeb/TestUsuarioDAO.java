package br.com.fabricaDeProgramador.fabricaWeb;

import br.com.fabricaDeProgramador.persistencia.entidade.Usuario;
import br.com.fabricaDeProgramador.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {
	
	
	
	
	public static void testAlterar(){
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("Jãozão da silva");
		usuario.setLogin("jzaoss");
		usuario.setSenha("12345678");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterar(usuario);
		
		System.out.println("Alterado com sucesso!!!");
	}
	
	public static void testCadastrar(){
		
		Usuario usuario = new Usuario();
		
		usuario.setNome("Jãozão");
		usuario.setLogin("jzão");
		usuario.setSenha("123");
		
		//CADASTRANDO USUARIO NO BANCO DE DADOS
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);
		
		System.out.println("Cadastrado com sucesso!!!");
	}
	
	public static void testExcluir(){
		Usuario usuario = new Usuario();
		usuario.setId(5);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuario);
		
		System.out.println("Excluido com sucesso!!!");
	}
	public static void main(String[] args) {
			//testCadastrar();
			testAlterar();
			//	testExcluir();
		}

}
