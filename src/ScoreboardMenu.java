import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
/*
 * Generates the UI that edits the output files.
 */
public class ScoreboardMenu implements ActionListener
{
    private final int FRAME_WIDTH = 450;
    private final int FRAME_HEIGHT = 400;

    private final int P1_OFFSET_X = 20;
    private final int P2_OFFSET_X = 270;
    private final int TEXT_OFFSET = -5;
    private final int TEXTFIELD_OFFSET = 5;

    private final int BUTTON_WIDTH = 150;
    private final int BUTTON_HEIGHT = 30;

    private final int LABEL_WIDTH = 150;
    private final int LABEL_HEIGHT = 25;

    private final int TEXTFIELD_WIDTH = 160;
    private final int PREFIX_TEXTFIELD_HEIGHT = 25;
    private final int TAG_TEXTFIELD_HEIGHT = 30;
    private final int SCORE_TEXTFIELD_WIDTH = TEXTFIELD_WIDTH / 2;
    private final int SCORE_TEXTFIELD_HEIGHT = 100;

    private final int SCORE_BUTTON_WIDTH = SCORE_TEXTFIELD_WIDTH;
    private final int SCORE_BUTTON_HEIGHT = SCORE_TEXTFIELD_HEIGHT / 2;
    private final int SWPL_BUTTON_WIDTH = TEXTFIELD_WIDTH;

    private Font prefixfont = new Font("Dialog", Font.PLAIN, 12);
    private Font tagfont = new Font("Dialog", Font.PLAIN, 14);
    private Font scorefont = new Font("Dialog", Font.BOLD, 70);

    File_Writer fw = new File_Writer();
    static VarStorage vs = new VarStorage();

    // World and Buttons
    JFrame frame;
    JPanel panel;
    JButton update; // Need to move up from the bottom
    JButton reset; // Need to move up from the bottom
    JLabel tournament_name_label;
    JTextField tournament_name;
    JLabel tournament_round_label;
    JTextField tournament_round;
    JButton switchplayers;

    // Player 1 Stuff
    JLabel p1tag_label;
    JTextField p1tag;
    JLabel p1prefix_label;
    JTextField p1prefix;
    JTextField p1score;
    JButton p1scoreup; 
    JButton p1scoredown;

    // Player 2 Stuff
    JLabel p2tag_label;
    JTextField p2tag;
    JLabel p2prefix_label;
    JTextField p2prefix;
    JTextField p2score;
    JButton p2scoreup;
    JButton p2scoredown;

