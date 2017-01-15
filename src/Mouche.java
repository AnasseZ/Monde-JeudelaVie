
public class Mouche extends Chose{
	private String couleur="bleu";
	
	public Mouche(Point coordonnee) {
		super(coordonnee);
		this.age=0;
	}
		
	public void veillit() {
		this.age = this.age+5; 
	}
	
	public void Mourir(){ //supprime la mouche du tableau
		super.Mourir();	
		if(Constante.mouche_pop>0)Constante.mouche_pop--;		
	}
	
	public void Accouple(){ 
		for(Chose ch : this.Entourer()){
			if (ch instanceof Mouche) { //pour chaque chose de entourer, si mouche alors...
				if(this.getAge()>=20 && ch.getAge()>=20){ //verifie la maturité
					for(int i=0;i<this.Entourer().length;i++)//on reparcours "entourer[]" pour trouver une case vide
					{ 
						if(this.Entourer()[i]==null && !this.isParent()) 
						{
							System.out.println("Naissance d un bebe mouche !");
							this.setParent(true);
							ch.setParent(true);//car une mouche ne s'accouple qu'une fois
							int n=Constante.total_pop; // case ou le bébé sera placé
							Constante.total_pop++;
							Chose population2[]=new Chose[Constante.total_pop]; 
							for(int j=0; j<(Constante.total_pop-1);j++){ // agrandissement du tableau population
								population2[j]=Constante.population[j];
							}
							Constante.population=population2;
							Constante.mouche_pop++;	
							
							switch (i){ // en fonction du y trouvé, on en deduit la case ou va naitre le bébé
							  case 0: Constante.population[n] = new Mouche(new Point(this.getCoordonnee().getY(),this.getCoordonnee().getX()+1));
							    break;
							  case 1: Constante.population[n] = new Mouche(new Point(this.getCoordonnee().getY(),this.getCoordonnee().getX()-1));
							    break;
							  case 2: Constante.population[n] = new Mouche(new Point(this.getCoordonnee().getY()+1,this.getCoordonnee().getX()));
							    break; 
							  case 3: Constante.population[n] = new Mouche(new Point(this.getCoordonnee().getY()-1,this.getCoordonnee().getX()));
								break;
							}
						}
					}
				}
			}	
		}
	}
	
	public String toString(){
		return "La mouche au point "+getCoordonnee().toString()+" agée de "+getAge()+" ans";
	}
}
