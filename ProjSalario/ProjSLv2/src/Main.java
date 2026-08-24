/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author renat
 */
public class Main {
     public static void main(String[] args) {
        javax.swing.JFrame janela = new javax.swing.JFrame();

        janela.add(new SLForm());

        janela.setDefaultCloseOperation(
            javax.swing.JFrame.EXIT_ON_CLOSE
        );

        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
}
