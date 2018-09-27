
import javax.swing.JOptionPane;

public class MiniExplorerGUI extends javax.swing.JFrame {

    private DataModel model = new DataModel();
    public static boolean sortedByKB;
    public static boolean asc;

    public MiniExplorerGUI() {
        initComponents();
        FileList.setCellRenderer(new CellRenderer());
        FileList.setModel(model);
        model.openDir(".");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContextMenu = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        sortASC = new javax.swing.JMenuItem();
        sortDESC = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        sortASC2 = new javax.swing.JMenuItem();
        sortDESC2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        FileList = new javax.swing.JList<>();

        jMenu1.setText("Sortieren nach Filegröße");

        sortASC.setText("Aufsteigend");
        sortASC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortASCActionPerformed(evt);
            }
        });
        jMenu1.add(sortASC);

        sortDESC.setText("Absteigend");
        sortDESC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortDESCActionPerformed(evt);
            }
        });
        jMenu1.add(sortDESC);

        ContextMenu.add(jMenu1);

        jMenu2.setText("Sortieren nach Alphabet");

        sortASC2.setText("Aufsteigend");
        sortASC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortASC2ActionPerformed(evt);
            }
        });
        jMenu2.add(sortASC2);

        sortDESC2.setText("Absteigend");
        sortDESC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortDESC2ActionPerformed(evt);
            }
        });
        jMenu2.add(sortDESC2);

        ContextMenu.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiniExplorer");

        FileList.setComponentPopupMenu(ContextMenu);
        FileList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FileListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(FileList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void FileListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FileListMouseClicked
        if (evt.getClickCount() >= 2) {
            try {
                int sel = FileList.getSelectedIndex();
                if (sel > -1) {
                    Data d = model.getElementAt(sel);
                    if (sel == 0) {
                        String[] helpStr = d.getAbsolutePath().replace("\\", ";").split(";");
                        String newPath = d.getAbsolutePath().replace(helpStr[helpStr.length - 1], "");
                        model.openDir(newPath);
                    } else {
                        model.openDir(d.getParent() + "\\" + d.getName() + "\\");
                    }
                }
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "You cannot open files in this explorer");
            }
        }
    }//GEN-LAST:event_FileListMouseClicked

    private void sortASCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortASCActionPerformed
        sortedByKB = true;
        asc = true;
        model.advancedSorting();
    }//GEN-LAST:event_sortASCActionPerformed

    private void sortDESCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortDESCActionPerformed
        sortedByKB = true;
        asc = false;
        model.advancedSorting();
    }//GEN-LAST:event_sortDESCActionPerformed

    private void sortASC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortASC2ActionPerformed
        sortedByKB = false;
        asc = true;
        model.advancedSorting();
    }//GEN-LAST:event_sortASC2ActionPerformed

    private void sortDESC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortDESC2ActionPerformed
        sortedByKB = false;
        asc = false;
        model.advancedSorting();
    }//GEN-LAST:event_sortDESC2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MiniExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiniExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiniExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiniExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniExplorerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu ContextMenu;
    private javax.swing.JList<Data> FileList;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem sortASC;
    private javax.swing.JMenuItem sortASC2;
    private javax.swing.JMenuItem sortDESC;
    private javax.swing.JMenuItem sortDESC2;
    // End of variables declaration//GEN-END:variables
}
