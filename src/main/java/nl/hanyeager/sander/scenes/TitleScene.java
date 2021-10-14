package nl.hanyeager.sander.scenes;

import com.github.hanyaeger.api.scenes.StaticScene;

public class TitleScene extends StaticScene {

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/CyberPunk2077Music.mp3");
        setBackgroundImage("backgrounds/CyberPunkMenu.jpg");
    }

    @Override
    public void setupEntities() {

    }
}
