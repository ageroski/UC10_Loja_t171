/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ClienteDAO;
import dao.ClienteFisicoJuridicoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.ClienteFisico;
import model.ClienteJuridico;

/**
 *
 * @author 181710074
 */
public class ListClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListClientes
     */
    public ListClientes() {
        initComponents();
        carregarTable("");
    }
    
    private void carregarTable(String tipo){
        DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = {};
        switch(tipo){
            case "": 
                List<Cliente> lista = ClienteDAO.getClientes();
                colunas = new String[]{"Código" , "Nome", "Endereço", "Cidade" };
                modelo.setColumnIdentifiers(colunas);
                for(Cliente cli : lista){
                    Object[] obj = {
                       cli.getCodigo(),
                       cli.getNome(),
                       cli.getEndereco(),
                       cli.getCidade() 
                    };
                    modelo.addRow(obj);
                }
                break;
            case Cliente.PESSOA_FISICA:
                colunas = new String []{"Código", "Nome", "Endereço", "Cidade" , "CPF", "RG" };
                modelo.setColumnIdentifiers(colunas);
                List<ClienteFisico> listaFisicos = ClienteFisicoJuridicoDAO.getClienteFisicos();
                for (ClienteFisico cli : listaFisicos){
                    Object[] obj = {
                        cli.getCodigo(),
                        cli.getNome(),
                        cli.getEndereco(),
                        cli.getCidade().getNome(),
                        cli.getCpf(),
                        cli.getRg()
                    };
                
                 modelo.addRow(obj);
                }
                
            tableClientes.setModel(modelo);
            break;
            case Cliente.PESSOA_JURIDICA:
            colunas = new String []{"Código", "Nome", "Endereço", "Cidade" , "CNPJ", "IE" };
                modelo.setColumnIdentifiers(colunas);
                List<ClienteJuridico> listaJuridicos = ClienteFisicoJuridicoDAO.getClienteJuridicos();
                for(ClienteJuridico cli : listaJuridicos){
                    Object[] obj = {
                       cli.getCodigo(),
                       cli.getNome(),
                       cli.getEndereco(),
                       cli.getCidade(),
                       cli.getCnpj(),
                       cli.getIe()
                    };
                    modelo.addRow(obj);
                    
        }
                tableClientes.setModel(modelo);
                break;
            case "todos" :
                colunas = new String[] {"Código", "Nome", "Endereço", "Cidade", "Tipo", "CPF / CNPJ", "RG / IE "};
                modelo.setColumnIdentifiers(colunas);
                lista = ClienteDAO.getClientes();
                listaFisicos = ClienteFisicoJuridicoDAO.getClienteFisicos();
                listaJuridicos = ClienteFisicoJuridicoDAO.getClienteJuridicos();
                for(Cliente cli : lista){
                    Object[] obj = {
                        cli.getCodigo(),
                        cli.getNome(),
                        cli.getEndereco(),
                        cli.getCidade().getNome(),
                        cli.getTipo(),
                        "",
                        ""
                     };
                    modelo.addRow(obj);
                }
                for(ClienteFisico cli : listaFisicos){
                    Object[] obj = {
                        cli.getCodigo(),
                        cli.getNome(),
                        cli.getEndereco(),
                        cli.getCidade().getNome(),
                        cli.getTipo(),
                        cli.getCpf(),
                        cli.getRg()
                     };
                    modelo.addRow(obj);
                  }
                for(ClienteJuridico cli : listaJuridicos){
                    Object[] obj = {
                        cli.getCodigo(),
                        cli.getNome(),
                        cli.getEndereco(),
                        cli.getCidade().getNome(),
                        cli.getTipo(),
                        cli.getCnpj(),
                        cli.getIe()
                     };
                    modelo.addRow(obj);
                }
                
                tableClientes.setModel(modelo);
                break;
    }

        }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Clientes");

        jLabel1.setText("Tipo : ");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clientes", "Clientes  Físicos", "Clientes Jurídicos", "Todos", " ", " " }));
        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoItemStateChanged(evt);
            }
        });

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableClientes.setPreferredSize(new java.awt.Dimension(800, 600));
        jScrollPane1.setViewportView(tableClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoItemStateChanged
       int posicao = cmbTipo.getSelectedIndex();
       switch(posicao){
           case 0 : 
               carregarTable("");
               break;
           case 1 : 
               carregarTable(Cliente.PESSOA_FISICA);
               break;
           case 2 : 
               carregarTable(Cliente.PESSOA_JURIDICA);
               break;
           case 3 :
               carregarTable("todos");
               break;
       }
    }//GEN-LAST:event_cmbTipoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableClientes;
    // End of variables declaration//GEN-END:variables
}
