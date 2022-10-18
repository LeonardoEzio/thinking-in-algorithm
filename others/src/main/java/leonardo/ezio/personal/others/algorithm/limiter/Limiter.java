package leonardo.ezio.personal.others.algorithm.limiter;

/**
 * @Description : 限流算法接口
 * @Author : LeonardoEzio
 * @Date: 2022-10-18 15:41
 */
public interface Limiter {

    /**
     * 是否限流
     * @name isLimiter
     * @param
     * @return {@link boolean }
     * @date  2022/10/18
     * @author : LeonardoEzio
    **/
    boolean isLimiter();
}
