package view;
import model.*;
import controller.*;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;


public class mainScreenGUI implements UserInterface, ScoreObserver{
    BoardGUI boardGUI;
    ObservableScore score;
    LeaderboardGUI leaderboard;

    public JFrame frame;
    JPanel mainPanel;
    JPanel menuPanel; 
    JLabel logoLabel;
    JLabel scoreImageLabel;
    JLabel scoreLabel;
    JLabel bestScoreImageLabel;
    JLabel bestScoreLabel;
    JLabel goalBanner;
    JButton newGameButton;
    JButton leaderboardButton;
    String best;

    public mainScreenGUI(ObservableScore score, BoardGUI boardGUI, LeaderboardGUI leaderboard){
        this.score = score;
        this.boardGUI = boardGUI;
        this.leaderboard = leaderboard;

        frame = new JFrame("2048");
        frame.setPreferredSize(new Dimension(500, 640));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(250, 248, 239));

        menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBackground(new Color(250, 248, 239));

		URL newPNG = this.getClass().getClassLoader().getResource("NewGame.png");
        
        ImageIcon newGame = new ImageIcon(newPNG);
        Image temp1 = newGame.getImage() ;  
        Image newimg1 = temp1.getScaledInstance(108, 36, java.awt.Image.SCALE_SMOOTH);  
        newGame = new ImageIcon(newimg1);
        newGameButton = new JButton(newGame);
        newGameButton.setBounds(250, 132, 108, 36);
        
        URL leaderboardPNG = this.getClass().getClassLoader().getResource("Leaderboard.png");
        ImageIcon leaderboardIMG = new ImageIcon(leaderboardPNG);
        Image temp2 = leaderboardIMG.getImage() ;  
        Image newimg2 = temp2.getScaledInstance(108, 36, java.awt.Image.SCALE_SMOOTH);  
        leaderboardIMG = new ImageIcon(newimg2);
        leaderboardButton = new JButton(leaderboardIMG);
        leaderboardButton.setBounds(375, 132, 108, 36);
        
        URL logoPNG = this.getClass().getClassLoader().getResource("LogoIcon.png");
        ImageIcon logo = new ImageIcon(logoPNG);
        Image temp3 = logo.getImage() ;  
        Image newimg3 = temp3.getScaledInstance(142, 142, java.awt.Image.SCALE_SMOOTH);
        ImageIcon logoScaled = new ImageIcon(newimg3);
        logoLabel = new JLabel(logoScaled);
        logoLabel.setBounds(18, 18, 142, 142);
        menuPanel.add(logoLabel);
        
        URL scorePNG = this.getClass().getClassLoader().getResource("ScoreIcon.png");
        ImageIcon scoreIcon = new ImageIcon(scorePNG);
        Image temp4 = scoreIcon.getImage() ;  
        Image newimg4 = temp4.getScaledInstance(108, 108, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scoreScaled = new ImageIcon(newimg4);
        scoreImageLabel = new JLabel(scoreScaled);
        scoreImageLabel.setBounds(250, 18, 108, 108);

        scoreLabel = new JLabel(Integer.toString(score.getScore()));
        scoreLabel.setForeground(Color.white);
        scoreLabel.setBounds(303, 66, 80, 30);
        menuPanel.add(scoreLabel);

        menuPanel.add(scoreImageLabel);

        /*
		try {
			File file = new File(getClass().getClassLoader().getResource("scores.txt").getFile());
				
			BufferedReader br = new BufferedReader(new FileReader(file)); 
				
				
			best=br.readLine(); 
		}
		catch (IOException e) {
			e.getMessage();
		}
        */

	
		
        bestScoreLabel = new JLabel(best);
        bestScoreLabel.setForeground(Color.white);
        bestScoreLabel.setBounds(426, 66, 80, 30);
        menuPanel.add(bestScoreLabel);
        
        URL bestScorePNG = this.getClass().getClassLoader().getResource("BestIcon.png");
        ImageIcon bestScoreIcon = new ImageIcon(bestScorePNG);
        Image temp5 = bestScoreIcon.getImage();
        Image newimg5 = temp5.getScaledInstance(108, 108, java.awt.Image.SCALE_SMOOTH);
        ImageIcon bestScaled = new ImageIcon(newimg5);
        bestScoreImageLabel = new JLabel(bestScaled);
        bestScoreImageLabel.setBounds(375, 18, 108, 108);
        menuPanel.add(bestScoreImageLabel);

        goalBanner = new JLabel("Join tiles together to get the 2048 tile!");
        goalBanner.setFont(new Font("Verdona", Font.BOLD, 18));
        goalBanner.setForeground(new Color(74, 72, 64));
        goalBanner.setBounds(53, 185, 400, 20);

        menuPanel.add(newGameButton);
        menuPanel.add(leaderboardButton);
        menuPanel.add(goalBanner);

        menuPanel.setBounds(0, 0, 500, 208);
        mainPanel.add(menuPanel);

        boardGUI.setBounds(53, 208, 392, 392);
        mainPanel.add(boardGUI);

        frame.add(mainPanel);

        frame.pack();
        frame.setVisible(true);
    }

	public void putBestScore(){
		try {
			File file = new File("scores.txt");	
			BufferedReader br = new BufferedReader(new FileReader(file)); 
				
			best = br.readLine(); 
		}catch (IOException e) {
			e.getMessage();
		}
		bestScoreLabel.setText(best);
	}

    @Override
    public void update(Iterator<Integer> scoreIter)
    {
        while(scoreIter.hasNext())
        {
            int score = scoreIter.next();
            scoreLabel.setText(Integer.toString(score));
        }
    }

    public JPanel makeOptionLabel(){
        JPanel optionPanel = new JPanel();

        URL optionPNG = this.getClass().getClassLoader().getResource("PlayAgain.png");
        ImageIcon optionIcon = new ImageIcon(optionPNG);
        Image tempOption = optionIcon.getImage();
        Image newOption = tempOption.getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH);
        ImageIcon optionScaled = new ImageIcon(newOption);
        JLabel optionLabel = new JLabel(optionScaled);
        optionLabel.setBounds(0, 0, 200, 120);

        optionPanel.add(optionLabel);
        return optionPanel;
    }

    public boolean playAgain(){
        int choice = JOptionPane.showConfirmDialog(frame, "You Won! Play again?", "Results", JOptionPane.YES_NO_OPTION);
        //int choice = JOptionPane.showConfirmDialog(null, makeOptionLabel(), "Play Again?", JOptionPane.YES_NO_OPTION);
        return choice == JOptionPane.YES_OPTION;
    }

    public void addOnCloseListener(WindowListener l){
        frame.addWindowListener(l);
    }
    
    public void addNewGameListener(ActionListener l){
        newGameButton.addActionListener(l);
    }

    public void addLeaderboardListener(ActionListener l){
        leaderboardButton.addActionListener(l);
    }

    public void addBackListener(ActionListener l){
        leaderboard.back.addActionListener(l);
    }
}
