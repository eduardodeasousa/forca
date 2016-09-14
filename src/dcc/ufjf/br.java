package dcc.ufjf;

import java.awt.FlowLayout;
import javax.swing.JFrame;

public class br {

    public static void main(String[] args) {
        System.out.println("Iniciando a alicação");
        JanelaEntradaDeDados j = new JanelaEntradaDeDados(); 
        j.setVisible(true);
        j.setTitle("Eduardo Sousa");
        j.setSize(500,200);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(new FlowLayout(FlowLayout.CENTER));
        System.out.println("Janela exibida");

    }
    
}
