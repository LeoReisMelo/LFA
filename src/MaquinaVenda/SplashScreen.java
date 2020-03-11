package MaquinaVenda;

import java.awt.Color;
//Importando bibliotecas utilizadas
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

//Acrescentando a biblioteca JFrame a classe principal com extends
public class SplashScreen extends JFrame {
	//criando as variaveis utilizadas
	private BufferedImage content;
	private JProgressBar bar;
	private ImageIcon gif;
	private BufferedImage fundo;

//Criando o metodo construtor da classe
public SplashScreen(){
	InicializarComponentes();
}



//Criando um metodo para a inicialização dos componentes contindos na classe
public void InicializarComponentes() {
	//Definindo o layout da tela
	this.setUndecorated(true);
	this.setTitle(null);
	this.setLayout(null);
	this.setSize(400, 400);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	this.setVisible(false);
	this.setBackground(Color.white);;

	//Inserindo uma imagem .Gif na variavel
	gif = new ImageIcon("img\\coca.gif");
	final JLabel splash = new JLabel(gif);

	this.add(splash);
	this.show();
	//Rodando a tela de Splash
	new Thread() {
		public void run() {

			try {
				//Layout da tela de Splash
				splash.setSize(400, 400);
				splash.setBorder(null);
				splash.setBackground(Color.white);
				splash.setLocale(getLocale());
				splash.setVisible(true);
				bar = new JProgressBar();

				
				
			} catch (Exception ex) {
				ex.getMessage();
			}
			//Definindo o tempo(timeout) da tela de Splash
			for (int i = 0; i < 40; i++) {

				try {
					sleep(40);
					bar.setValue(i);

				} catch (Exception ie) {

				}
			}
			//Finalizando a tela de splash após o timeout e apresentando a tela de login
			try {
					dispose();
					mainWindow mw= new mainWindow();
					mw.show();

				}
			//Pegando algum erro oriundo da tela de Splash
				catch (java.lang.NoSuchMethodError ex) {

				}

			
			}
		//Iniciando a tela de Splash
		}.start();

	}
}