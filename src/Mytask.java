/**
 * Created by Administrator on 2016/7/7.
 */
public class Mytask implements Runnable
{
    int number;
    public Mytask(int number)
    {
        this.number=number;
    }

    @Override
    public void run() {
        System.out.println("线程"+number+"开始执行");

        try {
            Thread.currentThread().sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+this.number+"执行完毕");


    }


}
