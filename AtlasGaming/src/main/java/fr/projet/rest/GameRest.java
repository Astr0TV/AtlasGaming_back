package fr.projet.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.projet.entities.Game;
import fr.projet.repository.GameRepository;

@RestController
@RequestMapping("/api/games")
public class GameRest {
	
	@Autowired
    private GameRepository gameRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String RAWG_API_URL = "https://api.rawg.io/api/games";
    private static final String RAWG_API_KEY = "4f5334c3f51246499bfcf8d6aa5f40e5"; 

    @GetMapping("/fill")
    public String fillGamesFromRawg() {
        String url = RAWG_API_URL + "?dates=2019-09-01,2019-09-30&platforms=18,1,7&key=" + RAWG_API_KEY;
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }


    @GetMapping
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found with id " + id));
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable Long id, @RequestBody Game gameDetails) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found with id " + id));

        game.setTitle(gameDetails.getTitle());
        game.setDescription(gameDetails.getDescription());
        game.setRating(gameDetails.getRating());

        return gameRepository.save(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found with id " + id));

        gameRepository.delete(game);
    }
}

