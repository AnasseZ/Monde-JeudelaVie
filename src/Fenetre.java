import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe dont les instances sont des fenetres graphiques
 * derivees de JFrame.
 */
public class Fenetre extends JFrame {
	
	/**
	 * Construteur.
	 * @param titre Titre de la fenetre affiche dans le bandeau
	 * @param panel Contenu de la fenetre
	 */
	public Fenetre(String titre, JPanel panel) {
		// instanciation de l'instance de JFrame et de son contenu
		super(titre);
		getContentPane().add(panel);

		// parametrage de la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setLocationRelativeTo(null);

		// affichage
		pack();
		setVisible(true);
	}

}
