package dcc.ufjf;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class JanelaEntradaDeDados extends JFrame {

   
   private JLabel lbl_saida = new JLabel("Saida");
   private JLabel lbl_Entrada = new JLabel("***************");
   private JTextField  txt_Entrada2 = new JTextField(5);
   private JPasswordField txt_Entrada = new JPasswordField("TESTE", ALLBITS);
   private String forca = "TESTE";
   static ArrayList< Integer > charPos = new ArrayList< Integer >();
   int tentativas = 5 ;
    public JanelaEntradaDeDados() throws HeadlessException {
        super("Entrada de Dados");
    
        setLayout(new FlowLayout(SwingConstants.LEFT));
        add(lbl_saida);
        add(txt_Entrada);
        add(txt_Entrada2);
        add(lbl_Entrada);
        txt_Entrada2.addActionListener(new ConverteParaMaiuscula());
        txt_Entrada.addActionListener(new DefineForca());
        
    }
    
   private class DefineForca implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            forca=e.getActionCommand();
            String interrogacoes = new String(new char[forca.length()]).replace("\0","?");
            lbl_Entrada.setText(interrogacoes);
        }
       
   }
   private class ConverteParaMaiuscula implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //VERIFICA AS POSICOES EM QUE CONTEM O CHAR
    int i;
    if(tentativas==0)
    {lbl_Entrada.setText("PERDEU NOOB!");}
    if (forca.contains(e.getActionCommand()))
    {
       for (i=0;i<forca.length();i++)
        {
           if ( forca.charAt(i) == e.getActionCommand().charAt(0)) 
           {
               charPos.add(i);
           }    
        }
        StringBuilder result = new StringBuilder(lbl_Entrada.getText());
        Iterator<Integer> iterator = charPos.iterator();
        while(iterator.hasNext())
        {
           Integer posicao = iterator.next();
           result.setCharAt(posicao, e.getActionCommand().charAt(0));
           iterator.remove();    
        }
        lbl_Entrada.setText(result.toString());
    }
    else 
    {tentativas-=1;}
    }
   }
    
}
