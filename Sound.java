import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sound {
	

	public static Sound music = loadSound("/sounds/music.wav");
	

	public static Sound invaderkilled = loadSound("/sounds/invaderkilled.wav");
	

	public static Sound shoot = loadSound("/sounds/shoot.wav");
	

	public static Sound explosion = loadSound("/sounds/explosion.wav");
	

	public static Sound currentMusic;
	

	private Clip clip;
	

	public static Sound loadSound(String fileName) {
		Sound sound = new Sound();
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(Sound.class.getResource(fileName));
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			sound.clip = clip;
		} catch (Exception e) {
			System.out.println(e);
		}
		return sound;
	}


	public void play() {
		try {
			if (clip != null) {	
				clip.stop();
				clip.setFramePosition(0);
				clip.start();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

	public void stop(){
		clip.stop();
	}
	
	private boolean isFinish(){
		if (clip.getFrameLength() - clip.getFramePosition() < 1){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void setCurrentMusic(Sound s){
		if (Sound.currentMusic != null){
			if (Sound.currentMusic == s){
				if (Sound.currentMusic.isFinish()){
					Sound.currentMusic.play();
				}
			}
			else {
				Sound.currentMusic.stop();
				Sound.currentMusic = null;
			}
		}	

		if (Sound.currentMusic==null){
			Sound.currentMusic = s;
			Sound.currentMusic.play();
		}
		
	}
	
	
	
}