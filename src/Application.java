/**
 * Classe applicative montrant un EXEMPLE de creation d'une grille
 * et de son affichage dans une fenetre graphique.
 */
public class Application {

	/**
	 * Point d'entree du programme executable
	 * @param args Parametre non utilisee
	 */
	public static void main(String[] args) {

		// Creation de la grille
		Grille grille = new Grille(Constante.N,Constante.M);
		
		// Creation et affichage de la fenetre graphique
		Fenetre fenetre = new Fenetre("Un monde de choses, Le commencement",grille);
		
		// Entre deux evolutions d'un monde, il est necessaire de faire une pause
		// pour l'affichage au moyen du code suivant.
		try {
			System.out.println("--------------------------le commencement, population: "+Constante.cameleon_pop+" caméléons, "+Constante.mouche_pop+" mouches -------------------");
			while(Constante.world.getAnnee_t() < Constante.Apocalypse){
				Thread.sleep(Constante.pauseTempsMs);
				Constante.world.nouvelAn();
				System.out.println("-------------------------Nouvel AN ("+Constante.world.getAnnee_t()+") "+Constante.cameleon_pop+" caméléons, "+Constante.mouche_pop+" mouches --------------------------------------------");
				fenetre.setTitle("Un monde de choses, Année "+Constante.world.getAnnee_t()+" Population: "+Constante.total_pop+" ("+Constante.cameleon_pop+" caméléons, "+Constante.mouche_pop+" mouches)");
				fenetre.repaint();	
			}
			System.out.println("-----------------------------------Apocalypse, fin du monde--------------------------------------");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}

}
