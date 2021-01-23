public class Driver
{
    public static void main(String[] args) {        
        File_Creator fc = new File_Creator();
        File_Writer fw = new File_Writer();
        
        fc.createFiles();
        
        fw.prepareXML("scores.xml");
        
        ScoreboardMenu menu = new ScoreboardMenu();
    }
}
