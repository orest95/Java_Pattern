/**
 * Created by Orest on 17.05.2016.
 */
public class ChainOfResponsibilityApp {
    public static void main(String[] args) {
        Telekanal near = new NearTransporter(10);
        Telekanal full = new FullTransporter(60);
        near.setNext(full);

        near.loadCargo(8);
        full.loadCargo(40);
        near.loadCargo(40);
    }
}

 abstract class Telekanal {
    int time;
     Telekanal next;

    public void setNext(Telekanal next) {
        this.next = next;
    }

    public Telekanal(int time) {
        this.time = time;
    }

    public void loadCargo(int weight) {
        if(weight<=time){
            System.out.println("Реклама коротка, показ на телеканалі 24");
        } else {
            System.out.println("Реклама довга, перенесено на канал 1+1");
            if(next!=null){
                next.loadCargo(weight);
            }
        }
    }
}

 class FullTransporter extends Telekanal {
    public FullTransporter(int time) {
        super(time);
    }
}

class NearTransporter extends Telekanal{
    public NearTransporter(int time) {
        super(time);
    }
}

