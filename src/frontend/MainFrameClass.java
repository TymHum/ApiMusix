package frontend;

import backend.MainCommands;
import org_jmusixmatch.entity.artist.Artist;
import org_jmusixmatch.entity.track.Track;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class MainFrameClass extends JFrame implements ActionListener {
    public JButton search;
    public MainCommands find = new MainCommands();
    public List<Artist> artists = find.findChartArtists();
    public List<Track> tracks = find.findChartTracks();
    public MainFrameClass() {
        super("Music App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        JPanel jPanelMain = new JPanel(new BorderLayout());

        JPanel jPanelTitle = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        jPanelTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jPanelTitle.setBackground(new Color(222, 184, 135));
        JLabel titleLabel = new JLabel("Tymofii&Krishn Musix");
        titleLabel.setFont(new Font("MV BOLI", Font.BOLD, 30));
        jPanelTitle.add(titleLabel);
        jPanelMain.add(jPanelTitle, BorderLayout.NORTH);

        JPanel jPanelCenter = new JPanel(new GridLayout(0, 1));
        jPanelCenter.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JPanel chartPanel = new JPanel(new GridLayout(0, 2));
        chartPanel.setBackground(new Color(222, 184, 135));

        JLabel jArtistChart = new JLabel("Artists Chart: ");
        jArtistChart.setFont(new Font("MV BOLI", Font.BOLD, 25));
        JLabel jTrackChart = new JLabel("Tracks Chart: ");
        jTrackChart.setFont(new Font("MV BOLI", Font.BOLD, 25));
        chartPanel.add(jArtistChart);
        chartPanel.add(jTrackChart);

        JPanel artistChartPanel = new JPanel(new GridLayout(0, 1));
        artistChartPanel.setBackground(new Color(222, 184, 135));
        JLabel artistChartLabel = new JLabel("Top Artists this week: ");
        artistChartLabel.setFont(new Font("MV BOLI", Font.BOLD, 20));
        artistChartPanel.add(artistChartLabel);
        for(Artist artist : artists) {
            JLabel artistTemp = new JLabel(artist.getArtistData().getArtistName());
            artistTemp.setFont(new Font("MV BOLI", Font.PLAIN, 15));
            artistChartPanel.add(artistTemp);
        }
        chartPanel.add(artistChartPanel);

        JPanel trackChartPanel = new JPanel(new GridLayout(0, 1));
        trackChartPanel.setBackground(new Color(222, 184, 135));
        JLabel trackChartLabel = new JLabel("Top Tracks this week: ");
        trackChartLabel.setFont(new Font("MV BOLI", Font.BOLD, 20));
        trackChartPanel.add(trackChartLabel);
        for(Track track : tracks) {
            JLabel trackTemp = new JLabel(track.getTrack().getTrackName());
            trackTemp.setFont(new Font("MV BOLI", Font.PLAIN, 15));
            trackChartPanel.add(trackTemp);
        }
        chartPanel.add(trackChartPanel);

        jPanelCenter.add(chartPanel);

        JPanel jSearchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jSearchPanel.setBackground(new Color(222, 184, 135));
        jSearchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JLabel jPressLabel = new JLabel("Search some specific track or artist: ");
        jPressLabel.setFont(new Font("MV BOLI", Font.BOLD, 20));
        jSearchPanel.add(jPressLabel);
        search = new JButton("Search");
        search.addActionListener(this);
        search.setFocusable(false);
        jSearchPanel.add(search);
        jPanelCenter.add(jSearchPanel);

        jPanelMain.add(jPanelCenter, BorderLayout.CENTER);

        JPanel jPanelFooter = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));
        jPanelFooter.setBackground(new Color(222, 184, 135));
        jPanelFooter.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JLabel footerLabel = new JLabel("Made by Tymofii&Krishn Musix");
        footerLabel.setFont(new Font("MV BOLI", Font.BOLD, 15));
        jPanelFooter.add(footerLabel);
        jPanelMain.add(jPanelFooter, BorderLayout.SOUTH);

        add(jPanelMain);
    }

    private Color randomColor() {
        Random random = new Random();
        int color = random.nextInt();

        return new Color(color);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search) {
            dispose();
            SearchAnArtist searchAnArtist = new SearchAnArtist();
        }
    }


    public static void main(String[] args) {
        new MainFrameClass();
    }
}
