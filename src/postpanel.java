/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class postpanel extends javax.swing.JPanel {

    /**
     * Creates new form postpanel
     */
    public postpanel() {
        initComponents();
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
        lbcaption = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();
        lbdatetime = new javax.swing.JLabel();
        lblikeicon = new javax.swing.JLabel();
        lbliketext = new javax.swing.JLabel();
        lbcountlikes = new javax.swing.JLabel();

        setLayout(null);

        lbphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lbphoto);
        lbphoto.setBounds(20, 30, 190, 120);

        lbcaption.setText("jLabel1");
        add(lbcaption);
        lbcaption.setBounds(280, 40, 140, 30);

        lbname.setText("jLabel2");
        add(lbname);
        lbname.setBounds(280, 110, 140, 30);

        lbdatetime.setText("jLabel3");
        add(lbdatetime);
        lbdatetime.setBounds(280, 150, 150, 40);
        add(lblikeicon);
        lblikeicon.setBounds(10, 158, 30, 40);
        add(lbliketext);
        lbliketext.setBounds(60, 170, 90, 20);
        add(lbcountlikes);
        lbcountlikes.setBounds(160, 170, 60, 20);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lbcaption;
    public javax.swing.JLabel lbcountlikes;
    public javax.swing.JLabel lbdatetime;
    public javax.swing.JLabel lblikeicon;
    public javax.swing.JLabel lbliketext;
    public javax.swing.JLabel lbname;
    public javax.swing.JLabel lbphoto;
    // End of variables declaration//GEN-END:variables
}
