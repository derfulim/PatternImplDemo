package proxy;

import java.util.HashMap;
import java.util.Map;

public class ProxyApp {
    public static void main(String[] args) {
        Employee secretary = new Secretary();
        secretary.doWork(Appeal.PROMOTION);
    }
}

interface Employee {
    void doWork(Appeal appeal);
}

//todo list of employee
class Secretary implements Employee {
    @Override
    public void doWork(Appeal appeal) {
        System.out.println("Secretary takes documents");
        switch (appeal) {
            case SALARY:
                new Accontant().doWork(appeal);
                break;
            case LOGISTIC:
                new HeadOfWareHouse().doWork(appeal);
                break;
            case INSURANCE:
                new Curator().doWork(appeal);
                break;
            case PROMOTION:
                new Director().doWork(appeal);
                break;
        }
        System.out.println("Secretary returns documents");
    }

}

class Accontant implements Employee {
    @Override
    public void doWork(Appeal appeal) {
        System.out.println("Accountant accrues salary");
    }
}

class Director implements Employee {
    @Override
    public void doWork(Appeal appeal) {
        System.out.println("Director gives promotion");
    }
}

class HeadOfWareHouse implements Employee {
    @Override
    public void doWork(Appeal appeal) {
        System.out.println("Head of warehouse provides cargo delivery");
    }
}

class Curator implements Employee {
    @Override
    public void doWork(Appeal appeal) {
        System.out.println("Curator provides employee insurance");
    }
}

enum Appeal {
    SALARY, LOGISTIC, PROMOTION, INSURANCE
}
