package com.easy.mes.analysis.handler;

import java.util.concurrent.*;

/**
 * @author zhaohan
 */

public class ThreadPool {

    private static ExecutorService pool = new ThreadPoolExecutor(30, 100,
            20L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(),new MyThreadFactory());

    public static String[] distribute(Callable task){

        Future future=pool.submit(task);
        String[] json=null;

        shut:for (;;){
            if (future.isDone()){
                try {
                    json=(String[]) future.get();
                    break shut;
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                continue shut;
            }
        }
        return json;
    }

}

