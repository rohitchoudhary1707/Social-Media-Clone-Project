
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class showstory extends javax.swing.JFrame {

    /**
     * Creates new form showstory
     */
     String pid;
     int w,h;
    public showstory(String pid) {
        initComponents();
         Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
         w=(int)d.getWidth();
         h=(int)d.getHeight();
         jPanel1.setSize(w,100);
        setSize(w,h); 
         this.pid=pid;
         showstory1();
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbphoto = new javax.swing.JLabel();
        lbcaption = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 670, 90);

        lbphoto.setText("jLabel1");
        getContentPane().add(lbphoto);
        lbphoto.setBounds(231, 176, 200, 150);

        lbcaption.setText("jLabel2");
        getContentPane().add(lbcaption);
        lbcaption.setBounds(290, 390, 140, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(showstory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showstory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showstory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showstory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new showstory().setVisible(true);
            }
        });
    }
    void showstory1(){
        new Thread(new Runnable() {
            @Override
           
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               public void run()
               {
                   try{
                        HttpResponse<String> httpResponse = Unirest.get(globalclass.ip+"/showstory1")
                                .queryString("pid",pid)
                                 .asString();
                          String msg=httpResponse.getBody();
                          System.out.println("msg-->"+msg);
                            StringTokenizer st=new StringTokenizer(msg,"~");
                              int count=st.countTokens();
                              JProgressBar pbar[]=new JProgressBar[count];
                              int x=5,y=50;
                              int width=(int)(w/count);
                              for(int k=0;k<count;k++){
                                  pbar[k]=new JProgressBar();
                                  x=k*width;
                                  pbar[k].setBounds(x, y, width, 20);
                                  jPanel1.add(pbar[k]);
                                  jPanel1.repaint();
                              }
                              int i=0;
                                while(st.hasMoreTokens())
                               {
                             String token=st.nextToken();
                             StringTokenizer st2=new StringTokenizer(token,";");
                                String caption=st2.nextToken();
                                String photo=st2.nextToken();
                                //url
                                lbcaption.setText(caption);
                                        try {
                    URL url = new URL(globalclass.ip+"/GetResource/"+photo);
                    BufferedImage image = ImageIO.read(url); 
                    BufferedImage newimg = resize(image,lbphoto.getWidth(),lbphoto.getHeight());
                    lbphoto.setIcon(new ImageIcon(newimg));
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                                
                                for(int j=1;j<=100;j++){
                                    try {
                                        pbar[i].setValue(j);
                                        Thread.sleep(10);
                                    } catch (Exception e) {
                                 e.printStackTrace();
                                    }
                                }
                                i++;
                   }       
                   }
                   catch(Exception ex)
                       {
                         ex.printStackTrace();
                       }
                       }
            }).start();
        }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbcaption;
    private javax.swing.JLabel lbphoto;
    // End of variables declaration//GEN-END:variables

BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
}}