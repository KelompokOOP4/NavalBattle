package navalbattle;

/**
 *
 * @author rizky
 */
public class Leaderboard {
 private String playerID;
 private int playerScore;
    public Leaderboard(String name, int score){
    public String getPlayerID() {
        return playerID;
    } public void setPlayerID(String playerID) {
        this.playerID = playerID;
    } public int getPlayerScore() {
        return playerScore;
    } public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
    playerID = name;
    playerScore = score;
    } 
}
