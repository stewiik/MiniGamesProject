package pl.games;

import pl.games.lotto.LottoGame;
import pl.games.lotto.NumbersGenerator;
import pl.games.lotto.UserNumbers;

import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LottoGame lottoGame = new LottoGame(new NumbersGenerator(), new UserNumbers(scanner));
        lottoGame.play();
    }
}
