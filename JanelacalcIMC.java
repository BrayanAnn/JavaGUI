
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;


public class JanelacalcIMC extends JFrame {



	public static void main(String[] args) {
		JFrame janela = new JFrame("Janela");
		
		
		
		Usuario usuario = new Usuario();
		JPanel jpJanelaAltura = new JPanel();
		jpJanelaAltura.setLayout(new FlowLayout());
		jpJanelaAltura.add(new JLabel("Altura (ex: 1.80): "));
		JTextField txtAltura = new JTextField(15);
		jpJanelaAltura.add(txtAltura);
		
		JPanel jpJanelaPeso = new JPanel();
		jpJanelaPeso.setLayout(new FlowLayout());
		jpJanelaPeso.add(new JLabel("Peso (ex: 60): "));
		JTextField txtPeso = new JTextField(15);
		jpJanelaPeso.add(txtPeso);
		
		JPanel resposta = new JPanel();
		resposta.setLayout(new FlowLayout());
		
		JButton btCalc = new JButton("Calcular");
		btCalc.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btCalc) {
				    usuario.setAltura(Double.valueOf(txtAltura.getText()));
				    usuario.setPeso(Double.valueOf(txtPeso.getText()));
				    System.out.println(usuario.getAltura());
				    System.out.println(usuario.getPeso());
				    double IMC = usuario.calcularIMC(usuario.getPeso(), usuario.getAltura());
				    DecimalFormat dc = new DecimalFormat("0.00");
				    String.valueOf(IMC);
				    resposta.add(new JLabel("SEU IMC: " + dc.format(IMC) ));
					resposta.setVisible(true);
					
						
				}
			}
		});
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btLimpar) {
					txtPeso.setText("");
					txtAltura.setText("");
				}
			}
			
		});
	
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btSair) {
			        System.exit(0);
				}
			}
			
		});
		
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
		resposta.setVisible(false);
		janela.setVisible(true);
		

	}

}
