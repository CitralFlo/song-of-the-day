package dev.citralflo.songoftheday.controllers;

import dev.citralflo.songoftheday.Song;
import dev.citralflo.songoftheday.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @RequestMapping({"", "/", "/index"})
    public String showSong(Model model) {

        Song song = this.songService.getSong();

        model.addAttribute("title", song.getTitle());
        model.addAttribute("artist", song.getArtist());

        String spotifySearchUrl = "https://open.spotify.com/search/" +
                song.getTitle().replace(" ", "%20") + "%20" + song.getArtist().replace(" ", "%20");

        model.addAttribute("spotifySearchUrl", spotifySearchUrl);

        return "index";
    }

}
