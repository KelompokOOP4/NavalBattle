package navalbattle;

/**
 *
 * @author rizky
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
public class Leaderboards {
    private static Leaderboards lBoard;
    private String filePath;
    private String highScores;
    private ArrayList<Integer> topScores;
    private ArrayList<Integer>topTiles;
    private ArrayList<Long>topTimes;
    private Leaderboards(){
        filePath = new File("").getAbsolutePath();
        highScores = "Scores";
        topScores = new ArrayList<Integer>();
        topTiles = new ArrayList<Integer>();
        topTimes = new ArrayList<Long>();        
    }
    public static Leaderboards getInstance(){
        if(lBoard == null){
            lBoard = new Leaderboards();
        }
        return lBoard;
    }
    public void addScore(int score){
        for(int i=0; i<topScore.size(); i++){
            getTopScores().add(i, score);
            getTopScores().remove(getTopScores().size()-1);
            return;
        }
    }
    public void addTile(int tileValue){
        for(int i=0; i<getTopTiles().size(); i++){
            getTopTiles().add(i, tileValue);
            getTopTiles().remove(getTopTiles().size()-1);
            return
        }
    }
    public void addTime(long millis){
        for(int i=0; i<getTopTimes().size(); i++){
            if(millis <= getTopTimes().get(i)){
                getTopTimes().add(i, millis);
                getTopTimes().remove(getTopTimes().size()-1);
                return;
            }
        }
    }
    public void loadScores(){
        try{
            File f= new File(filePath, highScores);
            if(!f.isFile()){
                createSaveData();
            }
            BufferedReader reader = new BufferedReader (new InputSteamReader(new FileInputStream(f)));
            getTopScores().clear();
            getTopTiles().clear();
            getTopTimes().clear();
            String[] scores = reader.readLine().split("-");
            String[] tiles = reader.readLine().split("-");
            String[] times = reader.readLine().split("-");
            for(int i=0; i<score.length; i++){
                getTopScores().add(Integer.parseInt(scores[i]);
            }
            for(int i=0; i<tiles.length; i++){
                getTopTiles().add(Integer.parseInt(tiles[i]);
            }
            for(int i=0; i<times.length; i++){
                getTopTimes().add(Long.parseLong(times[i]);
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void saveScores(){
        FileWriter output = null;
        try{
            File f = new File(filePath, highScores);
            output = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write(getTopScores().get(0)+"-"+getTopScores().get(1)+"-"+getTopScores().get(2)+"-"+getTopScores().get(3)+"-"+getTopScores().get(4));
            writer.newLine();
            writer.write(getTopTiles().get(0)+"-"+getTopTiles().get(1)+"-"+getTopTiles().get(2)+"-"+getTopTiles().get(3)+"-"+getTopTiles().get(4));
            writer.newLine();
            writer.write(getTopTimes().get(0)+"-"+getTopTimes().get(1)+"-"+getTopTimes().get(2)+"-"+getTopTimes().get(3)+"-"+getTopTimes().get(4));
            writer.close(); 
        }catch{
            e.printStackTrace();
        }
    }
    private void createSaveData(){
        FileWriter output = null;
        try{
            File f = new File(filePath, highScores);
            output = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write("0-0-0-0");
            writer.newLine();
            writer.write("0-0-0-0");
            writer.newLine();
            writer.write(Integer.MAX_VALUE+"-"+Integer.MAX_VALUE+"-"+Integer.MAX_VALUE+"-"+Integer.MAX_VALUE);
            writer.close(); 
        }catch{
            e.printStackTrace();
        }
    }
    public void getHighScore(){
        return getTopScores().get(0);
    }
    public long getFastestTime(){
        return getTopTimes().get(0);
    }
    public int getHighTile(){
        return getTopTiles().get(0);
    }
    public ArrayList<Integer> getTopScores() {
        return topScores;
    }
    public ArrayList<Integer> getTopTiles() {
        return topTiles;
    }
    public ArrayList<Long> getTopTimes() {
        return topTimes;
    }
}