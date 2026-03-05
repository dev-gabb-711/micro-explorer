import javax.sound.sampled.*;

public class BackgroundMusic {
    private Clip clip;

    public BackgroundMusic(String resourcePath) {
        try {
            // Load music from resources
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(
                    getClass().getResource(resourcePath)
            );
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playLoop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void close() {
        if (clip != null) {
            clip.close();
        }
    }
}
