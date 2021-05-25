package artist.rdd_manager;

import org.apache.spark.api.java.JavaRDD;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RddManager {
    List<String> getTopXFromRdd(JavaRDD<String> song,int x);
}
