
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
public class usersearch extends javax.swing.JFrame {

    /**
     * Creates new form usersearch
     */
     String username1;
    public usersearch(String username) {
        initComponents();
       Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        int w=(int)d.getWidth();
        int h=(int)d.getHeight();
        setSize(w,h); 
      jScrollPane1.setSize(600,400);
      this.username1=username;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          lbback1.setSize(w,h);
        setVisible(true);
        
        
        
         ImageIcon icon=new ImageIcon("src/backpic/img5.jpg");
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

        tfsearch = new javax.swing.JTextField();
        searchbutton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        lbback1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tfsearch.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(tfsearch);
        tfsearch.setBounds(560, 70, 190, 50);

        searchbutton.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        searchbutton.setText("Search");
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(searchbutton);
        searchbutton.setBounds(860, 70, 180, 50);

        mainpanel.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        mainpanel.setLayout(null);
        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(490, 190, 770, 520);
        getContentPane().add(lbback1);
        lbback1.setBounds(0, 0, 1530, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
        // TODO add your handling code here:
        String search=tfsearch.getText();
        if(search.isEmpty())
        {
        JOptionPane.showMessageDialog(this, "please fill the field");
        
        }
        else
        {
            try
            {
                   HttpResponse<String> httpResponse = Unirest.get(globalclass.ip+"/usersearch") 
                           .queryString("search",search)
                           .asString();
                   String msg=httpResponse.getBody();
                   System.out.println(msg);
                   mainpanel.removeAll();
                   StringTokenizer st=new StringTokenizer(msg,"~");
                   int count=st.countTokens();
                   mainpanel.setPreferredSize(new Dimension(600,(count*200)));
                   panel ar[]=new panel[count];
                   int i=0;
                   int x=10;
                   int y=10;
                   while(st.hasMoreTokens()){
                       String token=st.nextToken();
                       StringTokenizer st2=new StringTokenizer(token,";");
                       String name=st2.nextToken();
                       String email=st2.nextToken();
                       String phno=st2.nextToken();
                       String photo=st2.nextToken(); 
                       if(name.equals(username1))
                       {
                           
                       }
                       else
                       {
                           
                       
                       ar[i]=new panel();
                       ar[i].setBounds(x,y,600,200);
                        HttpResponse<String> httpResponse1 = Unirest.get(globalclass.ip+"/checkfollow") 
                           .queryString("username",username1)
                           .queryString("name",name)
                           .asString();
                        String msg1=httpResponse1.getBody();
                        if(msg1.equals("yes")){
                            ar[i].followbutton.setText("followed");
                        }
                        else
                        {
                            ar[i].followbutton.setText("follow");
                        }
                        
                        try {
                    URL url = new URL(globalclass.ip+"/GetResource/"+photo);
                    BufferedImage image = ImageIO.read(url); 
                    BufferedImage newimg = resize(image,ar[i].lbphoto.getWidth(),ar[i].lbphoto.getHeight());
                    ar[i].lbphoto.setIcon(new ImageIcon(newimg));
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                     
                        
           final int a=i;
          ar[i].lbname.setText(name);
          
        ar[i].followbutton.addActionListener(new ActionListener() {
              @Override
            public void actionPerformed(ActionEvent e) {
//         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 try{
                    HttpResponse<String>httpres;
                  HttpResponse<String> httpResponse = Unirest.get(globalclass.ip+"/followuser") 
                      .queryString("followed_to",name)
                        .queryString("followed_by",username1)
                          .asString();
                     if( httpResponse .getStatus()==200){
                      String msg= httpResponse.getBody();
                     System.out.println(msg+"--->");
                        if(msg.equals("inserted")){
                           ar[a].followbutton.setText("followed");
                       }else{
                         ar[a].followbutton.setText("follow");
                         }
                       }
                     }
                      catch(Exception ae)
                     {
                            ae.printStackTrace();
                      }
                     }
                            
                   });
                 ar[i].lbemail.setText(email);
//                ar[i].lbphoto.setText(photo);
                ar[i].lbphoneno.setText(phno);
            //   ar[i].lbname.setText(name);
              mainpanel.add(ar[i]);
                    
               mainpanel.setVisible(false);
            mainpanel.setVisible(true);
             i++;
             y=y+210;
                }
         }
                   
                          
                   
     }
        catch(Exception ae)
      {
           ae.printStackTrace();
       }
       
             
     }
    }//GEN-LAST:event_searchbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(usersearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usersearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usersearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usersearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new usersearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbback1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JButton searchbutton;
    private javax.swing.JTextField tfsearch;
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
