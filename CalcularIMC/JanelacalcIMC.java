
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;


@SuppressWarnings("serial")
public class JanelacalcIMC extends JFrame implements ActionListener {
	
double IMC;
DecimalFormat dc = new DecimalFormat("0.00");
JButton btCalc = new JButton("Calcular");
JButton btSair = new JButton("Sair");
JButton btLimpar = new JButton("Limpar");
Usuario usuario = new Usuario();
JTextField txtAltura = new JTextField(15);	
JTextField txtPeso = new JTextField(15);
JPanel resposta = new JPanel();


	public void go() {
		JFrame janela = new JFrame("Janela");
		JPanel jpJanelaAltura = new JPanel();
		jpJanelaAltura.setLayout(new FlowLayout());
		jpJanelaAltura.add(new JLabel("Altura (ex: 1.80): "));
		jpJanelaAltura.add(txtAltura);
		
		JPanel jpJanelaPeso = new JPanel();
		jpJanelaPeso.setLayout(new FlowLayout());
		jpJanelaPeso.add(new JLabel("Peso (ex: 60): "));
		jpJanelaPeso.add(txtPeso);
		
		resposta.setLayout(new FlowLayout());
		resposta.setBackground(Color.cyan);
		
		
		btCalc.addActionListener(this);
		btLimpar.addActionListener(this);
		btSair.addActionListener(this);
		
		janela.getContentPane().setBackground(Color.cyan);
		jpJanelaPeso.setBackground(Color.cyan);
		jpJanelaAltura.setBackground(Color.cyan);
		btCalc.setBackground(Color.green);
		btLimpar.setBackground(Color.yellow);
		btSair.setBackground(Color.red);
		janela.setLayout(new FlowLayout());
		janela.setSize(800, 100);
		janela.add(jpJanelaAltura);
		janela.add(jpJanelaPeso);
		janela.add(btCalc);
		janela.add(btLimpar);
		janela.add(btSair);
		janela.add(resposta);
		
		janela.setVisible(true);
	}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			resposta.setVisible(false);
			if(e.getSource() == btCalc) {
			    usuario.setAltura(Double.valueOf(txtAltura.getText()));
			    usuario.setPeso(Double.valueOf(txtPeso.getText()));
			    System.out.println(usuario.getAltura());
			    System.out.println(usuario.getPeso());
			    IMC = usuario.calcularIMC(usuario.getPeso(), usuario.getAltura());
			    String.valueOf(IMC);
			    JLabel Lresposta = new JLabel("Seu IMC:"+dc.format(IMC));
			    resposta.add(Lresposta);
				resposta.setVisible(true);
				
			}
			
			if(e.getSource() == btLimpar) {
				txtPeso.setText("");
				txtAltura.setText("");
				resposta.setVisible(false);
			}
			
			if(e.getSource() == btSair) {
		        System.exit(0);
			}
		}
		
		public static void main(String[] args) {
			JanelacalcIMC GUI = new JanelacalcIMC();
			GUI.go();
		}
}
