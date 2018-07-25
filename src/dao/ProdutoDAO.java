package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Cidade;
import model.Cliente;
import model.Produto;

public class ProdutoDAO {
    
    public static boolean inserir(Produto produto){
        String sql = "INSERT INTO produtos "
            + " ( nome, preco, quantidade, perecivel, codCategoria ) VALUES "
            + " ( "
            + " '" + produto.getNome()                + "' , " 
            + "  " + produto.getPreco()               + "  , " 
            + "  " + produto.getQuantidade()          + "  , " 
            + "  " + produto.isPerecivel()            + "  , "  
            + "  " + produto.getCategoria().getCodigo()   + "    "
            + " );";
        return Conexao.executar(sql);

        } 
        
        public static boolean editar (Produto produto){
        String sql = "UPDATE produtos SET "
            + "nome =   '" + produto.getNome()                     +  "', " 
            + "preco =  " +  produto.getPreco()                    +  " , " 
            + "quantidade =   " +  produto.getQuantidade()         +  " , " 
            + "perecivel =    " + produto.isPerecivel()            +  " , "
            + "codCategoria =    " + produto.getCategoria().getCodigo()           +  "  "
            + "WHERE codigo =" + produto.getCodigo(); 
        return Conexao.executar(sql);

        } 
        
        public static boolean excluir(Produto produto){
            String sql = "DELETE FROM produtos "
            + "WHERE  codigo = " + produto.getCodigo();
            return Conexao.executar(sql);
            
        }
        
            public static List<Produto> getProdutos(){    
          List<Produto> lista = new ArrayList<>();
          String sql = "SELECT c.codigo, c.nome, c.preco, " 
           + " c.quantidade, d.codCategoria, d.perecivel "
           + " FROM produtos c"                                                     
           + " INNER JOIN categoria d ON c.codCategoria = d.codigo"
           + " WHERE c.nome = '' "
           + " ORDER BY c.nome";
          ResultSet rs = Conexao.consultar(sql);
          
          if (rs != null) {
              try{
                  while (rs.next()){
                      Produto pro = new Produto();
                      pro.setCodigo(rs.getInt(1));
                      pro.setNome(rs .getString(2));
                      pro.setQuantidade(rs .getDouble(3));
                      pro.setPreco(rs .getDouble(4));
                                                       
                                 
                       lista.add(pro);
                  
              }
           }catch(Exception e){
                  JOptionPane.showMessageDialog(null, e.toString());
           }
              
         }
          
          
          return lista;
      }

}
