/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarsa;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static sistemarsa.EncriptaDecriptaRSA.criptografa;
import static sistemarsa.EncriptaDecriptaRSA.decriptografa;
import static sistemarsa.EncriptaDecriptaRSA.geraChave;

/**
 *
 * @author 80130917
 */
public class RSA extends javax.swing.JFrame {

    static String IV = "AAAAAAAAAAAAAAAA";
    static String textoPuro = "";
    static String chaveEncriptacao = "";
    private EncriptaDecriptaRSA encriptaDecriptaRSA = new EncriptaDecriptaRSA();
    byte[] arquivoCriptografado = null;
    public static final String ALGORITHM = "RSA";

    /**
     * Local da chave privada no sistema de arquivos.
     */
    public static final String PATH_CHAVE_PRIVADA = "C:/SENAC/keys/private.key";

    /**
     * Local da chave pública no sistema de arquivos.
     */
    public static final String PATH_CHAVE_PUBLICA = "C:/SENAC/keys/public.key";

    /**
     * Creates new form AES
     */
    public RSA() {
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

        jFileChooser1 = new javax.swing.JFileChooser();
        txtChavePublica = new javax.swing.JTextField();
        btnCriptografar = new javax.swing.JButton();
        btnDecriptografar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnChavePrivada = new javax.swing.JButton();
        btnChavePublica1 = new javax.swing.JButton();
        txtChavePrivada = new javax.swing.JTextField();
        btnGerarChave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtChavePublica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnCriptografar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCriptografar.setText("Criptografar");
        btnCriptografar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriptografarActionPerformed(evt);
            }
        });

        btnDecriptografar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDecriptografar.setText("Decriptografar");
        btnDecriptografar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecriptografarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnChavePrivada.setText("Localização da Chave Privada");
        btnChavePrivada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChavePrivadaActionPerformed(evt);
            }
        });

        btnChavePublica1.setText("Localização da Chave Pública");
        btnChavePublica1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChavePublica1ActionPerformed(evt);
            }
        });

        txtChavePrivada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnGerarChave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGerarChave.setText("Gerar Chave");
        btnGerarChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarChaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtChavePublica)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCriptografar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDecriptografar, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                    .addComponent(txtChavePrivada, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChavePrivada)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChavePublica1)
                                .addGap(146, 146, 146)
                                .addComponent(btnGerarChave)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriptografar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDecriptografar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChavePublica1)
                    .addComponent(btnGerarChave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtChavePublica, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChavePrivada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtChavePrivada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

        txtChavePrivada.setText("");
        txtChavePublica.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCriptografarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriptografarActionPerformed

        // Verifica se já existe um par de chaves, caso contrário gera-se as chaves..
        if (!encriptaDecriptaRSA.verificaSeExisteChavesNoSO()) {
            // Método responsável por gerar um par de chaves usando o algoritmo RSA e
            // armazena as chaves nos seus respectivos arquivos.

            JOptionPane.showMessageDialog(null, "Clique no botão para gerar a chave");

        } else {
            final String msgOriginal = btnCriptografar.getText();
            ObjectInputStream inputStream = null;
            //Aqui seria a parte de cifrar o texto, algo como cifraTexto(textoCifrado);
            JFileChooser arquivo = new JFileChooser();
            int retorno = arquivo.showSaveDialog(null);
            if (retorno == JFileChooser.APPROVE_OPTION) {
                String caminho = arquivo.getSelectedFile().getAbsolutePath();
                String extensao = caminho + ".criptografado";
                try {
                    try (FileWriter fw = new FileWriter(extensao)) {
                        fw.write(msgOriginal);
                        System.out.println(msgOriginal);
                    }
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo!\n" + e, "Erro!", 0);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo\n" + e, "Erro", 0);
                }
            }
            try {
                // Criptografa a Mensagem usando a Chave Pública
                inputStream = new ObjectInputStream(new FileInputStream(PATH_CHAVE_PUBLICA));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
            }
            PublicKey chavePublica = null;
            try {
                chavePublica = (PublicKey) inputStream.readObject();
            } catch (IOException ex) {
                Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
            }
            arquivoCriptografado = criptografa(msgOriginal, chavePublica);

            // Imprime o texto original, o texto criptografado e 
            // o texto descriptografado.
            System.out.println("Mensagem Original: " + msgOriginal);
            System.out.println("Mensagem Criptografada: " + arquivoCriptografado.toString());
            System.out.println("Mensagem Decriptografada: " + textoPuro);
        }

    }//GEN-LAST:event_btnCriptografarActionPerformed

    private void btnDecriptografarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecriptografarActionPerformed

        // Verifica se já existe um par de chaves, caso contrário gera-se as chaves..
        if (!encriptaDecriptaRSA.verificaSeExisteChavesNoSO()) {
            JOptionPane.showMessageDialog(null, "Clique no botão para buscar a chave");

        } else {
            final String msgOriginal = btnDecriptografar.getText();
            ObjectInputStream inputStream = null;

            JFileChooser arquivo = new JFileChooser();
            int retorno = arquivo.showSaveDialog(null);
            if (retorno == JFileChooser.APPROVE_OPTION) {
                    try {
                        // Decriptografa a Mensagem usando a Chave Pirvada
                        inputStream = new ObjectInputStream(new FileInputStream(PATH_CHAVE_PRIVADA));
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    PrivateKey chavePrivada = null;
                    try {
                        chavePrivada = (PrivateKey) inputStream.readObject();
                    } catch (IOException ex) {
                        Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    final String textoPuro = decriptografa(arquivoCriptografado, chavePrivada);
                    
                String caminho = arquivo.getSelectedFile().getAbsolutePath();
                String extensao = caminho + ".decriptografado";
                    System.out.println(msgOriginal);
                }

                // Imprime o texto original, o texto criptografado e 
                // o texto descriptografado.
                System.out.println("Mensagem Original: " + msgOriginal);
                System.out.println("Mensagem Criptografada: " + arquivoCriptografado.toString());
                System.out.println("Mensagem Decriptografada: " + textoPuro);

            
        }
    }//GEN-LAST:event_btnDecriptografarActionPerformed

    private void btnChavePrivadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChavePrivadaActionPerformed
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showOpenDialog(null);
        if (i == 1) {
            txtChavePrivada.setText("");
        } else {
            File arquivo = file.getSelectedFile();
            txtChavePrivada.setText(arquivo.getPath());
        }

    }//GEN-LAST:event_btnChavePrivadaActionPerformed

    private void btnChavePublica1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChavePublica1ActionPerformed
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showOpenDialog(null);
        if (i == 1) {
            txtChavePublica.setText("");
        } else {
            File arquivo = file.getSelectedFile();
            txtChavePublica.setText(arquivo.getPath());
        }
    }//GEN-LAST:event_btnChavePublica1ActionPerformed

    private void btnGerarChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarChaveActionPerformed

        encriptaDecriptaRSA.geraChave();
    }//GEN-LAST:event_btnGerarChaveActionPerformed

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
            java.util.logging.Logger.getLogger(RSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RSA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnChavePrivada;
    private javax.swing.JButton btnChavePublica1;
    private javax.swing.JButton btnCriptografar;
    private javax.swing.JButton btnDecriptografar;
    private javax.swing.JButton btnGerarChave;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JTextField txtChavePrivada;
    private javax.swing.JTextField txtChavePublica;
    // End of variables declaration//GEN-END:variables
}
