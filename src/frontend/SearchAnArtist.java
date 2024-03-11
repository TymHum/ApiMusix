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

public class SearchAnArtist extends JFrame implements ActionListener {
    public JButton returnPage;
    public JButton search;
    public JTextField titleTextField;
    public JTextField artistTextField;
    public JLabel artistLabel;
    public JLabel titleLabel;
    public MainCommands find = new MainCommands();
    public SearchAnArtist() {
        super("Music App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        JPanel jPanelMain = new JPanel(new BorderLayout());
        JPanel jPanelQuery = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));

        artistLabel = new JLabel("Artist");
        jPanelQuery.add(artistLabel);
        artistTextField = new JTextField("The Weeknd",10);
        jPanelQuery.add(artistTextField);
        titleLabel = new JLabel("Title");
        jPanelQuery.add(titleLabel);
        titleTextField = new JTextField("Blinding Lights",10);
        jPanelQuery.add(titleTextField);

        search = new JButton("Search");
        search.setFocusable(false);
        search.addActionListener(this);
        jPanelQuery.add(search);

        returnPage = new JButton("Return");
        returnPage.setFocusable(false);
        returnPage.addActionListener(this);
        jPanelQuery.add(returnPage);
        jPanelQuery.setBackground(randomColor());
        jPanelMain.add(jPanelQuery, BorderLayout.NORTH);
        add(jPanelMain);
    }

    private Color randomColor() {
        Random random = new Random();
        int color = random.nextInt();
        artistLabel.setForeground(new Color(color/33));
        titleLabel.setForeground(new Color(color/33));
        return new Color(color);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search) {
            String artist = artistTextField.getText();
            String title = titleTextField.getText();

            Track track = find.findMatches(artist, title);
            System.out.println(track.getTrack().getArtistName());
            if (track.getTrack() != null) {
                new FoundArtist(track);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Song isn't found.");
            }
        }

        if(e.getSource() == returnPage) {
            dispose();
            MainFrameClass mainFrameClass = new MainFrameClass();
        }
    }
}
