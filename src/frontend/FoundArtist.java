package frontend;

import backend.MainCommands;
import org_jmusixmatch.entity.artist.Artist;
import org_jmusixmatch.entity.lyrics.Lyrics;
import org_jmusixmatch.entity.track.Track;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FoundArtist extends JFrame implements ActionListener {
    public Track track;
    public JLabel artistNameLabel;
    public JLabel trackNameLabel;
    public JLabel albumNameLabel;
    public JPanel jPanelTitle;
    public JPanel jpanelFooter;
    public JButton returnButton;
    public JPanel jpanelCommands;
    public JButton getLyricButton;
    public JButton getTrackRatingButton;
    public JButton getArtistRatingButton;
    public JButton getBirthDateButton;
    public Artist artist;
    public Lyrics lyrics;
    public MainCommands mainCommands;

    public FoundArtist(Track track){
        super("Found Track");
        this.track = track;
        mainCommands = new MainCommands();
        artist = mainCommands.findArtist(track.getTrack().getArtistId());
        lyrics = mainCommands.findLyrics(track.getTrack().getTrackId());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        JPanel panelMain = new JPanel(new BorderLayout());

        //<editor-fold defaultstate="collapsed" desc="Title">
        jPanelTitle = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        artistNameLabel = new JLabel("Artist name:   " + track.getTrack().getArtistName());
        jPanelTitle.add(artistNameLabel);
        trackNameLabel = new JLabel("Track name:   " + track.getTrack().getTrackName());
        jPanelTitle.add(trackNameLabel);
        albumNameLabel = new JLabel("Album name:   " + track.getTrack().getAlbumName());
        jPanelTitle.add(albumNameLabel);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="jpanelCommands">
        ArrayList<JButton> aLButtons = new ArrayList<JButton>();

        jpanelCommands = new JPanel(new GridLayout(0, 1));

        getLyricButton = new JButton("Get Lyrics");
        aLButtons.add(getLyricButton);

        getTrackRatingButton = new JButton("Get Track Rating");
        aLButtons.add(getTrackRatingButton);

        getArtistRatingButton = new JButton("Get Artist Rating");
        aLButtons.add(getArtistRatingButton);

        getBirthDateButton = new JButton("Get Birth Day");
        aLButtons.add(getBirthDateButton);

        setButtonParameters(aLButtons);
        //</editor-fold>


        //<editor-fold desc="Footer">
        jpanelFooter = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        returnButton = new JButton("Return");
        returnButton.setFocusable(false);
        returnButton.addActionListener(this);
        jpanelFooter.add(returnButton);
        //</editor-fold>

        randomColor();
        panelMain.add(jPanelTitle, BorderLayout.NORTH);
        panelMain.add(jpanelCommands, BorderLayout.CENTER);
        panelMain.add(jpanelFooter, BorderLayout.SOUTH);
        add(panelMain);

    }

    private void setButtonParameters(ArrayList<JButton> aLButtons) {
        for(JButton button : aLButtons){
            button.setFocusable(false);
            button.addActionListener(this);
            jpanelCommands.add(button);
        }
    }


    private void randomColor() {
        Color backgroundColor = getRandomColor();
        int oppositeColor = getOppositeColor(backgroundColor);

        jPanelTitle.setBackground(backgroundColor);
        jpanelCommands.setBackground(backgroundColor);
        jpanelFooter.setBackground(backgroundColor);

        artistNameLabel.setForeground(new Color(oppositeColor));
        trackNameLabel.setForeground(new Color(oppositeColor));
        albumNameLabel.setForeground(new Color(oppositeColor));
    }

    private int getOppositeColor(Color color) {
        int r = 255 - color.getRed();
        int g = 255 - color.getGreen();
        int b = 255 - color.getBlue();

        return new Color(r, g, b).getRGB();
    }

    private Color getRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == returnButton){
            dispose();
            MainFrameClass mainFrameClass = new MainFrameClass();
        }
        if(src == getLyricButton){
            creareLyricFrame(lyrics.getLyricsBody());
        }
        if(src == getTrackRatingButton){
            JOptionPane.showMessageDialog(null, track.getTrack().getTrackName() + " rating: " + track.getTrack().getTrackRating());
        }
        if(src == getArtistRatingButton){
            JOptionPane.showMessageDialog(null, artist.getArtistData().getArtistName() + " rating: " +artist.getArtistData().getArtistRating());
        }
        if(src == getBirthDateButton){
            JOptionPane.showMessageDialog(null,
                    (artist.getArtistData().getBirthDate().equals("0000-00-00"))
                            ?"Lack of information" : artist.getArtistData().getArtistName() + " birth date: " +artist.getArtistData().getBirthDate());

        }
    }

    private void creareLyricFrame(String lyricsBody) {
        JFrame lyricsFrame = new JFrame();
        lyricsFrame.setTitle("Lyrics");
        lyricsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panelMain = new JPanel(new BorderLayout());
        TextArea text = new TextArea(lyricsBody);
        //panelMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        text.setFont(new Font("Calibri", Font.BOLD, 18));
        text.setEditable(false);
        text.setForeground(Color.WHITE);
        text.setBackground(getRandomColor());
        panelMain.add(text, BorderLayout.CENTER);
        lyricsFrame.add(panelMain);
        lyricsFrame.pack();
        lyricsFrame.setLocationRelativeTo(null);
        lyricsFrame.setVisible(true);
    }


}
