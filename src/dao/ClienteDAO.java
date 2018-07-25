package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cidade;
import model.Cliente;

public class ClienteDAO {
    
        public static boolean inserir(Cliente cliente){
        String sql = "INSERT INTO clientes "
            + " ( nome, endereco, tipo, codCidade ) VALUES "
            + " ( "
            + " '" + cliente.getNome()                + "' , " 
            + " '" +  cliente.getEndereco()           + "' , " 
            + " '" +  cliente.getTipo()               + "' ,   " 
            + "  " +   cliente.getCidade().getCodigo()+ "    "
            + " );";
        return Conexao.executar(sql);

        } 
        
        public static boolean editar (Cliente cliente){
        String sql = "UPDATE clientes SET "
            + "nome =      '" + cliente.getNome() +      "' ," 
            + "endereco =  '" +  cliente.getEndereco()+  "' ," 
            + "tipo =      '" +  cliente.getTipo() +   "' ,  " 
            + "codCidade =  " +   cliente.getCodigo() + "    "
            + "WHERE codigo =" + cliente.getCodigo(); 
        return Conexao.executar(sql);

        } 
        
        public static boolean excluir(Cliente cliente){
            String sql = "DELETE FROM clientes "
            + "WHERE  codigo = " + cliente.getCodigo();
            return Conexao.executar(sql);
            
        }
        
            public static List<Cliente> getClientes(){    
          List<Cliente> lista = new ArrayList<>();
          String sql = "SELECT c.codigo, c.nome, c.endereco, " 
                  + " c.tipo, d.codigo, d.nome "
                  + " FROM clientes c"
                  + " INNER JOIN cidades d ON c.codCidade = d.codigo"
                  + " WHERE c.tipo = '' "
                  + " ORDER BY c.nome";
          ResultSet rs = Conexao.consultar(sql);
          
          if (rs != null) {
              try{
                  while (rs.next()){
                      Cliente cli = new Cliente();
                      cli.setCodigo(rs.getInt(1));
                      cli.setNome(rs .getString(2));
                      cli.setEndereco(rs .getString(3));
                      cli.setTipo(rs .getString(4));
                      
                      Cidade cid = new Cidade();
                      cid.setCodigo(rs .getInt(5));
                      cid.setNome(rs .getString(6));
                      
                      
                      cli.setCidade(cid);
                      
                      lista.add(cli);
                  
              }
           }catch(Exception e){
                  JOptionPane.showMessageDialog(null, e.toString());
           }
              
         }
          
          
          return lista;
      }
}
