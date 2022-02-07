/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import modelo.Contato;
import util.BancoDados;

public class ContatoControle {
    
    public static boolean Cadastrar(Contato c){
        try {
            Connection conn = BancoDados.getConexao();
            String sql = "INSERT INTO contato ";
            sql += " (nome, sobrenome, ddd, "
                    + "telefone, email, sexo) ";
            sql += " VALUES (?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getSobrenome());
            ps.setString(3, c.getDdd());
            ps.setString(4, c.getTelefone());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getSexo());
            int linhasafetadas = ps.executeUpdate();
            if (linhasafetadas > 0) {
                final ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    final int lastId = rs.getInt(1);
                    System.out.println("O numero do id é:"
                            + lastId);
                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static Contato BuscarPorId(long idContato){
        return null;
    }
    
    public static boolean Atualizar(Contato c){
        return true;
    }
    
    public static boolean Excluir(long idContato){
        return true;
    }
    
    public List<Contato> ListarTodos(){
        return null;
    }
    
    
}
