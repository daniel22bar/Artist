package artist.request;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Component
public interface RequestManager {
    List<String> topX(String pathToData, int x);
    List<String> artistCommonsWords( String pathToSong1,  String pathToSong2,  int x);

}
