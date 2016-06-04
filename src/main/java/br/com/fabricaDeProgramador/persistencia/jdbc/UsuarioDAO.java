package br.com.fabricaDeProgramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricaDeProgramador.persistencia.entidade.Usuario;

public class UsuarioDAO {
	
	private Connection con = ConexaoFactory.getConnection();
	

	public void cadastrar(Usuario usuario) {
		String sql = "insert into usuario (nome,login,senha) values (?,?,?)";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			
			preparador.setString(1, usuario.getNome());// SUBSTITUINDO OS PONTOS DE INTERROGACAO PELOS DADOS DO USUARIO
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			
			preparador.execute();// EXECUTANDO O COMANDO SQL NO BANCO
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		
		
	}


	public void alterar(Usuario usuario) {
			String sql = "update usuario set nome=? , login=? , senha=? where id=? ";
			try(PreparedStatement preparador = con.prepareStatement(sql)) {
				
				preparador.setString(1, usuario.getNome());// SUBSTITUINDO OS PONTOS DE INTERROGACAO PELOS DADOS DO USUARIO
				preparador.setString(2, usuario.getLogin());
				preparador.setString(3, usuario.getSenha());
				preparador.setInt(4, usuario.getId());
				
				preparador.execute();// EXECUTANDO O COMANDO SQL NO BANCO

			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}
		
	}


	public void excluir(Usuario usuario) {
		
		String sql = "delete from usuario where id=? ";
		try(PreparedStatement preparador = con.prepareStatement(sql)) {
			
			preparador.setInt(1, usuario.getId());
			
			preparador.execute();// EXECUTANDO O COMANDO SQL NO BANCO

		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		
	}

}
