/**
 * Created by Orest on 17.05.2016.
 */

class VisitorApp {
    public static void main(String[] args) {

        Video v = new Video();
        User u = new User(new PlayCommand(v), new PauseCommand(v), new ChangeCommand(v));

        u.playVideo();
        u.pauseVideo();
        u.changeVideo();
    }
}

interface Command {
    void execute();
}
//Reciver
class Video {
    void play(){
        System.out.println("Відтворити");
    }
    void pause(){
        System.out.println("Зупинити");
    }
    void change(){
        System.out.println("Перемкнути");
    }
}
//concrete command 1
class PlayCommand implements Command {
    Video video;
    public PlayCommand (Video video) {this.video=video;}
    public void execute() {
        video.play();
    }
}
//concrete command 2
class PauseCommand implements Command {
    Video video;
    public PauseCommand (Video video) {this.video=video;}
    public void execute() {
        video.pause();
    }
}
//concrete command 3
class ChangeCommand implements Command {
    Video video;
    public ChangeCommand (Video video) {this.video=video;}
    public void execute() {
        video.change();
    }
}
//invoker
class User {
    Command play;
    Command pause;
    Command change;

    public User (Command play, Command pause, Command change){
        this.play = play;
        this.pause = pause;
        this.change = change;
    }

    void playVideo() {
        play.execute();
    }
    void pauseVideo() {
        pause.execute();
    }
    void changeVideo() {
        change.execute();
    }
}









