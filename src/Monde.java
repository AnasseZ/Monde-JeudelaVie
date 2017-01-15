import java.util.Random;

public class Monde {
	private int annee_t;
	
	public Monde(int annee_t) {
		this.annee_t = annee_t;
	}
	
	public int getAnnee_t() {
		return annee_t;
	}

	public void nouvelAn() {
		this.annee_t++;
		
		for(Chose c : Constante.population){
				c.veillit();
				c.seDeplacer();
				System.out.println(c.toString());
		}
		for(Chose c : Constante.population){
			if(c instanceof Cameleon){ //les caméléons manger apres les autres actions
				((Cameleon) c).mange(); //seul le cameleon mange, la methode est donc presente uniquement dans cameleon, d ou le cast
			}
		}
		
		boolean t=mortalite(); 
		if (!t) while (!t){// on appel la fonction mortalité tant que il y a détection de chose(s) trop agée(s)
			t=mortalite();
		}
		
		if(this.annee_t % 15==0){//epidémie !
			System.out.println("une epidemie touche "+Constante.epidemie+"% de la population");
			Random rn = new Random();
			int malades = (int) Math.ceil(Constante.epidemie*Constante.total_pop/100); // nombre de morts de l'épidémie
			for(int i=0; i<malades; i++){
				Constante.population[rn.nextInt(Constante.total_pop)].Mourir();
			}
			System.out.println(malades+" malades meurent de l epidemie");
		}

		if(this.annee_t % 8==0){ //saison des amours
			for(Chose ch : Constante.population){// accouplement 
				ch.Accouple(); 
			}
			for(Chose ch : Constante.population){// retour de la fecondité 
				ch.setParent(false);
			}
		}
		
		if(this.annee_t==Constante.Apocalypse){//fin du monde
			for(Chose ch: Constante.population){
				ch.Mourir();
			}
		}
	}
	
	public boolean mortalite(){ // assure la fin de vie des choses trop vieilles
		boolean t = true;
		for(Chose c : Constante.population){
			if(c instanceof Cameleon){ 
				if (c.getAge()>=150){
					System.out.println("un Cameleon est mort de vieillesse");
					c.Mourir();
					t=false;
				}
			}
			if (c instanceof Mouche){
				if (c.getAge()>=99){
					System.out.println("une mouche est morte de vieillesse");
					c.Mourir();
					t=false;
				}
			}
		}
		return t;
	}


	public Point[] creation(){
		Point coordonnees[]=new Point[Constante.cameleon_pop+Constante.mouche_pop] ; //Tab de coordonées générés aléatoirement
		for(int n=0; n<Constante.total_pop; n++){
			coordonnees[n]=new Point((int) (Math.random() * ( Constante.N - 0 )),(int) (Math.random() * ( Constante.M - 0 )));
		}
		
		boolean t=false;
		while(t==false){ //on boucles tant qu'il y a des doublons
			t = true;
			for(int i=0; i<Constante.total_pop;i++){
				Point p=coordonnees[i];
				for(int j=0; j<Constante.total_pop;j++){
					if(p.equals(coordonnees[j]) && i!=j){
						coordonnees[i]=new Point((int) (Math.random() * ( Constante.N - 0 )),(int) (Math.random() * ( Constante.M - 0 ))); //on redéfini le point
						t=false;
					}
				}
			}
		}
		return coordonnees;
	}
	
	public Chose[] peupler(Point[] coordonnees){
		Chose population[]=new Chose[Constante.total_pop]; 
		for(int i=0; i<Constante.cameleon_pop; i++){
			population[i] = new Cameleon(coordonnees[i]); 
		}
		for(int j=Constante.cameleon_pop; j<Constante.total_pop; j++){
		population[j] = new Mouche(coordonnees[j]);
		}
	 return population;
	}

	
}
