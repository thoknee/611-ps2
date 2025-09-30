public class Player {
    

    private final String name;
    private int wins;


    public Player(String name){
        this.name = name;
    }

    public String getName() { 
        return name;
     }

    public int getWins() { 
        return wins; 
    }

    public void incrementWins(){
        this.wins++;
    }
}
