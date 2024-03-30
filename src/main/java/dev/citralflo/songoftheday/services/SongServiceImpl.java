package dev.citralflo.songoftheday.services;

import dev.citralflo.songoftheday.Song;
import dev.citralflo.songoftheday.generator.SongGenerator;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {

    private final SongGenerator songGenerator;

    public SongServiceImpl(SongGenerator songGenerator) {
        this.songGenerator = songGenerator;
    }

    @Override
    public Song getSong() {
        return this.songGenerator.generateSong();
    }
}
