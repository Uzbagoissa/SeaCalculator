package org.example;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Класс ответственен за создание фонового звукового сопровождения приложения.
 */
public class BackgroundSound {
    /**
     * Метод playSound() создает поток, в котором запускается звуковой трек. Сразу после запуска трека поток "засыпает"
     * на время, приблизительно равное, длине трека. После окончания трека поток "просыпается" и трек запускается вновь.
     */
    public void playSound() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    File soundFile = new File("sounds/snd.wav");
                    FloatControl volumeControl;
                    AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    volumeControl.setValue(-20);
                    clip.start();
                } catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
                    exc.printStackTrace();
                }
                try {
                    Thread.sleep(62000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }
}
