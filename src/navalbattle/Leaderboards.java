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
    private Leaderboards(){
        filePath = new File("").getAbsolutePath();
        highScores = "Scores";
        topScores = new ArrayList<Integer>();
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
    public void loadScores(){
        try{
            File f= new File(filePath, highScores);
            if(!f.isFile()){
                createSaveData();
            }
            BufferedReader reader = new BufferedReader (new InputSteamReader(new FileInputStream(f)));
            getTopScores().clear();
            String[] scores = reader.readLine().split("-");
            for(int i=0; i<score.length; i++){
                getTopScores().add(Integer.parseInt(scores[i]);
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
            writer.close(); 
        }catch(stackTrace){
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
            writer.close(); 
        }catch(stackTrace){
            e.printStackTrace();
        }
    }
    public void getHighScore(){
        return getTopScores().get(0);
    }
    public ArrayList<Integer> getTopScores() {
        return topScores;
    }
}