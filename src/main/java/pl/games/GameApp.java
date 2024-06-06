package pl.games;

import pl.games.lotto.LottoGame;
import pl.games.lotto.NumbersGenerator;
import pl.games.lotto.UserNumbers;


public class GameApp {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new NumbersGenerator(), new UserNumbers());
        lottoGame.play();
    }
}
