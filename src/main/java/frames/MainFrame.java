/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import classes.Aluno;
import classes.Funcionário;
import classes.Livro;
import classes.Professor;
import frames.Login;
import frames.Empréstimo;
import frames.Devolucao;
import frames.CadUser;
import frames.CadLivro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author User
 */
public class MainFrame extends javax.swing.JFrame {
    private ArrayList<String> frases; 
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> professores;
    private ArrayList<Livro> livros;
    
    private Aluno a = new Aluno();
    private Professor p = new Professor();
    private Livro l = new Livro();
            
    /**
     * Creates new form MainFrame
     */
    public MainFrame(Funcionário f) {
        initComponents();
        Random r = new Random();
        
        this.frases = new ArrayList<String>();
        this.frases.add("Vós, que sofreis, porque amais, amai ainda mais. Morrer de amor é viver dele.\nVictor Hugo");
        this.frases.add("Necessitamos sempre de ambicionar alguma coisa que, alcançada, não nos torna sem ambição.\nCarlos Drummond de Andrade");
        this.frases.add("Liberdade é pouco. O que eu desejo ainda não tem nome.\nClarice Lispector");
        this.frases.add("Sou um homem de letras, nada mais. Não estou certo de ter pensado nada de original em minha vida. Sou um fazedor de sonhos.\nJorge Luis Borges");
        this.tfFrase.setText(String.valueOf(this.frases.get(r.nextInt(frases.size()))));
        
        Aluno aluno = new Aluno(5353, "Ciência da Computação", "Pedro Barbosa", "98305555", "Masculino", 21);
        Aluno aluno2 = new Aluno(5567, "Processos Químicos", "Joana Lima", "11515151", "Feminino", 18);
        Aluno aluno3 = new Aluno(3333, "Ciência da Computação", "Ricardo Milos", "22262222", "Masculino", 22);
        
        Professor p1 = new Professor(500, "Chapatin Fernandes", "75262222", "Masculino", 32);
        Professor p2 = new Professor(777, "Ruben Girafales", "99996222", "Masculino", 42);
        
        Livro l1 = new Livro(5252, "Programação Orientada a Objetos", "Paulo Alem", "Acadêmico", false);
        Livro l2 = new Livro(333, "1984", "George Orwell", "Ficcção Científica", true);
        Livro l3 = new Livro(878, "Estrutura de Dados", "Antônio Nunes", "Acadêmico", false);
        
        a.cadastrarAluno(aluno);
        a.cadastrarAluno(aluno2);
        a.cadastrarAluno(aluno3);
        
        p.cadastrarProfessor(p1);
        p.cadastrarProfessor(p2);
        
        l.cadastrarLivro(l1);
        l.cadastrarLivro(l2);
        l.cadastrarLivro(l3);
        
        alunos = a.getAlunos();
        professores = p.getProfessores();
        livros = l.getLivros();
        
        System.out.println(alunos.size());
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
        tfFrase = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btDevolucao = new javax.swing.JButton();
        btCadUser = new javax.swing.JButton();
        btCadLivro = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btEmprestimo1 = new javax.swing.JButton();
        btnRelUser = new javax.swing.JButton();
        btnRelEmp = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jbUser = new javax.swing.JLabel();
        jbSugestao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfFrase.setText("\"Frase\"");
        tfFrase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFraseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfFrase)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfFrase)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Opções");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btDevolucao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btDevolucao.setText("Devolução");
        btDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDevolucaoActionPerformed(evt);
            }
        });

        btCadUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btCadUser.setText("Cadastrar Usuário");
        btCadUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadUserActionPerformed(evt);
            }
        });

        btCadLivro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btCadLivro.setText("Cadastrar Livro");
        btCadLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadLivroActionPerformed(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btSair.setForeground(new java.awt.Color(255, 51, 51));
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btEmprestimo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btEmprestimo1.setText("Empréstimo");
        btEmprestimo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmprestimo1ActionPerformed(evt);
            }
        });

        btnRelUser.setText("Relatório de usuários");
        btnRelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelUserActionPerformed(evt);
            }
        });

        btnRelEmp.setText("Relatório de empréstimos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnRelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSair, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRelEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btEmprestimo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(btCadUser)
                        .addGap(26, 26, 26)
                        .addComponent(btCadLivro)
                        .addGap(19, 19, 19))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEmprestimo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRelUser)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btCadUser)
                        .addComponent(btCadLivro)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btDevolucao)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRelEmp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSair)
                        .addContainerGap())))
        );

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel3.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 204));
        jLabel3.setText("Biblioteca Graciliano Ramos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(49, 49, 49))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jbUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbSugestao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jbSugestao, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jbSugestao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfFraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFraseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFraseActionPerformed

    private void btDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDevolucaoActionPerformed
        Devolucao d = new Devolucao();
        d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        d.setVisible(true);
    }//GEN-LAST:event_btDevolucaoActionPerformed

    private void btCadUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadUserActionPerformed
        //Abre janela de cadastro de usuário
        CadUser cd = new CadUser();
        cd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cd.setVisible(true);
    }//GEN-LAST:event_btCadUserActionPerformed

    private void btCadLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadLivroActionPerformed
        //Abre janela de cadastro de livro
        CadLivro cl = new CadLivro();
        cl.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cl.setVisible(true);
    }//GEN-LAST:event_btCadLivroActionPerformed

    private void btEmprestimo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmprestimo1ActionPerformed
        //Abre janela de empréstimo
        Empréstimo e = new Empréstimo();
        e.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        e.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btEmprestimo1ActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        //Sai da janela principal e volta para o Login
        this.dispose();
        Login l = new Login();
        l.setVisible(true);
    }//GEN-LAST:event_btSairActionPerformed

    private void btnRelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRelUserActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadLivro;
    private javax.swing.JButton btCadUser;
    private javax.swing.JButton btDevolucao;
    private javax.swing.JButton btEmprestimo1;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btnRelEmp;
    private javax.swing.JButton btnRelUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jbSugestao;
    private javax.swing.JLabel jbUser;
    private javax.swing.JTextField tfFrase;
    // End of variables declaration//GEN-END:variables
}
