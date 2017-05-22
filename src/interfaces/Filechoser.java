
package interfaces;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import static javax.swing.JFileChooser.FILES_AND_DIRECTORIES;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class Filechoser extends javax.swing.JFrame
{

    private File[] FilesList;
    private String EncDec;
    boolean AdngFils;
    
    public Filechoser(String EncOrDec)
    {
        this.EncDec=EncOrDec;
      
        initComponents();
        jFileChooser1.setDialogTitle("Select files & those folders whose files you wish to "+EncOrDec);
        jFileChooser1.setMultiSelectionEnabled(true);
        jFileChooser1.setFileSelectionMode(FILES_AND_DIRECTORIES);
        jFileChooser1.setDialogTitle(EncOrDec);
        if(EncOrDec.equalsIgnoreCase("encrypt"))
        {
            UIManager.put("FileChooser.openDialogTitleText", "Select Files To Encrypt");
            UIManager.put("FileChooser.openButtonText", "Select Files To Encrypt");
        }
        else if(EncOrDec.equalsIgnoreCase("decrypt"))
        {
            UIManager.put("FileChooser.openDialogTitleText", "Select Files To Decrypt");
            UIManager.put("FileChooser.openButtonText", "Select Files To Decrypt");
        }
        
        UIManager.put("FileChooser.cancelButtonText", "Cancel");
        UIManager.put("FileChooser.fileNameLabelText", "FileName");
        UIManager.put("FileChooser.filesOfTypeLabelText", "TypeFiles");
        UIManager.put("FileChooser.openButtonToolTipText", "Select File");
        UIManager.put("FileChooser.cancelButtonToolTipText","Cancel");
        UIManager.put("FileChooser.fileNameHeaderText","FileName");
        UIManager.put("FileChooser.upFolderToolTipText", "UpOneLevel");
        UIManager.put("FileChooser.homeFolderToolTipText","Desktop");
        UIManager.put("FileChooser.newFolderToolTipText","Create a NewFolder");
        UIManager.put("FileChooser.listViewButtonToolTipText","List");
        UIManager.put("FileChooser.filterLabelText", "TypeFiles");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Details");
        UIManager.put("FileChooser.fileSizeHeaderText","Size");
        UIManager.put("FileChooser.fileDateHeaderText", "DateModified");
        SwingUtilities.updateComponentTreeUI(jFileChooser1);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener( new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {   
                setVisible(false);
                dispose();
                new Main(false).setVisible(true);
            }
        });
        
    }

    public Filechoser(String EncDEc, File[] ListFls)
    {
        this.EncDec=EncDEc;
        this.FilesList= ListFls;
        AdngFils=true;
      
        initComponents();
        jFileChooser1.setDialogTitle("Select files & those folders whose files you wish to "+EncDEc);
        jFileChooser1.setMultiSelectionEnabled(true);
        jFileChooser1.setFileSelectionMode(FILES_AND_DIRECTORIES);
        jFileChooser1.setDialogTitle(EncDEc);
        if(EncDEc.equalsIgnoreCase("encrypt"))
        {
            UIManager.put("FileChooser.openDialogTitleText", "Select Files To Encrypt");
            UIManager.put("FileChooser.openButtonText", "Select Files To Encrypt");
        }
        else if(EncDEc.equalsIgnoreCase("decrypt"))
        {
            UIManager.put("FileChooser.openDialogTitleText", "Select Files To Decrypt");
            UIManager.put("FileChooser.openButtonText", "Select Files To Decrypt");
        }
       
         UIManager.put("FileChooser.newFolderToolTipText","Create a NewFolder");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Type Files");
        UIManager.put("FileChooser.openButtonToolTipText", "Select File");
         UIManager.put("FileChooser.fileNameLabelText", "Name of file");
          UIManager.put("FileChooser.cancelButtonText", "Cancel");
        UIManager.put("FileChooser.fileNameHeaderText","Name of file");
        UIManager.put("FileChooser.upFolderToolTipText", "UpOneLevel");
          UIManager.put("FileChooser.cancelButtonToolTipText","Cancel");
        UIManager.put("FileChooser.fileDateHeaderText", "DateModified");
        UIManager.put("FileChooser.listViewButtonToolTipText","List");
       UIManager.put("FileChooser.homeFolderToolTipText","Desktop");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Details");
        UIManager.put("FileChooser.fileSizeHeaderText","Size");
         UIManager.put("FileChooser.filterLabelText", "TypeFiles");
        SwingUtilities.updateComponentTreeUI(jFileChooser1);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener( new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {                
                setVisible(false);
                dispose();
                new Main(false).setVisible(true);
            }
        });
    }
    
    
    private boolean anyEncFileExists(File[] listOfFilesAndFolders)
    {
        for(File file:listOfFilesAndFolders)
        {
            String filePath=file.getAbsoluteFile().toString();
            if(!file.isDirectory() && filePath.substring(filePath.length()-4, filePath.length()).equals(".enc"))
            {
                System.out.println(file.getAbsoluteFile()+ " is already encrypted");
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "1 or more files are already encrypted !! \nPlease de-select them.");
                return true;
            } 
        }
        return false;
    }
    
    private boolean EncFiles(File[] FilesList)
    {
       for(File file:FilesList)
        {
            String filePath=file.getAbsoluteFile().toString();
            if(!file.isDirectory() &&!filePath.substring(filePath.length()-4, filePath.length()).equals(".enc"))
            {
                System.out.println(file.getAbsoluteFile()+ " is not encrypted");
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "No more files to encrypted \nPlease de-select them.");
                return false;
            } 
        }
        return true;
    }
    
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jFileChooser1ActionPerformed
    {//GEN-HEADEREND:event_jFileChooser1ActionPerformed
        
        if(evt.getActionCommand().toString().equals("CancelSelection"))
        {
            if(AdngFils)
            {
               new ToBeEncryptedOrDecrypted(this.FilesList, EncDec).setVisible(true);
               setVisible(false);
               dispose();
            }
                    
            else if(!AdngFils)
            {
                new Main(false).setVisible(true);
                setVisible(false);
                dispose();
            }
            
        }
        
        else if(evt.getActionCommand().toString().equals("ApproveSelection"))
        {
            
            if(!AdngFils)
            {
                this.FilesList=jFileChooser1.getSelectedFiles();
            }
            
            else if(AdngFils)
            {
                File[] newFilesAndFolders=jFileChooser1.getSelectedFiles();
             
                
                int newLength= newFilesAndFolders.length+this.FilesList.length;
        
                File[] combinedFileArray = new File[newLength];
        
                int i;
                
                for(i=0; i<this.FilesList.length; i++)
                {
                    combinedFileArray[i]=this.FilesList[i];
                }
                for(int j=0; j<newFilesAndFolders.length; j++)
                {
                    combinedFileArray[i++]=newFilesAndFolders[j];
                }
                
                this.FilesList = combinedFileArray;
            }
           
            
            
            
           if(EncDec.equalsIgnoreCase("encrypt") && !anyEncFileExists(FilesList))
           {
               new ToBeEncryptedOrDecrypted(this.FilesList, EncDec).setVisible(true);
               setVisible(false);
               dispose();
           }
           
           else if(EncDec.equalsIgnoreCase("decrypt") && EncFiles(FilesList))
           {
                   new ToBeEncryptedOrDecrypted(FilesList, EncDec).setVisible(true);
                   setVisible(false);
                   dispose();
           }
           
        }        
        
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
 
}