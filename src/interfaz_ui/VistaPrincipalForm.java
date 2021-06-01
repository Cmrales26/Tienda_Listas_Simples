/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz_ui;

import Nodos.NodoProducto;
import clases.Pedido;
import clases.PedidoProducto;
import clases.Usuario;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pilas.PilaPedido;
import pilas.PilaPedidoProducto;
import pilas.PilaProducto;
import pilas.PilaUsuario;

/**
 *
 * @author Diana, Nelson y Mauricio
 */
public class VistaPrincipalForm extends javax.swing.JFrame
{

    private Usuario usuarioCliente;
    protected PilaUsuario pilaUsuario;
    protected PilaProducto pilaProducto;
    protected PilaPedido pilaPedido;
    protected PilaPedidoProducto pilaPedidoProducto;
    private EditarPerfilForm editar_perfil;
    private loginUsuarioForm login_usuario;
    private GestionProductosForm gestion_productos;
    private GestionPedidosForm gestion_pedidos;
    private DefaultTableModel modelo;
    private Integer nPedido;
    private Integer nProductoActualizar = null;
    private Calendar calendario = Calendar.getInstance();

    public VistaPrincipalForm()
    {
        initComponents();
    }

    public VistaPrincipalForm(Usuario usuarioCliente)
    {
        initComponents();
        this.setLocationRelativeTo(null);
        this.modelo = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return column >= 2;
            }
        };
        String[] titulos = {"Nombre", "Cantidad"};
        this.modelo.setColumnIdentifiers(titulos);
        this.tblCarrito.setModel(modelo);
        this.usuarioCliente = usuarioCliente;
        this.pilaProducto = new PilaProducto("productos.bin");
        this.pilaPedido = new PilaPedido("pedidos.bin");
        this.pilaPedidoProducto = new PilaPedidoProducto("pedidoProductos.bin");
        this.pilaUsuario = new PilaUsuario("usuarios.bin");
        this.nPedido = usuarioCliente.getNumeroPedido();
        this.txtNumeroPedido.setText(nPedido.toString());
        configuracionPanel();
        configuracion(1);
        listaProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUsuarioCliente = new javax.swing.JLabel();
        btnEditarPerfil = new javax.swing.JButton();
        btnGestionProductos = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnListaPedidos = new javax.swing.JButton();
        lblNombreCliente = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrito = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxProducto = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNumeroPedido = new javax.swing.JTextField();
        btnCrearPedido = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnEditarPerfil.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnEditarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/editar.png"))); // NOI18N
        btnEditarPerfil.setText("Editar Perfil");
        btnEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPerfilActionPerformed(evt);
            }
        });

        btnGestionProductos.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnGestionProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/analysis.png"))); // NOI18N
        btnGestionProductos.setText("Gestion Productos");
        btnGestionProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionProductosActionPerformed(evt);
            }
        });

        btnCerrarSesion.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cerrar-sesion.png"))); // NOI18N
        btnCerrarSesion.setText("<html>Cerrar Sesión<html>");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnListaPedidos.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnListaPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/contract.png"))); // NOI18N
        btnListaPedidos.setText("Lista Pedidos");
        btnListaPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaPedidosActionPerformed(evt);
            }
        });

        lblNombreCliente.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnGestionProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 173, Short.MAX_VALUE)
                        .addComponent(btnListaPedidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addComponent(btnEditarPerfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuarioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuarioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnEditarPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListaPedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGestionProductos)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carrito de compras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 3, 14))); // NOI18N

        tblCarrito.setBackground(new java.awt.Color(255, 204, 204));
        tblCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCarritoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCarrito);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos de compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 3, 14))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel1.setText("producto");

        cbxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione..." }));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel2.setText("Cantidad");

        btnAgregar.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");

        btnActualizar.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel3.setText("#Pedido");

        txtNumeroPedido.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnCrearPedido.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnCrearPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/boton-agregar (1).png"))); // NOI18N
        btnCrearPedido.setText("Crear Pedido");
        btnCrearPedido.setBorder(new javax.swing.border.MatteBorder(null));
        btnCrearPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrearPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidad))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumeroPedido)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnCancelar))
                .addGap(32, 32, 32)
                .addComponent(btnCrearPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Super tiendas y Almacenes DVMQ");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/tienda (1).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarPerfilActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEditarPerfilActionPerformed
    {//GEN-HEADEREND:event_btnEditarPerfilActionPerformed
        if (editar_perfil == null) {
            editar_perfil = new EditarPerfilForm(usuarioCliente, this);
            editar_perfil.setVisible(true);
        } else {
            if (!editar_perfil.isVisible()) {
                editar_perfil.setVisible(true);
            }
        }

    }//GEN-LAST:event_btnEditarPerfilActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCerrarSesionActionPerformed
    {//GEN-HEADEREND:event_btnCerrarSesionActionPerformed
        login_usuario = new loginUsuarioForm();
        if (editar_perfil != null) {
            if (editar_perfil.isVisible()) {
                editar_perfil.dispose();
            }
        }
        login_usuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnGestionProductosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGestionProductosActionPerformed
    {//GEN-HEADEREND:event_btnGestionProductosActionPerformed
        if (gestion_productos == null) {
            gestion_productos = new GestionProductosForm(this);
            gestion_productos.setVisible(true);
        } else {
            if (!gestion_productos.isVisible()) {
                gestion_productos.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnGestionProductosActionPerformed

    private void tblCarritoMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tblCarritoMouseClicked
    {//GEN-HEADEREND:event_tblCarritoMouseClicked
        if (evt.getClickCount() == 1) {
            int fila = tblCarrito.getSelectedRow();
            if (fila != -1) {
                configuracion(2);
                cbxProducto.setSelectedItem(modelo.getValueAt(fila, 0));
                txtCantidad.setText(modelo.getValueAt(fila, 1).toString());
                nProductoActualizar = fila;
            }
        } else {
            int fila = tblCarrito.getSelectedRow();
            if (fila != -1) {
                int accion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el prodcuto seleccionado del carrito de compras?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (accion == JOptionPane.YES_OPTION) {
                    modelo.removeRow(fila);
                    limpiarCampos();
                }
            }
        }
    }//GEN-LAST:event_tblCarritoMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelarActionPerformed
    {//GEN-HEADEREND:event_btnCancelarActionPerformed
        limpiarCampos();
        configuracion(1);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnActualizarActionPerformed
    {//GEN-HEADEREND:event_btnActualizarActionPerformed
        if (cbxProducto.getSelectedIndex() != 0 && validarNumero(txtCantidad.getText().trim()) && Integer.parseInt(txtCantidad.getText().trim()) > 0 && nProductoActualizar != null) {
            Vector vector = new Vector();
            String producto = cbxProducto.getSelectedItem().toString();
            String cantidad = txtCantidad.getText().trim();
            modelo.setValueAt(producto, nProductoActualizar, 0);
            modelo.setValueAt(cantidad, nProductoActualizar, 1);
            limpiarCampos();
            configuracion(1);
        } else {
            JOptionPane.showMessageDialog(this, "verifique que haya seleccionado un producto y\n"
                    + "que su cantidad sea mayor que cero");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAgregarActionPerformed
    {//GEN-HEADEREND:event_btnAgregarActionPerformed
        if (cbxProducto.getSelectedIndex() != 0 && validarNumero(txtCantidad.getText().trim()) && Integer.parseInt(txtCantidad.getText().trim()) > 0) {
            Vector vector = new Vector();
            String producto = cbxProducto.getSelectedItem().toString();
            String cantidad = txtCantidad.getText().trim();
            vector.add(producto);
            vector.add(cantidad);
            modelo.addRow(vector);
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "verifique que haya seleccionado un producto y\n"
                    + "que su cantidad sea mayor que cero");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCrearPedidoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCrearPedidoActionPerformed
    {//GEN-HEADEREND:event_btnCrearPedidoActionPerformed
        if (modelo.getDataVector().size() > 0) {
            int id = 1;
            String fecha = String.valueOf(calendario.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(calendario.get(Calendar.MONTH)) + "/" + String.valueOf(calendario.get(Calendar.YEAR));
            Pedido pedido = new Pedido(nPedido, usuarioCliente.getUsuario(), usuarioCliente.getNumeroIdentificacion(), fecha);
            pilaPedido.insertarPedido(pedido);
            for (int i = 0; i < modelo.getRowCount(); i++) {
                PedidoProducto pedidoProducto = new PedidoProducto(nPedido, id, modelo.getValueAt(i, 0).toString(), usuarioCliente.getNumeroIdentificacion(), modelo.getValueAt(i, 1).toString());
                pilaPedidoProducto.insertarPedidoProducto(pedidoProducto);
            }
            usuarioCliente.setNumeroPedido();
            pilaUsuario.editarUsuario(usuarioCliente);
            nPedido = usuarioCliente.getNumeroPedido();
            txtNumeroPedido.setText(nPedido.toString());
            modelo.getDataVector().removeAllElements();
            tblCarrito.updateUI();
            if(gestion_pedidos != null && (gestion_pedidos.isVisible() || !gestion_pedidos.isVisible())){
                gestion_pedidos.pilaPedido.recargarRaiz();
                gestion_pedidos.pilaPedidoProducto.recargarRaiz();
                gestion_pedidos.crearTablaPedidos();
            }
            limpiarCampos();
            configuracion(1);
            JOptionPane.showMessageDialog(this, "¡El pedido se creo!");
        } else {
            JOptionPane.showMessageDialog(this, "¡verifique que haya seleccionado un producto!");
        }
    }//GEN-LAST:event_btnCrearPedidoActionPerformed

    private void btnListaPedidosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnListaPedidosActionPerformed
    {//GEN-HEADEREND:event_btnListaPedidosActionPerformed
        if (gestion_pedidos == null) {
            gestion_pedidos = new GestionPedidosForm(usuarioCliente);
            gestion_pedidos.setVisible(true);
        } else {
            if (!gestion_pedidos.isVisible()) {
                gestion_pedidos.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnListaPedidosActionPerformed

    private void configuracionPanel()
    {
        this.lblNombreCliente.setText(this.usuarioCliente.getNombre() + " " + this.usuarioCliente.getApellidos());
        this.lblUsuarioCliente.setText(this.usuarioCliente.getUsuario());
        if (!this.usuarioCliente.getRole().equals("admin")) {
            this.btnGestionProductos.setVisible(false);
        }
        this.txtNumeroPedido.setEnabled(false);

    }

    private void configuracion(int caso)
    {
        switch (caso) {
            case 1:
                btnActualizar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnAgregar.setEnabled(true);
                btnLimpiar.setEnabled(true);
                break;
            case 2:
                btnActualizar.setEnabled(true);
                btnCancelar.setEnabled(true);
                btnAgregar.setEnabled(false);
                btnLimpiar.setEnabled(false);
                break;
        }

    }

    private void limpiarCampos()
    {
        cbxProducto.setSelectedIndex(0);
        txtCantidad.setText("");
        nProductoActualizar = null;
    }

    private boolean validarNumero(String numero)
    {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected void listaProductos()
    {
        try {
            cbxProducto.removeAllItems();
            cbxProducto.addItem("Seleccione...");
            NodoProducto nodo = pilaProducto.getNodoRaizProducto();
            while (nodo != null) {
                cbxProducto.addItem(nodo.valorNodo.getCodigo() + "--" + nodo.valorNodo.getNombre());
                nodo = nodo.siguienteNodo;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VistaPrincipalForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCrearPedido;
    private javax.swing.JButton btnEditarPerfil;
    private javax.swing.JButton btnGestionProductos;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnListaPedidos;
    private javax.swing.JComboBox<String> cbxProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblUsuarioCliente;
    private javax.swing.JTable tblCarrito;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNumeroPedido;
    // End of variables declaration//GEN-END:variables
}
