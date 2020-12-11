
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class addpost extends javax.swing.JFrame {

    /**
     * Creates new form addpost
     */
     File f1;
     JFileChooser fc;
     String username1;
    BufferedImage changedimg,img,resizedimg;
    public addpost(String username) {
        initComponents();
           Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        int w=(int)d.getWidth();
        int h=(int)d.getHeight();
        setSize(w,h); 
      lbback1.setSize(w,h);

         btsave.setEnabled(false);
        this.username1=username;
          setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          
          ImageIcon icon=new ImageIcon("src/backpic/img18.jpg");
          Image img=icon.getImage();
          Image scaledimg=img.getScaledInstance(lbback1.getWidth(), lbback1.getHeight(), Image.SCALE_SMOOTH);
          lbback1.setIcon(new ImageIcon(scaledimg));
         setResizable(false);
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
        tfcaption = new javax.swing.JTextField();
        photo = new javax.swing.JLabel();
        lbphoto = new javax.swing.JLabel();
        browsebutton = new javax.swing.JButton();
        btsave = new javax.swing.JButton();
        addpostbutton = new javax.swing.JButton();
        btgrayscale = new javax.swing.JPanel();
        btblur = new javax.swing.JButton();
        btbrighter = new javax.swing.JButton();
        btdarker = new javax.swing.JButton();
        Grayscale = new javax.swing.JButton();
        bthefe = new javax.swing.JButton();
        btlofi = new javax.swing.JButton();
        btnashvile = new javax.swing.JButton();
        btwaldin = new javax.swing.JButton();
        btnofilter = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbback1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 102));
        jLabel1.setText("Caption");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(430, 120, 160, 40);

        tfcaption.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(tfcaption);
        tfcaption.setBounds(880, 120, 330, 70);

        photo.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        photo.setForeground(new java.awt.Color(102, 255, 102));
        photo.setText("photo");
        getContentPane().add(photo);
        photo.setBounds(420, 350, 120, 40);

        lbphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lbphoto);
        lbphoto.setBounds(580, 260, 340, 210);

        browsebutton.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        browsebutton.setText("Browse");
        browsebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsebuttonActionPerformed(evt);
            }
        });
        getContentPane().add(browsebutton);
        browsebutton.setBounds(1020, 260, 180, 40);

        btsave.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        btsave.setText("Save Change");
        btsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btsave);
        btsave.setBounds(1020, 400, 190, 40);

        addpostbutton.setFont(new java.awt.Font("Kristen ITC", 0, 36)); // NOI18N
        addpostbutton.setText("Add post");
        addpostbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpostbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(addpostbutton);
        addpostbutton.setBounds(1170, 480, 270, 60);

        btgrayscale.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btgrayscale.setLayout(null);

        btblur.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        btblur.setText("Blur");
        btblur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btblurActionPerformed(evt);
            }
        });
        btgrayscale.add(btblur);
        btblur.setBounds(10, 40, 150, 41);

        btbrighter.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        btbrighter.setText("Brighter");
        btbrighter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrighterActionPerformed(evt);
            }
        });
        btgrayscale.add(btbrighter);
        btbrighter.setBounds(260, 40, 150, 40);

        btdarker.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        btdarker.setText("Darker");
        btdarker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdarkerActionPerformed(evt);
            }
        });
        btgrayscale.add(btdarker);
        btdarker.setBounds(510, 40, 140, 41);

        Grayscale.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        Grayscale.setText("Grayscale");
        Grayscale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrayscaleActionPerformed(evt);
            }
        });
        btgrayscale.add(Grayscale);
        Grayscale.setBounds(10, 130, 150, 41);

        bthefe.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        bthefe.setText("Hefe");
        bthefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthefeActionPerformed(evt);
            }
        });
        btgrayscale.add(bthefe);
        bthefe.setBounds(260, 130, 150, 41);

        btlofi.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        btlofi.setText("LoFi");
        btlofi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlofiActionPerformed(evt);
            }
        });
        btgrayscale.add(btlofi);
        btlofi.setBounds(510, 130, 140, 41);

        btnashvile.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        btnashvile.setText("Nashvile");
        btnashvile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnashvileActionPerformed(evt);
            }
        });
        btgrayscale.add(btnashvile);
        btnashvile.setBounds(10, 220, 150, 41);

        btwaldin.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        btwaldin.setText("Waldin");
        btwaldin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btwaldinActionPerformed(evt);
            }
        });
        btgrayscale.add(btwaldin);
        btwaldin.setBounds(260, 220, 150, 41);

        btnofilter.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        btnofilter.setText("Nofilter");
        btnofilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnofilterActionPerformed(evt);
            }
        });
        btgrayscale.add(btnofilter);
        btnofilter.setBounds(510, 220, 140, 40);
        btgrayscale.add(jLabel4);
        jLabel4.setBounds(0, 0, 400, 290);

        getContentPane().add(btgrayscale);
        btgrayscale.setBounds(540, 590, 680, 290);

        jLabel2.setFont(new java.awt.Font("Kristen ITC", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setText("ADD POST");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(660, 40, 250, 50);

        jLabel3.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel3.setText("Aplly Filters");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(440, 500, 190, 70);
        getContentPane().add(lbback1);
        lbback1.setBounds(0, 0, 1510, 920);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btblurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btblurActionPerformed
        // TODO add your handling code here:
        BlurFilter obj = new BlurFilter();
        changedimg = obj.filter(img);
        resizedimg = resize(changedimg, lbphoto.getWidth(),lbphoto.getHeight());
        lbphoto.setIcon(new ImageIcon(resizedimg));
        repaint();
        btsave.setEnabled(true);
    }//GEN-LAST:event_btblurActionPerformed

    private void btbrighterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbrighterActionPerformed
        // TODO add your handling code here:
         BrighterFilter obj = new BrighterFilter();
        changedimg = obj.filter(img);
        resizedimg = resize(changedimg, lbphoto.getWidth(), lbphoto.getHeight());
        lbphoto.setIcon(new ImageIcon(resizedimg));
        repaint();
        btsave.setEnabled(true);
    }//GEN-LAST:event_btbrighterActionPerformed

    private void btdarkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdarkerActionPerformed
        // TODO add your handling code here:
         DarkerFilter obj = new DarkerFilter();
        changedimg = obj.filter(img);
        resizedimg = resize(changedimg, lbphoto.getWidth(), lbphoto.getHeight());
        lbphoto.setIcon(new ImageIcon(resizedimg));
        repaint();
        btsave.setEnabled(true);
    }//GEN-LAST:event_btdarkerActionPerformed

    private void GrayscaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrayscaleActionPerformed
        // TODO add your handling code here:
         GrayscaleFilter obj = new GrayscaleFilter();
        changedimg = obj.filter(img);
        resizedimg = resize(changedimg, lbphoto.getWidth(), lbphoto.getHeight());
        lbphoto.setIcon(new ImageIcon(resizedimg));
        repaint();
        btsave.setEnabled(true);
    }//GEN-LAST:event_GrayscaleActionPerformed

    private void bthefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthefeActionPerformed
        // TODO add your handling code here:
         HefeFilter obj = new HefeFilter();
        changedimg = obj.filter(img);
        resizedimg = resize(changedimg, lbphoto.getWidth(), lbphoto.getHeight());
        lbphoto.setIcon(new ImageIcon(resizedimg));
        repaint();
        btsave.setEnabled(true);
    }//GEN-LAST:event_bthefeActionPerformed

    private void btlofiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlofiActionPerformed
        // TODO add your handling code here:
         LoFiFilter obj = new LoFiFilter();
        changedimg = obj.filter(img);
        resizedimg = resize(changedimg, lbphoto.getWidth(), lbphoto.getHeight());
        lbphoto.setIcon(new ImageIcon(resizedimg));
        repaint();
        btsave.setEnabled(true);
    }//GEN-LAST:event_btlofiActionPerformed

    private void btnashvileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnashvileActionPerformed
        // TODO add your handling code here:
         NashvilleFilter obj = new  NashvilleFilter ();
        changedimg = obj.filter(img);
        resizedimg = resize(changedimg, lbphoto.getWidth(), lbphoto.getHeight());
        lbphoto.setIcon(new ImageIcon(resizedimg));
        repaint();
        btsave.setEnabled(true);
    }//GEN-LAST:event_btnashvileActionPerformed

    private void btwaldinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btwaldinActionPerformed
        // TODO add your handling code here:
         WaldenFilter obj = new WaldenFilter ();
        changedimg = obj.filter(img);
        resizedimg = resize(changedimg, lbphoto.getWidth(), lbphoto.getHeight());
        lbphoto.setIcon(new ImageIcon(resizedimg));
        repaint();
        btsave.setEnabled(true);
         
    }//GEN-LAST:event_btwaldinActionPerformed

    private void btnofilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnofilterActionPerformed
        // TODO add your handling code here:
         NoFilter obj = new  NoFilter ();
        changedimg = obj.filter(img);
        resizedimg = resize(changedimg, lbphoto.getWidth(), lbphoto.getHeight());
        lbphoto.setIcon(new ImageIcon(resizedimg));
        repaint();
        btsave.setEnabled(true);
    }//GEN-LAST:event_btnofilterActionPerformed

    private void browsebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsebuttonActionPerformed
        // TODO add your handling code here:
          fc=new JFileChooser();
      int ans= fc.showOpenDialog(this);
      if(ans==JFileChooser.APPROVE_OPTION){
//      fc.getSelectedFile();
      f1=fc.getSelectedFile();
//          System.out.println(f1.getPath());
     // lbphoto.setText(f1.getPath());
          try {
              img=ImageIO.read(f1);
              BufferedImage newimg=resize(img,lbphoto.getWidth(),lbphoto.getHeight());
              lbphoto.setIcon(new ImageIcon(newimg));
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
    }//GEN-LAST:event_browsebuttonActionPerformed
    
    private void addpostbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpostbuttonActionPerformed
        //TODO add your handling code here:
        String caption=tfcaption.getText();
        String photo=lbphoto.getText();
        try{
        
              HttpResponse<String> httpResponse = Unirest.post(globalclass.ip+"/addpost")
                      .queryString("caption",caption)
                      .queryString("username",username1)
                      .field("photo",f1)
                      .asString();
              String msg=httpResponse.getBody();
              
//             if(msg.equals("inserted"))
//             {
//                 JOptionPane.showMessageDialog(rootPane,"successfull");
//             }
               addstory obj=new addstory(msg);
               obj.setVisible(true);
        }
        catch(Exception ae)
        {
            ae.printStackTrace();
        }
              
        
    }//GEN-LAST:event_addpostbuttonActionPerformed

    private void btsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsaveActionPerformed
             f1=new File("src/FilteredPhotos");
            if(!(f1.exists())){
                f1.mkdir();
            }
            String filename=new Date().getTime()+".jpg";
            f1=new File("src/FilteredPhotos/"+filename);
         try {
             ImageIO.write(changedimg,"jpg",f1);
             JOptionPane.showMessageDialog(rootPane, "File saved successfully");
             
             // TODO add your handling code here:
         } catch (IOException ex) {
                ex.printStackTrace();
         }
    }//GEN-LAST:event_btsaveActionPerformed

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
            java.util.logging.Logger.getLogger(addpost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addpost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addpost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addpost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new addpost().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Grayscale;
    private javax.swing.JButton addpostbutton;
    private javax.swing.JButton browsebutton;
    private javax.swing.JButton btblur;
    private javax.swing.JButton btbrighter;
    private javax.swing.JButton btdarker;
    private javax.swing.JPanel btgrayscale;
    private javax.swing.JButton bthefe;
    private javax.swing.JButton btlofi;
    private javax.swing.JButton btnashvile;
    private javax.swing.JButton btnofilter;
    private javax.swing.JButton btsave;
    private javax.swing.JButton btwaldin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbback1;
    private javax.swing.JLabel lbphoto;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField tfcaption;
    // End of variables declaration//GEN-END:variables
        BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
}

