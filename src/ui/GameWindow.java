package ui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.GameModel;

public class GameWindow {
	public static final int WIDTH = 500; 
	public static final int HEIGHT = 535;
	private static CardLayout cl;
	private static JPanel cards;
	private static GameComponent game;
	private static GameModel model = new GameModel();

	public static void show() {
		
		// Minimal model instance (empty for now, by design)
		
		cards = new JPanel(new CardLayout());
		StartPanel start = new StartPanel();
		GameOverPanel gameOver = new GameOverPanel();
		model = new GameModel();
		cl = (CardLayout) cards.getLayout();
		
		game = new GameComponent(model, new GameWindow());

		JFrame frame = new JFrame("CSSE220 Team Underscore Final Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.setContentPane(cards);
		
		cards.add(start, "START");
		cards.add(gameOver, "GAMEOVER");
		cards.add(game, "GAME");
		
		start.getStartButton().addActionListener(e -> {
		    game.startGame();
		    
		    cl.show(cards, "GAME");
		});
		
		gameOver.getRestartButton().addActionListener(e -> {
			game = new GameComponent(model, new GameWindow());
			cards.remove(2);
			cards.add(game, "GAME");
			game.startGame();
		    cl.show(cards, "GAME");
		});
		
		gameOver.getExitButton().addActionListener(e -> {
		    System.exit(0);
		});
		
		cl.show(cards, "START");

		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null); // center on screen (nice UX, still minimal)
		frame.setVisible(true);
		}
	
	public static void gameOver() {
		cl.show(cards, "GAMEOVER");
	}

}
