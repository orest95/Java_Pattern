/**
 * Created by Orest on 19.04.2016.
 */
public class StateApp {
    public static void main(String[] args) {

        ChanelState chanel_112 = new Chanel_112();
        Television television = new Television();
        television.setChanelState(chanel_112);

        for (int i = 0; i < 10; i++) {
            television.play();
            television.nextChanel();
        }

    }
}

interface ChanelState {
    void play();
}

class One_plus_on implements ChanelState {
    @Override
    public void play() {
        System.out.println("телеканал 1+1");
    }
}

class Chanel_24 implements ChanelState {
    @Override
    public void play() {
        System.out.println("телеканал новин 24");
    }
}

class Chanel_112 implements ChanelState {
    @Override
    public void play() {
        System.out.println("телеканал 112 Україна");
    }
}

class Television {
    ChanelState chanelState;

    void setChanelState(ChanelState st) {
        chanelState = st;
    }

    void nextChanel() {
        if (chanelState instanceof One_plus_on) {
            setChanelState(new Chanel_112());
        } else if (chanelState instanceof Chanel_112) {
            setChanelState(new Chanel_24());
        } else if (chanelState instanceof Chanel_24) {
            setChanelState(new One_plus_on());
        }
    }

    void play() {
        chanelState.play();
    }
}