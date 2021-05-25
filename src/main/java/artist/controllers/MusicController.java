package artist.controllers;

import artist.request.RequestManagerIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/api")
public class MusicController {

    @Autowired
    private RequestManagerIml requestManager;



    @GetMapping("/MusicController/{pathToData}/{x}")
    public List<String> topX(@PathVariable String pathToData, @PathVariable int x) {

        return requestManager.topX(pathToData,x);
    }

    @GetMapping("/MusicController/{pathToSong1}/{pathToSong2}/{x}")
    public List<String> artistsCommonsWords(@PathVariable String pathToSong1,@PathVariable String pathToSong2, @PathVariable int x) {
       return requestManager.artistCommonsWords(pathToSong1,pathToSong2,x);

    }




}
