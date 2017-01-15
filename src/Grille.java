import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Grille d'un monde gerant l'ensemble des positions libres
 * ou occupees par des choses.
 * 
 * TODO : a  completer.
 */
public class Grille extends JPanel {
	// Dimensions de la grille : 0..N lignes et 0..M colonnes
	private int N;
	private int M;

	// Dimensions de la fenetre d'affichage en pixels
	private int largeur;
	private int hauteur;

	/**
	 * Constructeur
	 * @param N N+1 lignes indicees de 0 a  N
	 * @param M M+1 colonnes indicees de 0 a  M
	 * 
	 * TODO : a  completer
	 */
	public Grille(int N, int M) {
		// dimensions pour les positions
		this.N = N;
		this.M = M;

		// dimensions de la fenÃªtre
		largeur = Constante.Pix*(M+2);
		hauteur = Constante.Pix*(N+2);
		setPreferredSize(new Dimension(largeur,hauteur));
	}

	/**
	 * @return Hauteur de la fenetre graphique en pixels
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * @return Largeur de la fenetre graphique en pixels
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * Methode publique de dessin de la grille dans la fenetre graphique
	 */
	public void dessiner() {
		repaint();  // appel de paintComponent redÃ©finie ci-aprÃ¨s
	}

	/**
	 * Dessin effectif de la grille
	 * @param g Composant graphique de dessin
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		// fond
		Color couleur = new Color(80,80,80);
		g2d.setColor(couleur);
		g2d.fillRect(0,0,largeur,hauteur);

		// superposition des couleurs
		g2d.setXORMode(couleur);
		
		//population
		Monde world = Constante.world;
		Point coordonnees[]= Constante.coordonnees;
		Chose population[]=Constante.population;
		
		// la grille et les choses
		for (int x=0; x<=M; ++x) {
			int px = (x+1)*Constante.Pix;
			for (int y=0; y<=N; ++y) {
				int py = (y+1)*Constante.Pix;
				// Affichage pour la position (x,y) sur le pixel (px,py)
				
				// TODO : afficher les formes des choses la ou elles se trouvent
				
				Chose c = null;
				for (Chose ch : population) {
					if(ch!=null)
					if (ch.getCoordonnee().equals(new Point(y,x))) {
						c = ch;
					}
				}
		/* méthode 1 */
				if(c instanceof Cameleon){ //cameleons		
					if(c.getAge()>=20){
						Random rand = new Random();
						g2d.setColor(new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat()));
					}
					else g2d.setColor(Color.GREEN);
					g2d.fillRect(px-6,py-4,Constante.largeur,Constante.longeur); //-6 et -4 pour centrer sur le point; 

				}
				else if(c instanceof Mouche){ //mouches
					g2d.setColor(Color.BLUE); 
					g2d.fillOval(px-3,py-3,Constante.rayon*2,Constante.rayon*2); //-3 pour centrer sur le point; 
					
				}
				else { // Ici un petit cercle de couleur blanche est affiché pour montrer que la position est libre
					g2d.setColor(Color.WHITE); 
					g2d.fillOval(px,py,3,3);
				}
				
				
		/* méthode 2 (avec images)
				if(c instanceof Cameleon){ //cameleons		
					Image img1 = Toolkit.getDefaultToolkit().getImage("./doc/chameleon.png");
					if(c.getAge()>=20){
						Random rand = new Random();
						img1 = Toolkit.getDefaultToolkit().getImage("./doc/chameleon("+(rand.nextInt(10)+1)+").png");
					}
					g2d.drawImage(img1, px-3, py-3, this);
				}
				else if(c instanceof Mouche){ 
					Image img1 = Toolkit.getDefaultToolkit().getImage("./doc/mouche.png");//méthode 2
				    g2d.drawImage(img1, px-3,  py-3, this);
				}
				else { // Ici un petit cercle de couleur blanche est affiché pour montrer que la position est libre
					g2d.setColor(Color.WHITE); 
					g2d.fillOval(px,py,3,3);
				}
				
		*/
				
			}
		}
		
	}

}
