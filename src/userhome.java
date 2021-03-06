
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ACER
 */
public class userhome extends javax.swing.JFrame {

    String username;

    /**
     * Creates new form userhome
     */
    public userhome(String Username) {
        initComponents();

        this.username = Username;
        setVisible(true);
        // setSize(1000, 1000);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (int) d.getWidth();
        int h = (int) d.getHeight();
        setSize(w, h);
        logoutbutton.setBounds(1580,30,160,60);
        jLabel1.setText("Welcome .." + Username);
        Thread t1 = new Thread(new setpost());
        t1.start();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editprofile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        changepassword = new javax.swing.JButton();
        searchfriend = new javax.swing.JButton();
        myfollowersbutton = new javax.swing.JButton();
        myfollowingsbutton = new javax.swing.JButton();
        addpost = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        logoutbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        editprofile.setText("edit profile");
        editprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editprofileActionPerformed(evt);
            }
        });
        getContentPane().add(editprofile);
        editprofile.setBounds(540, 90, 180, 50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 20, 320, 60);

        changepassword.setText("Change password");
        changepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepasswordActionPerformed(evt);
            }
        });
        getContentPane().add(changepassword);
        changepassword.setBounds(820, 90, 170, 50);

        searchfriend.setText("Search friend");
        searchfriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchfriendActionPerformed(evt);
            }
        });
        getContentPane().add(searchfriend);
        searchfriend.setBounds(1080, 90, 150, 50);

        myfollowersbutton.setText("My followers");
        myfollowersbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myfollowersbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(myfollowersbutton);
        myfollowersbutton.setBounds(540, 240, 180, 50);

        myfollowingsbutton.setText("My followings");
        myfollowingsbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myfollowingsbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(myfollowingsbutton);
        myfollowingsbutton.setBounds(820, 230, 180, 50);

        addpost.setText("Add post");
        addpost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpostActionPerformed(evt);
            }
        });
        getContentPane().add(addpost);
        addpost.setBounds(1090, 230, 160, 50);

        mainpanel.setLayout(null);
        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(540, 320, 870, 460);

        logoutbutton.setText("Log out");
        logoutbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutbutton);
        logoutbutton.setBounds(1280, 30, 160, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editprofileActionPerformed
        // TODO add your handling code here:
        editprofile obj = new editprofile(username);
        obj.setVisible(true);
    }//GEN-LAST:event_editprofileActionPerformed

    private void changepasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepasswordActionPerformed
        // TODO add your handling code here:
         dispose();
        changepassword obj = new changepassword(username);
        obj.setVisible(true);

    }//GEN-LAST:event_changepasswordActionPerformed

    private void searchfriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchfriendActionPerformed
        // TODO add your handling code here:
        usersearch obj = new usersearch(username);
        obj.setVisible(true);
    }//GEN-LAST:event_searchfriendActionPerformed

    private void myfollowersbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myfollowersbuttonActionPerformed
        // TODO add your handling code here:
        myfollowers obj = new myfollowers(username);
        obj.setVisible(true);
    }//GEN-LAST:event_myfollowersbuttonActionPerformed

    private void myfollowingsbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myfollowingsbuttonActionPerformed
        // TODO add your handling code here:
        myfollowings obj = new myfollowings(username);
        obj.setVisible(true);

    }//GEN-LAST:event_myfollowingsbuttonActionPerformed

    private void addpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpostActionPerformed
        // TODO add your handling code here:
        addpost obj = new addpost(username);
        obj.setVisible(true);
    }//GEN-LAST:event_addpostActionPerformed

    private void logoutbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbuttonActionPerformed
        // TODO add your handling code here:
        dispose();
        login obj=new login();
        obj.setVisible(true);
           
        
    }//GEN-LAST:event_logoutbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(userhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new userhome().setVisible(true);
            }
        });
    }

    class setpost implements Runnable {

        @Override
        public void run() {
            try {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                HttpResponse<String> httpResponse = Unirest.get(globalclass.ip + "/getfollowers")
                        .queryString("username", username)
                        .asString();
                String msg = httpResponse.getBody();
                System.out.println(msg);
                StringTokenizer st = new StringTokenizer(msg, "~");
                int count = st.countTokens();
                mainpanel.setPreferredSize(new Dimension(500, (count * 220)));
                postpanel ar[] = new postpanel[count];
                int i = 0;
                int x = 10;
                int y = 10;
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    StringTokenizer st2 = new StringTokenizer(token, ";");
                    String name = st2.nextToken();
                    String caption = st2.nextToken();
                    String photo = st2.nextToken();
                    String pid = st2.nextToken();
                    String datetime = st2.nextToken();
                    ar[i] = new postpanel();
                    ar[i].setBounds(x, y, 600, 200);
                    try {
                        URL url = new URL(globalclass.ip + "/GetResource/" + photo);
                        BufferedImage image = ImageIO.read(url);
                        BufferedImage newimg = resize(image, ar[i].lbphoto.getWidth(), ar[i].lbphoto.getHeight());
                        ar[i].lbphoto.setIcon(new ImageIcon(newimg));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    ar[i].lbname.setText(name);
                    ar[i].lbcaption.setText(caption);
                    ar[i].lbdatetime.setText(datetime);

                    ar[i].lbphoto.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            showstory obj = new showstory(pid);
                            obj.setVisible(true);
                        }

                    });
                    final int b = i;
                    HttpResponse<String> httpResponse1 = Unirest.get(globalclass.ip + "/checklike")
                            .queryString("username", username)
                            .queryString("pid", pid)
                            .asString();
                    String msg1 = httpResponse1.getBody();
                    if (msg1.equals("yes")) {
             ImageIcon icon=new ImageIcon("src/backpic/heart1.png");
          Image img=icon.getImage();
          Image scaledimg=img.getScaledInstance(ar[i].lblikeicon.getWidth(), ar[i].lblikeicon.getHeight(), Image.SCALE_SMOOTH);
          ar[i].lblikeicon.setIcon(new ImageIcon(scaledimg));
                        ar[i].lbliketext.setText("liked");
                    } else {
                                
             ImageIcon icon=new ImageIcon("src/backpic/heart2.png");
          Image img=icon.getImage();
          Image scaledimg=img.getScaledInstance(ar[i].lblikeicon.getWidth(), ar[i].lblikeicon.getHeight(), Image.SCALE_SMOOTH);
          ar[i].lblikeicon.setIcon(new ImageIcon(scaledimg));
                        ar[i].lbliketext.setText("like");
                    }
                    int c = countLikes(Integer.parseInt(pid));
                    ar[i].lbcountlikes.setText(c + " likes");
                    ar[i].lblikeicon.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
//                                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                            System.out.println("hello");
                            try {
                                HttpResponse<String> httpResponse = Unirest.get(globalclass.ip + "/likepost")
                                        .queryString("username", username)
                                        .queryString("pid", pid)
                                        .asString();
                                if (httpResponse.getStatus() == 200) {
                                    String msg = httpResponse.getBody();
                                    System.out.println("msg=" + msg);

                                    if (msg.equals("inserted")) {
                                        ar[b].lbliketext.setText("liked");
                                        count();
                                    } else {
                                        ar[b].lbliketext.setText("like");
                                        count();
                                    }
                           int c = countLikes(Integer.parseInt(pid));

                                    ar[b].lbcountlikes.setText(c + " likes");
                                } else {
                                    System.out.println(httpResponse.getStatusText());
                                }
                            } catch (UnirestException ex) {
                                // Logger.getLogger(userhome.class.getName()).log(Level.SEVERE, null, ex);
                                ex.printStackTrace();
                            }

                        }

                    });

                    mainpanel.add(ar[i]);
                    mainpanel.setVisible(false);
                    mainpanel.setVisible(true);
                    i++;
                    y = y + 210;
                }

            } catch (UnirestException ex) {
                //Logger.getLogger(userhome.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addpost;
    private javax.swing.JButton changepassword;
    private javax.swing.JButton editprofile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutbutton;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JButton myfollowersbutton;
    private javax.swing.JButton myfollowingsbutton;
    private javax.swing.JButton searchfriend;
    // End of variables declaration//GEN-END:variables
BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    int countLikes(int pid) {
        int lcount = -1;
        try {
            HttpResponse<String> httpResponse2 = Unirest.get(globalclass.ip + "/count")
                    .queryString("pid", pid)
                    .asString();
            if (httpResponse2.getStatus() == 200) {
                lcount = Integer.parseInt(httpResponse2.getBody());

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return lcount;
       

    }
void count(){
    mainpanel.removeAll();
    Thread t=new Thread(new userhome.setpost());
    t.start();
}
}
