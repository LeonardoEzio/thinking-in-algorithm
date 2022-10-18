package leonardo.ezio.personal.others.algorithm.limiter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description :
 * @Author : LeonardoEzio
 * @Date: 2022-10-18 15:43
 */
public class CounterLimiter implements Limiter{

    /**
     * 限流大小
     * */
    private int limiter;

    /**
     * 限流时间窗口大小
     * */
    private long timeRange;

    /**
     * 限流开始时间
     * */
    private long startTime;

    /**
     * 初始计数器
     * */
    private AtomicInteger INIT_COUNTER = new AtomicInteger(0);

    /**
     * 请求计数器
     * */
    private AtomicInteger REQUEST_COUNTER = INIT_COUNTER;

    private CounterLimiter counterLimiter;

    private CounterLimiter(int limiter, long timeRange) {
        this.limiter = limiter;
        this.timeRange = timeRange;
        this.startTime = System.currentTimeMillis();
    }

    public CounterLimiter getLimiter(int limiter, long timeRange){
        if (counterLimiter == null){
            synchronized (this){
                if (counterLimiter == null){
                    counterLimiter = new CounterLimiter(limiter, timeRange);
                }
            }
        }
        return counterLimiter;
    }

    @Override
    public boolean isLimiter() {
        long now = System.currentTimeMillis();

        if (now <= startTime + timeRange){
            if (REQUEST_COUNTER.get() < limiter){
                REQUEST_COUNTER.incrementAndGet();
                return false;
            }
            return true;
        }
        //重置时间以及计数器
        startTime = now;
        REQUEST_COUNTER = INIT_COUNTER;
        return true;
    }
}
