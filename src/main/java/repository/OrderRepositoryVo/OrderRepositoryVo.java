package repository.OrderRepositoryVo;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class OrderRepositoryVo {

    public void save(String itemId) throws InterruptedException {
        if (itemId.equals("ex")){
            throw new IllegalArgumentException("FF");
        }
        sleep(1000);
    }

    public void sleep(int mile){
        try {
            Thread.sleep(mile);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

