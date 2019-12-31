package cn.net.nigel.concurrent;

public class SynchronizedExample1 implements Runnable {

    private Integer ticketNumber;
    private final Integer finalTicketNumber = 0;

    public SynchronizedExample1() {
        this.ticketNumber = 10;
    }

    void buy_ticket_1() {
        synchronized (ticketNumber) {
//            if (ticketNumber > 0) {
                ticketNumber = ticketNumber - 1;
                System.out.println(Thread.currentThread().getName() + "---->" + ticketNumber);
//            }
        }
    }

    void buy_ticket_2() {
        if (ticketNumber > 0) {
            synchronized (finalTicketNumber) {
                ticketNumber = ticketNumber - 1;
                System.out.println(Thread.currentThread().getName() + "---->" + ticketNumber);
            }
        }
    }

    @Override
    public void run() {
        for (int times = 1; times <= 10; times ++) {
            // 请求，网络延迟500ms
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticketNumber <= 0) break;
            // 抢票
            buy_ticket_1();
//            buy_ticket_2();
        }
        System.out.println("final---->" + Thread.currentThread().getName() + "---->" + ticketNumber);
    }

    public static void main(String[] args) {
        SynchronizedExample1 ex1 = new SynchronizedExample1();
        new Thread(ex1, "码农").start();
        new Thread(ex1, "码畜").start();
        new Thread(ex1, "码蝗").start();
    }

}
