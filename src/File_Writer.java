import java.io.*;
/*
 * Writes to the output files
 * Not called FileWriter because that's
 * already a Java class.
 */
public class File_Writer
{
    private String xmlprep = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
    "<score>\n" +
    "\t<p1>\n" +
    "\t\t<tag></tag>\n" + 
    "\t\t<prefix></prefix>\n" +
    "\t\t<score>0</score>\n" +
    "\t</p1>\n" +
    "\t<p2>\n" + 
    "\t\t<tag></tag>\n" + 
    "\t\t<prefix></prefix>\n" +
    "\t\t<score>0</score>\n" +
    "\t</p2>\n" +
    "\t<label></label>\n" +
    "\t<misc></misc>\n" +
    "</score>";   
    
    VarStorage vs = ScoreboardMenu.getVS();
    
    public void writeToText(String filename, String input)
    {
        // put your code here
        try {
            FileWriter filetowrite = new FileWriter("../Output/" + filename);
            filetowrite.write(input);
            filetowrite.close();
            System.out.println("Successfully wrote '" + input + "' to "
            + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while trying to write to " + filename);
        }
    }
    
    public void clearFile(String filename) {
        try {
            File toclear = new File("../Output/" + filename);
            toclear.delete();
            toclear.createNewFile();
            System.out.println(filename + " successfully cleared");
        } catch (IOException e) {
            System.out.println("Uh-oh. Something went wrong when clearing "
            + filename);
        }
    }
    
    public void updateFile(String filename, String input) {
        clearFile(filename);
        writeToText(filename, input);
    }
    
    public void prepareXML(String filename)
    {
        try {
            FileWriter filetowrite = new FileWriter("../Output/" + filename);
            filetowrite.write(xmlprep);
            filetowrite.close();
            System.out.println("Successfully prepared " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while trying to prepare " + filename);
        }
    }
    
    public void updateXML() {
        String p1tag = vs.getP1Tag();
        String p1prefix = vs.getP1Prefix();
        int p1score = vs.getP1Score();
        
        String p2tag = vs.getP2Tag();
        String p2prefix = vs.getP2Prefix();
        int p2score = vs.getP2Score();
        
        String tourneyname = vs.getTournament();
        String tourneyround = vs.getRound();
        
        xmlprep = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
        "<score>\n" +
        "\t<p1>\n" +
        "\t\t<tag>" + p1tag + "</tag>\n" + 
        "\t\t<prefix>" + p1prefix + "</prefix>\n" +
        "\t\t<score>" + p1score + "</score>\n" +
        "\t</p1>\n" +
        "\t<p2>\n" + 
        "\t\t<tag>" + p2tag + "</tag>\n" + 
        "\t\t<prefix>" + p2prefix + "</prefix>\n" +
        "\t\t<score>" + p2score + "</score>\n" +
        "\t</p2>\n" +
        "\t<label>" + tourneyname + "</label>\n" +
        "\t<misc>" + tourneyround + "</misc>\n" +
        "</score>";
        
        prepareXML("scores.xml");                                                                                                                                                           
    }
}
