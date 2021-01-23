import java.io.*;
/*
 * First function of the program that runs
 * If the files don't already exist, then they are created
 * Output folder, both players' tags, scores, and prefixes (as txt files)
 */
public class File_Creator
{
    public void createFiles()
    {
        folderMaker("Output");
        
        fileMaker("p1_tag.txt");
        fileMaker("p2_tag.txt");
        fileMaker("p1_score.txt");
        fileMaker("p2_score.txt");
        fileMaker("p1_prefix.txt");
        fileMaker("p2_prefix.txt");
        fileMaker("tourneyname.txt");
        fileMaker("tourneyround.txt");
        
        fileMaker("scores.xml");
    }
    
    /*
     * Creates folders to store output in
     */
    public void folderMaker(String foldername) {
        File newfolder = new File("../" + foldername);
        if (newfolder.mkdir()) {
            System.out.println(foldername + " folder created");
        } else {
            System.out.println(foldername + " folder already exists");
        }
    }
    
    /*
     * Creates the files with the filetype included in filename
     * Example: fileMaker("index.txt") generates index.txt file
     */
    public void fileMaker(String filename) {
        try {
            File new_file = new File("../Output/" + filename);
            if (new_file.createNewFile()) {
                System.out.println(filename + " created");
            } else {
                System.out.println(filename + " already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred when making " + filename);
        }
    }
}