    public ScoreboardMenu() {
        frame = new JFrame("OBS Java Scoreboard");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        p1prefix_label = new JLabel("Player 1 Prefix");
        p1prefix_label.setBounds(P1_OFFSET_X, 10, LABEL_WIDTH, LABEL_HEIGHT);
        panel.add(p1prefix_label);

        p1prefix = new JTextField();
        p1prefix.setBounds(P1_OFFSET_X, p1prefix_label.getY() + p1prefix_label.getHeight()
            + TEXT_OFFSET, TEXTFIELD_WIDTH, PREFIX_TEXTFIELD_HEIGHT);
        p1prefix.setFont(prefixfont);
        panel.add(p1prefix);

        p1tag_label = new JLabel("Player 1 Tag");
        p1tag_label.setBounds(P1_OFFSET_X, p1prefix.getY() + p1prefix.getHeight() 
            + TEXTFIELD_OFFSET, LABEL_WIDTH, LABEL_HEIGHT);
        panel.add(p1tag_label);

        p1tag = new JTextField();
        p1tag.setBounds(P1_OFFSET_X, p1tag_label.getY() + p1tag_label.getHeight() 
            + TEXT_OFFSET, TEXTFIELD_WIDTH, TAG_TEXTFIELD_HEIGHT);
        p1tag.setFont(tagfont);
        panel.add(p1tag);

        p1score = new JTextField(Integer.toString(vs.getP1Score()));
        p1score.setBounds(p1tag.getX() + p1tag.getWidth() - SCORE_TEXTFIELD_WIDTH, p1tag.getY()
            + p1tag.getHeight() + TEXTFIELD_OFFSET, SCORE_TEXTFIELD_WIDTH, SCORE_TEXTFIELD_HEIGHT);
        p1score.setFont(scorefont);
        p1score.setHorizontalAlignment(JTextField.CENTER);
        panel.add(p1score);

        p1scoreup = new JButton("P1 +");
        p1scoreup.setBounds(p1score.getX() - SCORE_TEXTFIELD_WIDTH, p1score.getY(),
            SCORE_BUTTON_WIDTH, SCORE_BUTTON_HEIGHT);
        panel.add(p1scoreup);

        p1scoredown = new JButton("P1 -");
        p1scoredown.setBounds(p1scoreup.getX(), p1scoreup.getY() + p1scoreup.getHeight(),
            SCORE_BUTTON_WIDTH, SCORE_BUTTON_HEIGHT);
        panel.add(p1scoredown);

        p2prefix_label = new JLabel("Player 2 Prefix");
        p2prefix_label.setBounds(P2_OFFSET_X, 10, LABEL_WIDTH, LABEL_HEIGHT);
        panel.add(p2prefix_label);

        p2prefix = new JTextField();
        p2prefix.setBounds(P2_OFFSET_X, p2prefix_label.getY() + p2prefix_label.getHeight()
            + TEXT_OFFSET, TEXTFIELD_WIDTH, PREFIX_TEXTFIELD_HEIGHT);
        p2prefix.setFont(prefixfont);
        panel.add(p2prefix);

        p2tag_label = new JLabel("Player 2 Tag");
        p2tag_label.setBounds(P2_OFFSET_X, p2prefix.getY() + p2prefix.getHeight()
            + TEXTFIELD_OFFSET, LABEL_WIDTH, LABEL_HEIGHT);
        panel.add(p2tag_label);

        p2tag = new JTextField();
        p2tag.setBounds(P2_OFFSET_X, p2tag_label.getY() + p2tag_label.getHeight()
            + TEXT_OFFSET, TEXTFIELD_WIDTH, TAG_TEXTFIELD_HEIGHT);
        p2tag.setFont(tagfont);
        panel.add(p2tag);

        p2score = new JTextField(Integer.toString(vs.getP2Score()));
        p2score.setBounds(p2tag.getX(), p2tag.getY() + p2tag.getHeight() + TEXTFIELD_OFFSET, 
            SCORE_TEXTFIELD_WIDTH, SCORE_TEXTFIELD_HEIGHT);
        p2score.setFont(scorefont);
        p2score.setHorizontalAlignment(JTextField.CENTER);
        panel.add(p2score);

        p2scoreup = new JButton("P2 +");
        p2scoreup.setBounds(p2score.getX() + SCORE_TEXTFIELD_WIDTH, p2score.getY(),
            SCORE_BUTTON_WIDTH, SCORE_BUTTON_HEIGHT);
        panel.add(p2scoreup);

        p2scoredown = new JButton("P2 -");
        p2scoredown.setBounds(p2scoreup.getX(), p2scoreup.getY() + p2scoreup.getHeight(),
            SCORE_BUTTON_WIDTH, SCORE_BUTTON_HEIGHT);
        panel.add(p2scoredown);

        update = new JButton("Update");
        update.setBounds(P1_OFFSET_X, 330, BUTTON_WIDTH, BUTTON_HEIGHT);
        panel.add(update);

        reset = new JButton("Reset");
        reset.setBounds(P2_OFFSET_X, 330, BUTTON_WIDTH, BUTTON_HEIGHT);
        panel.add(reset);

        tournament_name_label = new JLabel("Tournament Name");
        tournament_name_label.setBounds(P1_OFFSET_X, p1scoredown.getY() + p1scoredown.getHeight() 
            + TEXTFIELD_OFFSET, LABEL_WIDTH, LABEL_HEIGHT);
        panel.add(tournament_name_label);

        tournament_name = new JTextField();
        tournament_name.setBounds(P1_OFFSET_X, tournament_name_label.getY() + tournament_name_label.getHeight() 
            + TEXT_OFFSET, TEXTFIELD_WIDTH, TAG_TEXTFIELD_HEIGHT);
        panel.add(tournament_name);

        tournament_round_label = new JLabel("Tournament Round");
        tournament_round_label.setBounds(P2_OFFSET_X, p2scoredown.getY() + p2scoredown.getHeight() 
            + TEXTFIELD_OFFSET, LABEL_WIDTH, LABEL_HEIGHT);
        panel.add(tournament_round_label);

        tournament_round = new JTextField();
        tournament_round.setBounds(P2_OFFSET_X, tournament_round_label.getY() + tournament_round_label.getHeight()
            + TEXT_OFFSET, TEXTFIELD_WIDTH, TAG_TEXTFIELD_HEIGHT);
        panel.add(tournament_round);

        switchplayers = new JButton("<- Switch ->");
        switchplayers.setBounds(frame.getWidth() / 2 - SWPL_BUTTON_WIDTH / 2,
            tournament_round.getY() + tournament_round.getHeight() + TEXTFIELD_OFFSET, SWPL_BUTTON_WIDTH,
            TAG_TEXTFIELD_HEIGHT);
        panel.add(switchplayers);

        update.addActionListener(this);
        reset.addActionListener(this);
        p1scoreup.addActionListener(this);
        p1scoredown.addActionListener(this);
        p2scoreup.addActionListener(this);
        p2scoredown.addActionListener(this);
        switchplayers.addActionListener(this);
    }
    
    /*
     * Shows or hides the frame
     */
    public void setVisible(boolean b) {
    	frame.setVisible(b);
    }

