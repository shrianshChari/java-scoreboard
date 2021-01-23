
/*
 * A class that stores all the interactible
 * data for the functions to use. Contains the
 * scores, tags, and prefixes of both players,
 * as well as the tournament name and round.
 */
public class VarStorage
{
    private int p1_score;
    private int p2_score;
    
    private String p1_tag;
    private String p1_prefix;
    
    private String p2_prefix;
    private String p2_tag;
    
    private String tournament_name;
    private String tournament_round;
    
    public VarStorage() {
        p1_score = 0;
        p2_score = 0;
    }
    
    public int getP1Score() {
        return p1_score;
    }
    
    public void setP1Score(int score) {
        p1_score = score;
    }
    
    public int getP2Score() {
        return p2_score;
    }
    
    public void setP2Score(int score) {
        p2_score = score;
    }
    
    public String getP1Prefix() {
        return p1_prefix;
    }
    
    public void setP1Prefix(String p) {
        p1_prefix = p;
    }
    
    public String getP1Tag() {
        return p1_tag;
    }
    
    public void setP1Tag(String t) {
        p1_tag = t;
    }
    
    public String getP2Prefix() {
        return p2_prefix;
    }
    
    public void setP2Prefix(String p) {
        p2_prefix = p;
    }
    
    public String getP2Tag() {
        return p2_tag;
    }
    
    public void setP2Tag(String t) {
        p2_tag = t;
    }
    
    public String getTournament() {
        return tournament_name;
    }
    
    public void setTournament(String n) {
        tournament_name = n;
    }
    
    public String getRound() {
        return tournament_round;
    }
    
    public void setRound(String r) {
        tournament_round = r;
    }
    
    public void reset() {
        setP1Score(0);
        setP2Score(0);
        setP1Prefix("");
        setP1Tag("");
        setP2Prefix("");
        setP2Tag("");
        setTournament("");
        setRound("");
    }
}
