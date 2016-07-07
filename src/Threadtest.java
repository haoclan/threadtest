import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/7.
 */
public class Threadtest {

    public static void main(String[] args){
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
                                                        //coresize,maxsize,keepalivvetime,时间单位
    //这里例子是说当5个等待满后，正在执行的线程数量在上升 直到最大值10

        for (int i = 0; i <15 ; i++) {
            Mytask myTask =new Mytask(i);
            executor.execute(myTask);
            System.out.println("线程池中的数量："+executor.getPoolSize()+"   等待执行的数目："+executor.getQueue().size()+"       已经执行的数量："+executor.getCompletedTaskCount() );

        }
        //创建线程当然是异步的了，不然还得执行完那就没有线程的意义了。。
        System.out.println("下面是shutdown");
    executor.shutdown();//这里是等待后才执行
        System.out.println("shutdown完毕");
    }


}

