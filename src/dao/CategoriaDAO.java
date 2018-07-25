package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Cidade;

public class CategoriaDAO {
    
 public static boolean inserir(Categoria categoria){
        String sql = "INSERT INTO categoria "
            + " ( nome ) VALUES "
            + " ( '" + categoria.getNome() + "' );";
        return Conexao.executar(sql);
    }
      
    public static boolean editar(Categoria categoria){
        String sql = "UPDATE categoria SET "
            + " nome =  '" + categoria.getCodigo();
        return Conexao.executar(sql);
    }
    
      public static boolean excluir(Categoria categoria){
        String sql = "DELETE FROM  categoria  "
            + " WHERE codigo = " + categoria.getCodigo();
        return Conexao.executar(sql);
    }
      
      public static List<Categoria> getCategoria(){         
          List<Categoria> lista = new ArrayList<>();
          String sql = "SELECT * FROM categoria ORDER BY nome";
          
          ResultSet rs = Conexao.consultar(sql);
          
          if (rs != null) {
              try{
                  while (rs.next()){
                      Categoria cat = new Categoria();
                      cat.setCodigo(rs.getInt(1));
                      cat.setNome(rs.getString(2));
                      
                      lista.add(cat);
              }
           }catch(Exception e){
                  JOptionPane.showMessageDialog(null, e.toString());
           }
              
         }
          
          
          return lista;
      }
              
}
