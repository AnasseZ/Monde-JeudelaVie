import java.awt.Color;

/**
 * Classe de definition de toutes les constantes apparaissant
 * dans le projet.
 * 
 * TODO : A  completer.
 */
public class Constante {
	
	/**
	 *  Dimensions de la grille
	 *     - N+1 lignes numerotees de 0 a  N
	 *     - M+1 colonnes numerotees de 0 a  M
	 */
	public static final int N = 10; //max de x
	public static final int M = 20; // max de y

	/**
	 * Un point (x,y) est affichee sur le pixel ((x+1)*Pix, (y+1)*Pix)
	 */
	public static final int Pix = 30;

	/**
	 * Delai en millisecondes entre deux affichages du monde
	 */
	public static final int pauseTempsMs = 500;
	
	// Constantes pour les mouches
	public static int mouche_pop=100;
	public static final int rayon=5;
	Color bleu= new Color(0, 0, 225);
	
	// Constantes pour les cameleons
	public static int cameleon_pop=8;
	public static final int largeur=16;
	public static final int longeur=10;
	Color vert= new Color(0, 128, 0);
	
	// Constantes pour le monde
	public static final int Apocalypse=80; //destruction du monde
	public static int total_pop=cameleon_pop+mouche_pop;
	public static Monde world = new Monde(0);
	public static Point coordonnees[]= world.creation();
	public static Chose population[]=world.peupler(coordonnees) ; 
	public static final int epidemie = 30; // en %
	

}
