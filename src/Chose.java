import java.util.Random;

public class Chose {
	
	private Point coordonnee;
	protected int age;
	protected boolean parent=false;

	public Chose(Point coordonnee){
		this.coordonnee=coordonnee;
		this.age=0;
	}
	
	public Point getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Point coordonnee) {
		this.coordonnee = coordonnee;
	}

	public int getAge() {
		return age;
	}	
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isParent(){
		return this.parent;
	}
	
	public void setParent(boolean t){
		this.parent=t;
	}
	
	
	public void veillit(){}; // méthode définit dans les sous classes 
	
	public void Accouple(){};// méthode définit dans les sous classes 
	
	public void Mourir(){ //supprime la Chose du tableau
		int index=-1;
		for(int i=0; i<(Constante.total_pop);i++){
			if(this.equals(Constante.population[i])) index = i;
		}
		if(index>=0){
			Chose population2[]=new Chose[Constante.total_pop-1]; 
			for(int j=0; j<(Constante.total_pop-1);j++){
				if(j<index)population2[j]=Constante.population[j];
				else population2[j]=Constante.population[j+1];
			}
			Constante.population=population2;
			Constante.total_pop=Constante.total_pop-1;
		}
	}
	
	public Chose[] Entourer(){	
		Chose autour[] =new Chose[4];
		for(int i=0; i<Constante.total_pop; i++){
			Chose ch = Constante.population[i];
			if (this.getCoordonnee().getX()+1 == ch.getCoordonnee().getX() && this.getCoordonnee().getY() == ch.getCoordonnee().getY()){
				autour[0]=ch;
			}
			if(this.getCoordonnee().getX()-1 == ch.getCoordonnee().getX() && this.getCoordonnee().getY() == ch.getCoordonnee().getY()){
				autour[1]=ch;
			}
			if(this.getCoordonnee().getX() == ch.getCoordonnee().getX() && this.getCoordonnee().getY()-1 == ch.getCoordonnee().getY()){
				autour[2]=ch;
			}
			if(this.getCoordonnee().getX() == ch.getCoordonnee().getX() && this.getCoordonnee().getY()+1 == ch.getCoordonnee().getY()){
				autour[3]=ch;
			}
		}
		return autour;
	}
	
	public void seDeplacer(){
		Chose autour[]=this.Entourer();
		Point p=this.getCoordonnee();
		boolean s1=true,s2=true,s3=true,s4=true;
		while( (s1 || s2 || s3 || s4) && this.getCoordonnee().equals(p)) // tant que la coordonnee n'a pas changee ou tant que tout les switchs n ont pas ete essayes
		{ 
			Random rn = new Random();
			int pos =rn.nextInt(4);
			switch (pos)
			{
			  case 0:
				  if(autour[0]==null && this.getCoordonnee().getX()<Constante.M ){
					  this.setCoordonnee(new Point(this.getCoordonnee().getY(),this.getCoordonnee().getX()+1));
				  }
				  else s1=false; 
			    break;
			  case 1:
				  if(autour[1]==null && this.getCoordonnee().getX()>0){
					  this.setCoordonnee(new Point(this.getCoordonnee().getY(),this.getCoordonnee().getX()-1));
				  }
				  else s2=false;
			    break;
			  case 2:
				  if(autour[2]==null && this.getCoordonnee().getY()<Constante.N ){
					  this.setCoordonnee(new Point(this.getCoordonnee().getY()+1,this.getCoordonnee().getX()));
				  }
				  else s3=false;
			    break; 
			  case 3:
				  if(autour[3]==null && this.getCoordonnee().getY()>0){
					  this.setCoordonnee(new Point(this.getCoordonnee().getY()-1,this.getCoordonnee().getX()));
				  }
				  else s4=false;
				break;
			}
		}
	}
	
	public boolean equals(Chose ch){
		return this.coordonnee.equals(ch.getCoordonnee());
	}

}
