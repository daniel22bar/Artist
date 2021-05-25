package artist.repo;

import org.apache.spark.api.java.JavaRDD;
import org.springframework.stereotype.Component;

@Component
public interface SongReader {

     JavaRDD<String> getWordsFromFile(String path);
     JavaRDD<String> getSafeSong(String path);

}
