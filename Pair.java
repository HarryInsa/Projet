public class Pair {
    
    public int a ;
    public int b ;
    
    
    public Pair(int nb1, int nb2) {
        this.a = nb1;
        this.b = nb2;
    }
    
    public boolean equals (Object o){ 
		Pair p = null;
		if(o instanceof Pair){
			p = (Pair) o;
			if(this.a == p.a && this.b == p.b){
				return true;
			}
		}
		return false;
	}	
    
}
