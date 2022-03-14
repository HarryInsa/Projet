public class Pair {
    
    private int a ;
    private int b ;
    
    
    public Pair(int nb1, int nb2) {
        this.a = nb1;
        this.b = nb2;
    }
    
    //Méthode de comparaison renvoie true ou false
    public boolean equals(Pair p1){
        if(this.a==p1.a && this.b==p1.b || this.b==p1.a && this.a==p1.b)
            return true;
        else
            return false;
    }
    
    // Affichage
    public String toString(){
        return "("+a+","+b+")";
    }
}
