
import javax.swing.JOptionPane;

public class MiniExplorerGUI extends javax.swing.JFrame {

    private DataModel model = new DataModel();

    public MiniExplorerGUI() {
        initComponents();
        FileList.setCellRenderer(new CellRenderer());
        FileList.setModel(model);
        model.openDir("D:\\Projekte\\Git_Projekt\\Bsp_102_MiniExplorer");
        model.sortFiles();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        FileList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiniExplorer");

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
        try {
            int sel = FileList.getSelectedIndex();
            if (sel > -1) {
                Data d = model.getElementAt(sel);
                if (sel == 0) {
                    String[] helpStr = d.getAbsolutePath().replace("\\", ";").split(";");
                    String newPath = d.getAbsolutePath().replace(helpStr[helpStr.length - 1], "");
                    model.openDir(newPath);
                    model.sortFiles();
                } else {
                    model.openDir(d.getParent() + "\\" + d.getName() + "\\");
                    model.sortFiles();
                }
            }
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Please do not open Files in this explorer!");
            FileList.setCellRenderer(new CellRenderer());
        }

    }//GEN-LAST:event_FileListMouseClicked

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
    private javax.swing.JList<Data> FileList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
