package dev.citralflo.songoftheday;

import dev.citralflo.songoftheday.generator.SongGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SongOfTheDayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongOfTheDayApplication.class, args);

		SongGenerator songGenerator = new SongGenerator();
		Song song = songGenerator.generateSong();
		System.out.println("Today's song of the day is: " + song.getTitle() + " by " + song.getArtist());
	}

}
