
public class Cameleon extends Chose {
	private String couleur="vert";
	
	public Cameleon(Point coordonnee) {
		super(coordonnee);
		this.age=0;
	}
 
	public void veillit() {
		this.age = this.age+2;
	}
	
	public void mange(){
		for(Chose ch : this.Entourer()){
			if (ch instanceof Mouche) {
				System.out.println(ch+" a ete Mangée par "+this);
				ch.Mourir();
				break;
			}
		}
	}
	
	public void Mourir(){ //supprime le cameleon du tableau
		super.Mourir();	
		if(Constante.cameleon_pop>0)Constante.cameleon_pop--;
	}
	
	public void Accouple(){ // méthode commentée dans Mouche 
		for(Chose ch : this.Entourer()){
			if (ch instanceof Cameleon) {
				if(this.getAge()>=80 && ch.getAge()>=80){
					for(int i=0;i<this.Entourer().length;i++){
						if(this.Entourer()[i]==null && !this.isParent()){
							System.out.println("Naissance d un bebe cameleon !");
							this.setParent(true);
							ch.setParent(true);//car une mouche ne s'accouple qu'une fois
							int n=Constante.total_pop;
							Constante.total_pop++;
							Chose population2[]=new Chose[Constante.total_pop]; 
							for(int j=0; j<(Constante.total_pop-1);j++){
								population2[j]=Constante.population[j];
							}
							Constante.population=population2;
							Constante.cameleon_pop++;	
							switch (i){
							  case 0: Constante.population[n] = new Cameleon(new Point(this.getCoordonnee().getY(),this.getCoordonnee().getX()+1));
							    break;
							  case 1: Constante.population[n] = new Cameleon(new Point(this.getCoordonnee().getY(),this.getCoordonnee().getX()-1));
							    break;
							  case 2: Constante.population[n] = new Cameleon(new Point(this.getCoordonnee().getY()+1,this.getCoordonnee().getX()));
							    break; 
							  case 3: Constante.population[n] = new Cameleon(new Point(this.getCoordonnee().getY()-1,this.getCoordonnee().getX()));
								break;
							}
						}		
					}
				}
			}	
		}
	}
	
	
	public String toString(){
		return "Le cameleon au point "+getCoordonnee().toString()+" agé de "+getAge()+" ans";
	}
}