/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Julia
 */
public class FlorDAO {
    private Conexao conexao;
    private Connection conn;
    
    public FlorDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Flor flor){
        String sql = "INSERT INTO plantas (nome, nomecientifico, tamanho, altura, cor, tipo, necessidadesol, email, foto)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, flor.getNome());
            stmt.setString(2, flor.getNomeCientifico());        
            stmt.setString(3, flor.getTamanho());       
            stmt.setDouble(4, flor.getAltura());
            stmt.setString(5, flor.getCor());
            stmt.setString(6, flor.getTipo());
            stmt.setString(7, flor.getNecessidadeSol());
            stmt.setString(8, flor.getEmail());
            stmt.setString(9, flor.getFoto());
            
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao inserir flor: " +ex.getMessage());
        }
    }
    
    public ResultSet listar() {

    String sql = "SELECT * FROM plantas";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        return stmt.executeQuery();

    } catch (SQLException e) {
        System.out.println("Erro ao listar flores: " + e.getMessage());
        return null;
    }
        
  }
    public ResultSet buscarPorId(int id) {

    String sql = "SELECT * FROM plantas WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeQuery();

        } catch (SQLException e) {

            System.out.println("Erro ao buscar planta: " + e.getMessage());

            return null;
        }
    }
    public void atualizar(Flor flor, int id) {

    String sql = "UPDATE plantas SET "
            + "nome=?, "
            + "nomecientifico=?, "
            + "tamanho=?, "
            + "altura=?, "
            + "cor=?, "
            + "tipo=?, "
            + "necessidadesol=?, "
            + "email=?, "
            + "foto=? "
            + "WHERE id=?";

    try {

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, flor.getNome());
        stmt.setString(2, flor.getNomeCientifico());
        stmt.setString(3, flor.getTamanho());
        stmt.setDouble(4, flor.getAltura());
        stmt.setString(5, flor.getCor());
        stmt.setString(6, flor.getTipo());
        stmt.setString(7, flor.getNecessidadeSol());
        stmt.setString(8, flor.getEmail());
        stmt.setString(9, flor.getFoto());
        stmt.setInt(10, id);

        stmt.executeUpdate();

        System.out.println("Planta atualizada com sucesso!");

    } catch (SQLException e) {

        System.out.println("Erro ao atualizar planta: "
                + e.getMessage());
    }
    
    }
        public void excluir(int id) {

        String sql = "DELETE FROM plantas WHERE id = ?";

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Planta excluída com sucesso!");

        } catch (SQLException e) {

            System.out.println("Erro ao excluir planta: " + e.getMessage());
        }
    }
}
