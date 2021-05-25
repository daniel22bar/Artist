package artist.request;

import artist.rdd_manager.RddManager;
import artist.repo.SongReader;
import artist.repo.SongReaderIml;
import artist.request.RequestManager;
import org.apache.spark.api.java.JavaRDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RequestManagerIml implements RequestManager {


    @Autowired
    private SongReader songReader;

    @Autowired
    private RddManager rddManager;

    @Override
    public List<String> topX(String pathToData, int x) {
        JavaRDD<String> song = songReader.getSafeSong(pathToData);
        return rddManager.getTopXFromRdd(song,x);
    }

    @Override
    public List<String> artistCommonsWords(String pathToSong1, String pathToSong2, int x) {
        List<String> song1 = topX(pathToSong1,x);
        List<String> song2 = topX(pathToSong2,x);
        song1.retainAll(song2);
        return song1;
    }
}
