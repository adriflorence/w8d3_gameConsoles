import db.DBConsole;
import db.DBGame;
import db.DBHelper;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Game game1 = new Game("Street Fighter", Genre.ARCADE);
        DBHelper.save(game1);
        Game game2 = new Game("Counter Strike", Genre.FPS);
        DBHelper.save(game2);
        Game game3 = new Game("Final Fantasy", Genre.RPG);
        DBHelper.save(game3);
        Game game4 = new Game("Heroes of The Storm", Genre.ARTS);
        DBHelper.save(game4);

        Console console1 = new Console("Sony", "PS4", Region.PAL);
        Console console2 = new Console("Microsoft", "???", Region.PAL);

        DBGame.addGameToConsole(game1, console1);
        DBGame.addGameToConsole(game2, console1);
        DBGame.addGameToConsole(game2, console2);
        DBGame.addGameToConsole(game3, console2);
        DBGame.addGameToConsole(game4, console2);

        List<Game> gamesForConsole = DBConsole.getGamesOfConsole(console1);
        List<Console> consolesForGame = DBGame.getConsolesOfGame(game4);

        Owner owner1 = new Owner("Dani", game4);
        Owner owner2 = new Owner("Campbell", game1);
        Owner owner3 = new Owner("Adam", game2);
        DBHelper.save(owner1);
        DBHelper.save(owner2);
        DBHelper.save(owner3);

// when owner is not instantiated with favourite game:
//        DBGame.addFanToGame(owner2, game1);
//        DBOwner.addFavouriteToOwner(game1, owner2);

        List<Owner> streetFighterFans = DBGame.getFansForGame(game1);
        List<Owner> game2fans = DBGame.getFansForGame(game2);

    }
}
