package interfaces;

import Assignment2.NewClass;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class DecPas extends javax.swing.JFrame
{
   private File[] listOfFilesAndFolders;
    public DecPas(File[] listOfFilesAndFolders)
    {
        this.listOfFilesAndFolders=listOfFilesAndFolders;
          
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getRootPane().setDefaultButton(DecBtn);
        
        addWindowListener( new WindowAdapter()
        {
            public void closethewindow(WindowEvent e)
            {
                JFrame frame = (JFrame)e.getSource();
                Toolkit.getDefaultToolkit().beep();
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit the application?", "Exit Application", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION)
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        suggestionLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        DecBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        suggestionLabel.setFont(new java.awt.Font("Source Code Pro Semibold", 1, 15)); // NOI18N
        suggestionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        suggestionLabel.setText("Enter the Decription Password");

        passwordField.setToolTipText("");
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordFieldKeyReleased(evt);
            }
        });

        DecBtn.setBackground(new java.awt.Color(204, 255, 204));
        DecBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DecBtn.setText("Decrypt");
        DecBtn.setEnabled(false);
        DecBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(suggestionLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(397, 397, 397)
                .addComponent(DecBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(suggestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(DecBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_passwordFieldKeyReleased
    {//GEN-HEADEREND:event_passwordFieldKeyReleased
        if(passwordField.getPassword().length > 7)
        {
            DecBtn.setEnabled(true);
        }
        else if(passwordField.getPassword().length < 8)
        {
            DecBtn.setEnabled(false);
        }
        
    }//GEN-LAST:event_passwordFieldKeyReleased

    private void DecBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_DecBtnActionPerformed
    {//GEN-HEADEREND:event_DecBtnActionPerformed
        setVisible(false);
        dispose();
        
        new NewClass(listOfFilesAndFolders, "decrypt", new String(passwordField.getPassword())).execute();
        
    }//GEN-LAST:event_DecBtnActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DecBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel suggestionLabel;
    // End of variables declaration//GEN-END:variables
}
