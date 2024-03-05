import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FavAnime {
    private class Anime {
        String Name;
        String Launch;
        String Resume;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }

        public String getLaunch() {
            return Launch;
        }

        public void setLaunch(String launch) {
            this.Launch = launch;
        }

        public String getResume() {
            return Resume;
        }

        public void setResume(String resume) {
            this.Resume = resume;
        }
    }

    private ArrayList<Anime> animeList;

    public FavAnime() {
        animeList = new ArrayList<>();
    }

    public void addAnime(String name, String launch, String resume) {
        Anime anime = new Anime();
        anime.setName(name);
        anime.setLaunch(launch);
        anime.setResume(resume);
        animeList.add(anime);
    }

    public void displayGUI() {
        JFrame frame = new JFrame("Favorite Anime");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(animeList.size(), 1));

        for (Anime anime : animeList) {
            JPanel animePanel = new JPanel();
            animePanel.setLayout(new BorderLayout());

            JLabel nameLabel = new JLabel("Name: " + anime.getName());
            JLabel launchLabel = new JLabel("Launch: " + anime.getLaunch());
            JTextArea resumeArea = new JTextArea("Resume: " + anime.getResume());
            resumeArea.setLineWrap(true);
            resumeArea.setWrapStyleWord(true);
            resumeArea.setEditable(false);

            animePanel.add(nameLabel, BorderLayout.NORTH);
            animePanel.add(launchLabel, BorderLayout.CENTER);
            animePanel.add(resumeArea, BorderLayout.SOUTH);

            mainPanel.add(animePanel);
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FavAnime favAnime = new FavAnime();
            // Add your favorite anime here
            favAnime.addAnime("Naruto", "2002", "A young ninja seeks to gain recognition and dreams of becoming the Hokage, the village's leader.");
            favAnime.addAnime("Attack on Titan", "2013", "In a world where humanity resides within enormous walled cities to protect themselves from Titans, gigantic humanoid creatures, a young boy named Eren Yeager becomes determined to avenge the death of his mother.");
            favAnime.displayGUI();
        });
    }
}
