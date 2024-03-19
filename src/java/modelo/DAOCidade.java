/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tulio
 */
public class DAOCidade {
    String mensagem="";
    
    public List<Cidade> listarCidade(){
        String sql = "select * from cidade";
        List<Cidade> listaCidade = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Cidade objCidade = new Cidade();
                objCidade.setCodigoCidade(rs.getInt("codigo"));
                objCidade.setNomeCidade(rs.getString("nome"));
                objCidade.setUfCifade(rs.getString("uf"));
                listaCidade.add(objCidade);
             }
        }catch(SQLException ex){
            System.out.println("Erro no listaCidade do DAOCidade"+ex);
        }
      
      return listaCidade;  
    }
    
    
    
    public String inserirCidade(Cidade objCidade){
        String sql = "insert into cidade (nome, uf) values (?,?)";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objCidade.getNomeCidade());
            pst.setString(2, objCidade.getUfCifade());
            if(pst.executeUpdate()>0){
                mensagem = "Cidade cadastrada com sucesso!";
            }else{
                mensagem = "Cidade não cadastrada!";
            }
        }catch(SQLException ex){
            mensagem="Erro de SQL no método inserirCidade do DAOCidade"
                    +ex.getMessage()+"\n Comando SQL: "+sql;
        }
        return mensagem;
    }
    public String alterarCidade(Cidade objCidade){
        String sql = "update cidade set nome=?, uf=? where codigo=?";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objCidade.getNomeCidade());
            pst.setString(2, objCidade.getUfCifade());
            pst.setInt(3, objCidade.getCodigoCidade());
            if(pst.executeUpdate()>0){
                mensagem = "Cidade alterada com sucesso!";
            }else{
                mensagem = "Cidade não alterada!";
            }
        }catch(SQLException ex){
            mensagem="Erro de SQL no método alterarCidade do DAOCidade"
                    +ex.getMessage()+"\n Comando SQL: "+sql;
        }
        return mensagem;
    }
    
    public String excluirCidade(Cidade objCidade){
        String sql = "delete from cidade where codigo=?";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
           pst.setInt(1, objCidade.getCodigoCidade());
            if(pst.executeUpdate()>0){
                mensagem = "Cidade excluída com sucesso!";
            }else{
                mensagem = "Cidade não excluída!";
            }
        }catch(SQLException ex){
            mensagem="Erro de SQL no método excluirCidade do DAOCidade"
                    +ex.getMessage()+"\n Comando SQL: "+sql;
        }
        return mensagem;
    }
    
}
