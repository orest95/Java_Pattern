/**
 * Created by Orest on 17.05.2016.
 */
public class VisitorsApp {
    public static void main(String[] args) {

        Element element24 = new ElementReklama24();
        Element element112 = new ElementReklama112();

        Visitor viewer1 = new ConcreteUserOne();
        Visitor viewer2 = new ConcreteUserTwo();

        element24.accept(viewer1);
        element24.accept(viewer2);

    }
}



interface Visitor {
    void visit(ElementReklama24 element24);
    void visit(ElementReklama112 element112);
}

interface Element {
    void accept(Visitor visitor);
}



class ElementReklama24 implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class ElementReklama112 implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}



class ConcreteUserOne implements Visitor {
    @Override
    public void visit(ElementReklama24 element24) {
        System.out.println("Перший подивився рекламу на каналі 24");
    }

    @Override
    public void visit(ElementReklama112 element112) {
        System.out.println("Перший перемкнув канал новин 112 Україна");
    }
}

class ConcreteUserTwo implements Visitor {
    @Override
    public void visit(ElementReklama24 element24) {
        System.out.println("Другий виключив канал 24");
    }

    @Override
    public void visit(ElementReklama112 element112) {
        System.out.println("Другий дивиться канал новин 112");
    }
}