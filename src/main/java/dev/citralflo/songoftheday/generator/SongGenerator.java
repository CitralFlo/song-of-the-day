package dev.citralflo.songoftheday.generator;

import dev.citralflo.songoftheday.Song;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.File;

@Component
public class SongGenerator {

    ObjectMapper objectMapper = new ObjectMapper();

    JsonNode jsonNode;

    {
        try {
            jsonNode = objectMapper.readTree(new File("src/main/java/dev/citralflo/songoftheday/generator/SongLinks.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Song generateSong() {

        JsonNode songs = jsonNode.get("songs");
        JsonNode songNode = songs.get((int) (Math.random() * songs.size()));
        return new Song(songNode.get("title").asText(), songNode.get("author").asText());
    }
}
