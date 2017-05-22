package interfaces;

import Assignment2.NewClass;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EncPas extends javax.swing.JFrame
{
    private File[] listOfFilesAndFolders;
    public EncPas(File[] listOfFilesAndFolders)
    {
        this.listOfFilesAndFolders = listOfFilesAndFolders;
      
        initComponents();
        setResizable(false);
        eightCharInstructionLabel.setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getRootPane().setDefaultButton(EncBtn);
        
        addWindowListener( new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                JFrame frame = (JFrame)e.getSource();
                Toolkit.getDefaultToolkit().beep();
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit ?", "Exit Application", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION)
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
    
    boolean PasVerify()
    {
        char password1[]=passwordField1.getPassword();
        char password2[]=passwordField2.getPassword();
        if(password1.length<8)
        {
            eightCharInstructionLabel.setText("You must enter password of atleast 8 characters");
            eightCharInstructionLabel.setVisible(true);
            return false;
        }
        if(password1.length>7)
        {
            eightCharInstructionLabel.setVisible(false);
            if(password1.length==password2.length)
            {
                eightCharInstructionLabel.setVisible(false);
                if(Arrays.equals(password1, password2))
                {
                    return true;
                }

            }
            eightCharInstructionLabel.setText("Both the passwords differ!");
            eightCharInstructionLabel.setVisible(true);
        }
        
        return false;
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        passwordField2 = new javax.swing.JPasswordField();
        eightCharInstructionLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        suggestionLabel = new javax.swing.JLabel();
        EncBtn = new javax.swing.JButton();
        passwordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 204));

        jPanel1.setBackground(new java.awt.Color(204, 255, 102));

        passwordField2.setToolTipText("");
        passwordField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordField2KeyReleased(evt);
            }
        });

        eightCharInstructionLabel.setForeground(new java.awt.Color(255, 0, 0));
        eightCharInstructionLabel.setText("*8 characteristist are needed");
        eightCharInstructionLabel.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Re-enter the password:");

        suggestionLabel.setBackground(new java.awt.Color(255, 255, 102));
        suggestionLabel.setFont(new java.awt.Font("Source Code Pro Semibold", 1, 16)); // NOI18N
        suggestionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        suggestionLabel.setText("Enter the Encryption password");

        EncBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EncBtn.setText("Encrypt");
        EncBtn.setEnabled(false);
        EncBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncBtnActionPerformed(evt);
            }
        });

        passwordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordField1KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Password:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordField1)
                            .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addComponent(eightCharInstructionLabel)
                        .addGap(0, 114, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(EncBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(356, 356, 356))
                    .addComponent(suggestionLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(suggestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightCharInstructionLabel))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(EncBtn)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordField2KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_passwordField2KeyReleased
    {//GEN-HEADEREND:event_passwordField2KeyReleased
        if(PasVerify())
        {
            EncBtn.setEnabled(true);
        }
        else
        {
            EncBtn.setEnabled(false);
        }
    }//GEN-LAST:event_passwordField2KeyReleased

    private void passwordField1KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_passwordField1KeyReleased
    {//GEN-HEADEREND:event_passwordField1KeyReleased
        if(PasVerify())
        {
            EncBtn.setEnabled(true);
        }
        else
        {
            EncBtn.setEnabled(false);
        }
    }//GEN-LAST:event_passwordField1KeyReleased

    private void EncBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_EncBtnActionPerformed
    {//GEN-HEADEREND:event_EncBtnActionPerformed
        setVisible(false);
        dispose();
        
        new NewClass(listOfFilesAndFolders, "encrypt", new String(passwordField1.getPassword())).execute();
        
    }//GEN-LAST:event_EncBtnActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EncBtn;
    private javax.swing.JLabel eightCharInstructionLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JPasswordField passwordField2;
    private javax.swing.JLabel suggestionLabel;
    // End of variables declaration//GEN-END:variables
}
