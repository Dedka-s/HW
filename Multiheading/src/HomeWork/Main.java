package HomeWork;

public class Main {

    static boolean stop = false;

    public static void main(String[] args) {

        int random = (int)(Math.random()*1000000000);
        System.out.println("Загадали число: "+random);
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = 0;
                    while (!stop) {
                        System.out.println(i);
                        i++;
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {

                }
            }
        });

        Thread myRandom = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stop) {
                    int check = (int)(Math.random()*1000000000);
                    if (check == random) {
                        stop = true;
                        System.out.println("Отгадали число: "+ check);
                    }
                }
            }
        });
        myRandom.start();
        timer.start();

    }
}
