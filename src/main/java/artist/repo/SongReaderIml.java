package artist.repo;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Component
public class SongReaderIml implements SongReader {

    @Autowired
    private JavaSparkContext sc;

    @Value("${bad_word}")
    String wordsToFilter;

    public JavaRDD<String> getWordsFromFile(String path){
        return sc.textFile("songs/"+path)
                .map(x->x.replaceAll("[^a-zA-Z']", " "))
                .flatMap(line -> Arrays.asList(line.split(" ")).iterator())
                .filter(x-> !x.equals(""));
    }

    public JavaRDD<String> getSafeSong(String path){
        JavaRDD<String> badWord = getWordsFromFile(wordsToFilter);
        JavaRDD<String> song = getWordsFromFile( path);
        return song.subtract(badWord);
    }

}
