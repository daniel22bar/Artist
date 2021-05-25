package artist.rdd_manager;

import org.apache.spark.api.java.JavaRDD;
import org.springframework.stereotype.Component;
import scala.Tuple2;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RddManagerImp implements RddManager{
    @Override
    public List<String> getTopXFromRdd(JavaRDD<String> song,int x) {
        return   song.mapToPair(s -> new Tuple2<>(s, 1))
                .reduceByKey(Integer::sum)
                .mapToPair(Tuple2::swap)
                .sortByKey(false)
                .map(Tuple2::swap)
                .take(x)
                .stream()
                .map(z -> z._1)
                .collect(Collectors.toList());
    }
}
