public enum GameType {
    SLIDING(1),
    DOTS_AND_BOXES(2);

    public final int players;
    
    GameType(int players) { 
        this.players = players; 
    }
}
