
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
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
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
       setSize(900,900);
        lbback.setSize(900,900);
        setVisible(true);
       // Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        // int w = (int) d.getWidth();
          // int h = (int) d.getHeight();
      //  setSize(w, h);
     //  lbback.setSize(w,h);

        setLocationRelativeTo(null);
          setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          ImageIcon icon=new ImageIcon("src/backpic/img20.jpg");
          Image img=icon.getImage();
          Image scaledimg=img.getScaledInstance(lbback.getWidth(), lbback.getHeight(), Image.SCALE_SMOOTH);
          lbback.setIcon(new ImageIcon(scaledimg));
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
        jLabel2 = new javax.swing.JLabel();
        tfusername = new javax.swing.JTextField();
        loginbutton = new javax.swing.JButton();
        tfpassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 110, 170, 40);

        jLabel2.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 230, 150, 40);

        tfusername.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(tfusername);
        tfusername.setBounds(420, 110, 180, 40);

        loginbutton.setBackground(new java.awt.Color(204, 204, 204));
        loginbutton.setFont(new java.awt.Font("Adobe Caslon Pro", 3, 24)); // NOI18N
        loginbutton.setForeground(new java.awt.Color(0, 153, 153));
        loginbutton.setText("login");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(loginbutton);
        loginbutton.setBounds(280, 400, 170, 50);

        tfpassword.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(tfpassword);
        tfpassword.setBounds(410, 250, 180, 40);

        jLabel3.setFont(new java.awt.Font("Kristen ITC", 0, 36)); // NOI18N
        jLabel3.setText("LOGIN");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 20, 210, 40);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 860, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
        // TODO add your handling code here:
        String username=tfusername.getText();
        String password=tfpassword.getText();
        if(username.isEmpty()||password.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"please fill all filed");
        }
        else
        {
            try
            {
                 HttpResponse<String> httpResponse = Unirest.get(globalclass.ip+"/login")
                         .queryString("username", username)
                        .queryString("password", password)
                         .asString();
                 if(httpResponse.getStatus()== 200)
                 {
                     String s=httpResponse.getBody();
                   
                     if(s.equals("success")){
                       userhome obj = new userhome(username);
                       obj.setVisible(true);
                       dispose();
                     }
                     else{
                         JOptionPane.showMessageDialog(rootPane, "Login failed");
                     }
                 
                 }else
                 {
                     System.out.println(httpResponse.getStatus());
                 }
            }
            catch(Exception ae )
            {
                ae.printStackTrace();
            }
        }
    }//GEN-LAST:event_loginbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbback;
    private javax.swing.JButton loginbutton;
    private javax.swing.JPasswordField tfpassword;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
