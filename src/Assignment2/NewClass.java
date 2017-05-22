
package Assignment2;

import interfaces.process;
import interfaces.Exceptions;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.*;


public class NewClass extends SwingWorker <Boolean,Boolean>
{
    File[] folderlist;
    String key;
    int NoOfFles;
    long TotlSzeOfFils;
    NewClass1 EncAndDecFile;
    String EncOrDec;
    JProgressBar progressBar;
    JButton oKButton;
    JLabel progressPercentLabel;
    JTextArea progrssTxtFld;
    process progressFrame;
    
    
    
    public NewClass(File[] lstFles, String EncDec, String a)
    {
        this.folderlist = lstFles;
        this.EncOrDec = EncDec;
        this.key=a;
        progressFrame= new process(EncDec);
        progressFrame.setVisible(true);
        EncAndDecFile = new NewClass1();
        progressBar = progressFrame.getProgressBar();
         progrssTxtFld = progressFrame.getProgressOfFilesTextField();
        progressPercentLabel = progressFrame.getProgressPercentLabel();
        oKButton=progressFrame.getoKButton();
        SetTotlSzeAndNoOfFils();
    }
    
            protected void doe()
    {
        try
        {
        
        progressFrame.setCompletedTask(true);
        Toolkit.getDefaultToolkit().beep();
        oKButton.setVisible(true);
        oKButton.setEnabled(true);
        oKButton.setText("OK");
                    
        }
        catch (Exception e)
        {
            new Exceptions("Unexpected Error!", "Something wrong", e).setVisible(true);
        }
    }
    
   

    
     @Override
    protected Boolean doInBackground() 
    {
        try
        {
            if(EncOrDec.equalsIgnoreCase("encrypt"))
            {
                encrypt();
            }
            else if(EncOrDec.equalsIgnoreCase("decrypt"))
            {
                decrypt();            
            }
        }
        catch (Exception e)
        {
              new Exceptions("Unexpected Error!", "Something wrong", e).setVisible(true);         
        }
        finally
        {
            return true;
        }
    }
    
    
    
   
    private void encrypt(File file)
    {
        if(!file.isDirectory() && file.exists())
        {
             progrssTxtFld.append("Encrypting "+file.getAbsolutePath()+"\n");
            EncAndDecFile.encrypt(file, key, progressBar, progressPercentLabel, TotlSzeOfFils,  progrssTxtFld);
            progrssTxtFld.append("Done!\n\n");
        }
        else if(file.isDirectory() && file.exists())
        {
            File[] filesInTheDirectory=file.listFiles();
             progrssTxtFld.append("\n~~~~~~~~~~~  Inside "+file.getAbsolutePath()+"   ~~~~~~~~~~~\n");
            for(File eachFileInTheDirectory:filesInTheDirectory)
            {
                encrypt(eachFileInTheDirectory);
            }
             progrssTxtFld.append("~~~~~~~~~~~~~   End of "+file.getAbsolutePath()+"   ~~~~~~~~~~~~~\n\n");
        }
    }
    
     private void encrypt()
    {
        for(File file:folderlist)
        {
            encrypt(file);
        }
        progressBar.setValue(progressBar.getMaximum());
        progressPercentLabel.setText("100%");
    }
    
    private void decrypt()
    {
        for(File file:folderlist)
        {
                decrypt(file);
        }
        progressBar.setValue(progressBar.getMaximum());
        progressPercentLabel.setText("100%");
    }
    private void decrypt(File file)
    {
        if(!file.isDirectory() && file.exists() && file.getName().substring(file.getName().length()-4, file.getName().length()).equalsIgnoreCase(".enc"))
        {
             progrssTxtFld.append("Decrypting "+file.getAbsolutePath()+"\n");
            EncAndDecFile.decrypt(file, key, progressBar, progressPercentLabel, TotlSzeOfFils,  progrssTxtFld);
             progrssTxtFld.append("Done!\n\n");
        }
        else if(file.isDirectory() && file.exists())
        {
            File[] filesInTheDirectory=file.listFiles();
             progrssTxtFld.append("\n~~~~~~~~  Inside "+file.getAbsolutePath()+"   ~~~~~~~\n");
            for(File eachFileInTheDirectory:filesInTheDirectory)
            {
                
                decrypt(eachFileInTheDirectory);
            }
             progrssTxtFld.append("~  End of "+file.getAbsolutePath()+"   ~~~~~~~~\n\n");
        }
    }
    
        private void SetTotlSzeNoOfFles(File a)
    {
        if(!a.isDirectory() && a.exists())
        {
            NoOfFles++;
           TotlSzeOfFils+=a.length();
        }
        else if(a.isDirectory() && a.exists())
        {
            File[] filesInTheDirectory=a.listFiles();
            
            for(File eachFileInTheDirectory:filesInTheDirectory)
            {
                SetTotlSzeNoOfFles(eachFileInTheDirectory);
            }
        }
    }
    private void SetTotlSzeAndNoOfFils()
    {
        for(File file:folderlist)
        {
           SetTotlSzeNoOfFles(file);
        }
    }
    

    
     
    
    
}