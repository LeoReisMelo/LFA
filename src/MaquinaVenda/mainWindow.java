package MaquinaVenda;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class mainWindow extends JFrame implements ActionListener,FocusListener{
	private JLabel imgMaquina;
	private JLabel gasto = new JLabel();
	private JButton buttonClose;
	private JButton buttonInsert;
	private JTextField textValue=new JTextField();
	int soma=0;
	

public void InicializaComponentes(){
		
		//Janela
		this.setTitle("M�quina de vendas");
		this.setLayout(null);
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		this.setUndecorated(true);
		
		gasto.setText("Valor pago");
		gasto.setBounds(140,280,200,100);
		gasto.setFont(new Font ("Monotype Corsiva", Font.BOLD,25));
		gasto.setForeground(Color.white);
		this.add(gasto);
		
		buttonClose=new JButton(new ImageIcon("img/buttonClose.png"));
		buttonClose.setBounds(350,0,50,50);
		buttonClose.addActionListener(this);
		this.add(buttonClose);
		
		buttonInsert=new JButton(new ImageIcon("img/coin.jpg"));
		buttonInsert.setBounds(100,220,200,80);
		buttonInsert.addActionListener(this);
		this.add(buttonInsert);
		
		textValue.setBounds(80,140,250,35);
		textValue.setText("Insira uma moeda(Entre 10$ e 25$ cents):");
		textValue.addFocusListener(this);
		this.add(textValue);
		
		imgMaquina=new JLabel(new ImageIcon("img\\background.jpg"));
		imgMaquina.setBounds(0,0,400,400);
		this.add(imgMaquina);
		
		
		
		this.show();
		
	
		
		
}

public mainWindow() {
	InicializaComponentes();
}
	public void focusGained(FocusEvent e) {
		if(e.getSource()==textValue) {
			textValue.setText("");
		}
		
	}

	
	public void focusLost(FocusEvent e) {
		
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonClose){
			this.dispose();
		}
		if(e.getSource()== buttonInsert) {
			String texto = textValue.getText();
			if(texto.equals("") || texto.equals("Insira uma moeda(Entre 10$ e 25$ cents):")) {
				JOptionPane.showMessageDialog(null, "Por favor, insira uma moeda!");
			}
			int moeda;
			int valor;
			
			moeda = Integer.parseInt(textValue.getText());
			valor=moeda;
			
			if(valor!=10 && valor!=25) {
				JOptionPane.showMessageDialog(null, "Moedas inseridas n�o aceitas, n�o temos devolu��o!!!");
			}
			else {
				do{
					moeda = Integer.parseInt(textValue.getText());
					valor=moeda;
					soma+=valor;
					gasto.setText("R$: 0," +soma);
					if(soma==45) {
						JOptionPane.showMessageDialog(null, "Coca-Cola comprada com sucesso!, valor da compra $: 0,45");
						soma=0;
					}
					if(soma>45) {
						JOptionPane.showMessageDialog(null, "Coca-Cola comprada com sucesso!, valor da compra $: 0,"+soma+ ", valor perdido $: 0,"+(soma-45));
						soma=0;
					}
					break;
				}while(valor!=0);
				
			}
			
			
			
			
			
			}
		}
	
	}



