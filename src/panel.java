
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class panel extends javax.swing.JPanel {

    /**
     * Creates new form panel1
     */
    public panel() {
        initComponents();
          lbback1.setSize(810,209);
         ImageIcon icon=new ImageIcon("src/backpic/img10.jpg");
          Image img=icon.getImage();
          Image scaledimg=img.getScaledInstance(lbback1.getWidth(), lbback1.getHeight(), Image.SCALE_SMOOTH);
          lbback1.setIcon(new ImageIcon(scaledimg));
        // setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbphoto = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();
        lbphoneno = new javax.swing.JLabel();
        lbemail = new javax.swing.JLabel();
        followbutton = new javax.swing.JButton();
        lbback1 = new javax.swing.JLabel();

        setLayout(null);

        lbphoto.setText("jLabel1");
        lbphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lbphoto);
        lbphoto.setBounds(0, 10, 220, 190);

        lbname.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lbname.setText("jLabel2");
        add(lbname);
        lbname.setBounds(230, 30, 200, 23);

        lbphoneno.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lbphoneno.setText("jLabel3");
        add(lbphoneno);
        lbphoneno.setBounds(230, 80, 200, 23);

        lbemail.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lbemail.setText("jLabel4");
        add(lbemail);
        lbemail.setBounds(230, 130, 170, 30);

        followbutton.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        followbutton.setText("follow");
        followbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followbuttonActionPerformed(evt);
            }
        });
        add(followbutton);
        followbutton.setBounds(440, 70, 140, 50);
        add(lbback1);
        lbback1.setBounds(0, 0, 810, 210);
    }// </editor-fold>//GEN-END:initComponents

    private void followbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_followbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton followbutton;
    private javax.swing.JLabel lbback1;
    public javax.swing.JLabel lbemail;
    public javax.swing.JLabel lbname;
    public javax.swing.JLabel lbphoneno;
    public javax.swing.JLabel lbphoto;
    // End of variables declaration//GEN-END:variables
}