    /*
     * Checks for when a button is pressed and performs
     * corresponding action
     */
    public void actionPerformed(ActionEvent ae) {
        String event = ae.getActionCommand();
        if (p1prefix.getText().length() > 5) {
            char[] arr = p1prefix.getText().toCharArray();
            char[] arr2 = Arrays.copyOfRange(arr, 0, 7);
            p1prefix.setText(String.copyValueOf(arr2));
        }

        if (p2prefix.getText().length() > 5) {
            char[] arr = p2prefix.getText().toCharArray();
            char[] arr2 = Arrays.copyOfRange(arr, 0, 7);
            p2prefix.setText(String.copyValueOf(arr2));
        }

        vs.setP1Prefix(p1prefix.getText().toUpperCase());
        p1prefix.setText(vs.getP1Prefix());

        vs.setP2Prefix(p2prefix.getText().toUpperCase());
        p2prefix.setText(vs.getP2Prefix());

        try {
            vs.setP1Score(Integer.parseInt(p1score.getText()));
        } catch (Exception e) {
            vs.setP1Score(0);
        }

        try {
            vs.setP2Score(Integer.parseInt(p2score.getText()));
        } catch (Exception e) {
            vs.setP2Score(0);
        }

        if (event.equals("Update")) {
            updateAll();
        }

        if (event.equals("Reset")) {
            resetAll();
        }

        if (event.equals(p1scoreup.getText())) {
            vs.setP1Score(vs.getP1Score() + 1);
            fw.updateFile("p1_score.txt", 
                Integer.toString(vs.getP1Score()));
            p1score.setText(Integer.toString(vs.getP1Score()));

            fw.updateXML();
        }

        if (event.equals(p1scoredown.getText())) {
            vs.setP1Score(vs.getP1Score() - 1);

            if (vs.getP1Score() < 0) {
                vs.setP1Score(0);
            }
            fw.updateFile("p1_score.txt", 
                Integer.toString(vs.getP1Score()));
            p1score.setText(Integer.toString(vs.getP1Score()));

            fw.updateXML();
        }

        if (event.equals(p2scoreup.getText())) {
            vs.setP2Score(vs.getP2Score() + 1);
            fw.updateFile("p2_score.txt", 
                Integer.toString(vs.getP2Score()));
            p2score.setText(Integer.toString(vs.getP2Score()));

            fw.updateXML();
        }

        if (event.equals(p2scoredown.getText())) {
            vs.setP2Score(vs.getP2Score() - 1);
            if (vs.getP2Score() < 0) {
                vs.setP2Score(0);
            }
            fw.updateFile("p2_score.txt", 
                Integer.toString(vs.getP2Score()));
            p2score.setText(Integer.toString(vs.getP2Score()));

            fw.updateXML();
        }

        if (event.equals(switchplayers.getText())) {
            String p1_prefix = p1prefix.getText();
            String p1_tag = p1tag.getText();
            int p1_score_backup = vs.getP1Score();

            p1prefix.setText(p2prefix.getText());
            p2prefix.setText(p1_prefix);

            p1tag.setText(p2tag.getText());
            p2tag.setText(p1_tag);

            vs.setP1Tag(p1tag.getText());
            vs.setP1Prefix(p1prefix.getText());

            vs.setP2Tag(p2tag.getText());
            vs.setP2Prefix(p2prefix.getText());

            vs.setP1Score(vs.getP2Score());
            vs.setP2Score(p1_score_backup);

            p1score.setText(Integer.toString(vs.getP1Score()));
            p2score.setText(Integer.toString(vs.getP2Score()));

            updateAll();
        }
    }

    /*
     * Updates output files
     */
    public void updateAll() {
        vs.setP1Tag(p1tag.getText());
        vs.setP1Prefix(p1prefix.getText());

        vs.setP2Tag(p2tag.getText());
        vs.setP2Prefix(p2prefix.getText());

        vs.setTournament(tournament_name.getText());
        vs.setRound(tournament_round.getText());

        fw.updateFile("p1_tag.txt", vs.getP1Tag());
        fw.updateFile("p2_tag.txt", vs.getP2Tag());

        fw.updateFile("p1_prefix.txt", vs.getP1Prefix());
        fw.updateFile("p2_prefix.txt", vs.getP2Prefix());

        fw.updateFile("p1_score.txt", 
            Integer.toString(vs.getP1Score()));
        fw.updateFile("p2_score.txt", 
            Integer.toString(vs.getP2Score()));

        fw.updateFile("tourneyname.txt", vs.getTournament());
        fw.updateFile("tourneyround.txt", vs.getRound());

        fw.updateXML();
    }

    /*
     * Clears output files
     */
    public void resetAll() {
        vs.reset();

        fw.clearFile("p1_prefix.txt");
        p1prefix.setText("");

        fw.clearFile("p1_tag.txt");
        p1tag.setText("");

        fw.clearFile("p2_prefix.txt");
        p2prefix.setText("");

        fw.clearFile("p2_tag.txt");
        p2tag.setText("");

        fw.updateFile("p1_score.txt", Integer.toString(vs.getP1Score()));
        p1score.setText(Integer.toString(vs.getP1Score()));

        fw.updateFile("p2_score.txt", Integer.toString(vs.getP2Score()));
        p2score.setText(Integer.toString(vs.getP2Score()));

        fw.clearFile("tourneyname.txt");
        tournament_name.setText("");

        fw.clearFile("tourneyround.txt");
        tournament_round.setText("");

        fw.updateXML();
    }

    /*
     * Used for File_Writer class
     */
    public static VarStorage getVS() {
        return vs;
    }
}
