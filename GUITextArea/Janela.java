import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class Janela implements ActionListener {
	//Exibe T�tulo data e hora
	JFrame janela = new JFrame("Atividade T13 "+ getData()+ " "+ getHora() );
	JPanel jpTextArea = new JPanel();
	JPanel jpTitulo = new JPanel();
	JPanel jpButton = new JPanel();
	JPanel jpResposta = new JPanel();
	JTextField txtTitulo = new JTextField(15);
	JTextArea textArea = new JTextArea(15, 30);
	JButton btAdd = new JButton("Adicionar");
	
	
	
	public void configJanela() {
		btAdd.setSize(2,4);
		janela.setLayout(new FlowLayout());
		janela.add(jpTitulo);
		janela.add(jpTextArea);
		janela.add(jpButton);
		janela.add(jpResposta);
		janela.setSize(450, 700);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
	
	public void configPanels() {
		
		jpTitulo.add(new JLabel("T�tulo: "));
		jpTitulo.add(txtTitulo);
		jpTextArea.add(textArea);
		jpButton.add(btAdd);
		jpResposta.setVisible(false);
		jpResposta.setPreferredSize(new Dimension(400,400));
		btAdd.addActionListener(this);
	}
	public String getData() {
		//Obt�m e formata data
		LocalDateTime dataAtual = LocalDateTime.now();
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String dataFormatada = formatterData.format(dataAtual);
		return dataFormatada;
	}
	
	public String getHora(){
		//Obt�m e formata hora
		LocalDateTime horaAtual = LocalDateTime.now();
		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		String horaFormatada = formatterHora.format(horaAtual);
		return horaFormatada;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btAdd) {
			JLabel resposta = new JLabel("T�tulo: "+ txtTitulo.getText());
			jpResposta.add(resposta);
			resposta = new JLabel("Data: "+ getData());
			jpResposta.add(resposta);
			resposta = new JLabel("Hora: "+ getHora());
			jpResposta.add(resposta);
			resposta = new JLabel("Conte�do: "+ textArea.getText());
			jpResposta.add(resposta);
			jpResposta.setVisible(true);
			System.out.printf("T�tulo: "+ txtTitulo.getText()+ "\nData: "+getData() + "\nHora: "+ getHora()+ "\nConte�do: "+ textArea.getText());
		}
	}
	public static void main(String[] args) {
		Janela janela = new Janela();
		janela.configPanels();
		janela.configJanela();
		
	}
}
