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
public class DAOFuncionario {
    String mensagem="";
    
    public List<Funcionario> listarFuncionario(){
        String sql = "select * from funcionario";
        List<Funcionario> listaFuncionario = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Funcionario objFuncionario = new Funcionario();
                objFuncionario.setCodigoFuncionario(rs.getInt("codigo"));
                objFuncionario.setNomeFuncionario(rs.getString("nome"));
                objFuncionario.setSalario(rs.getDouble("salario"));
                objFuncionario.setDataNascimento(rs.getDate("nascimento"));
                listaFuncionario.add(objFuncionario);
                
             }
        }catch(SQLException ex){
            System.out.println("Erro no listaCidade do DAOCidade"+ex);
        }
      
      return listaFuncionario;  
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
