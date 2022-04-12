import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
 
public class Sound extends Thread {
    
    private URL url;
    private AudioClip sound;
  
    public Sound (String musique) {
        url = this.getClass().getClassLoader().getResource(musique);
        sound = Applet.newAudioClip(url);
    }
     
    public void jouer () {
        sound.play();
    }
     
    public void jouerEnBoucle () {
        sound.loop();
    }
     
    public void arreter () {
        sound.stop();
    }
}
