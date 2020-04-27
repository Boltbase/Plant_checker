package plant_checker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Plants {

	private JFrame frame;
	private JTextField NatureBonus;
	private JTextField IntBonus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plants window = new Plants();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Plants() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param <E>
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 318, 269);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Plant checker");
		Random randomizer = new Random();
		
		JLabel NatureLabel = new JLabel("Nature bonus is");
		NatureLabel.setBounds(10, 13, 99, 29);
		frame.getContentPane().add(NatureLabel);
		
		NatureBonus = new JTextField();
		NatureBonus.setBounds(152, 15, 124, 25);
		frame.getContentPane().add(NatureBonus);
		NatureBonus.setColumns(10);
		
		JLabel IntLabel = new JLabel("Int bonus is");
		IntLabel.setBounds(10, 53, 84, 26);
		frame.getContentPane().add(IntLabel);
		
		IntBonus = new JTextField();
		IntBonus.setBounds(152, 51, 124, 28);
		frame.getContentPane().add(IntBonus);
		IntBonus.setColumns(10);
		
		String[] terrain_array = {"Arctic/Cold", "Caves", "Arid/Desert", "Forest", "Lakes, Rivers and Ocean", "Mountains", "Plains", "Swamps"};

		JLabel TerrainLabel = new JLabel("Current Terrain");
		TerrainLabel.setBounds(10, 90, 99, 29);
		frame.getContentPane().add(TerrainLabel);
		
		JComboBox<Object> terrainComboBox = new JComboBox<>(terrain_array);
		terrainComboBox.setBounds(152, 90, 124, 29);
		frame.getContentPane().add(terrainComboBox);
		
		JButton CheckButton = new JButton("Search for plants");
		CheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String plant = null;
				int HowMany = 0;
				int DCroll = randomizer.nextInt(20) + 1;
				try {
					int NatureBonusInt = Integer.parseInt(NatureBonus.getText());
					int IntBonusInt = Integer.parseInt(IntBonus.getText());
					int DC = DCroll + NatureBonusInt;
					if (DC >= 15) {
						String current_terrain = (String)terrainComboBox.getSelectedItem();
						if (current_terrain == "Arctic/Cold") {
							ArrayList<String> ArcticCold = new ArrayList<String> (Arrays.asList("Aniseed sap", "Ghostly snowdrop", "Kreet paste", "Kreet paste", "Spineflower berries", "White poppy", "Winter turtlehead", "Yeti's Parsley"));
							plant = ArcticCold.get(randomizer.nextInt(ArcticCold.size()));}
						else if (current_terrain == "Caves") {
							ArrayList<String> Caves = new ArrayList<String> (Arrays.asList("Abyss flower", "Banshee's lament", "Eberium fungus", "Glowing duscle", "Nightshade", "Viper thistle"));
							plant = Caves.get(randomizer.nextInt(Caves.size()));}
						else if (current_terrain == "Arid/Desert") {
							ArrayList<String> AridDesert = new ArrayList<String> (Arrays.asList("Crimson brittlebush", "Dried ephedra", "Ellond shrub", "Iron thistle", "Twilight wormwood", "Wizard's clover"));
							plant = AridDesert.get(randomizer.nextInt(AridDesert.size()));}
						else if (current_terrain == "Forest") {
							ArrayList<String> Forest = new ArrayList<String> (Arrays.asList("Ash chives", "Blue cress", "Drojos ivy", "Kasuni juice", "Olina petals", "Thunderleaf"));
							plant = Forest.get(randomizer.nextInt(Forest.size()));}
						else if (current_terrain == "Lakes, Rivers and Ocean") {
							ArrayList<String> LakesRiversOcean = new ArrayList<String> (Arrays.asList("Blue seaweed", "Chromatic mud", "Golden coneflower", "Healer's boon", "Mermaid braid", "Sime thimbleberry"));
							plant = LakesRiversOcean.get(randomizer.nextInt(LakesRiversOcean.size()));}
						else if (current_terrain == "Mountains") {
							ArrayList<String> Mountains = new ArrayList<String> (Arrays.asList("Angel flower", "Golden hibiscus", "Lunar nectar", "Storm daisy", "Storm daisy", "Sugar hibiscus berries", "Tempest flower", "Wolf hair"));
							plant = Mountains.get(randomizer.nextInt(Mountains.size()));}
						else if (current_terrain == "Plains") {
							ArrayList<String> Plains = new ArrayList<String> (Arrays.asList("Blood herb", "Dragontongue petals", "Dusk itchweed", "Gray gilliflower", "Madrake root", "Raven silkweed", "Ucre bramble", "Ucre bramble"));
							plant = Plains.get(randomizer.nextInt(Plains.size()));}
						else if (current_terrain == "Swamps") {
							ArrayList<String> Swamps = new ArrayList<String> (Arrays.asList("Blackleaf rose", "Bone garlic", "Ecire laurel", "Frenn moss", "Goblin mud", "Wisp stems"));
							plant = Swamps.get(randomizer.nextInt(Swamps.size()));}
					
					HowMany = randomizer.nextInt(4) + IntBonusInt;
					JOptionPane.showMessageDialog(null, "Found " + HowMany + " " + plant + " (Rolled a " + DCroll + ", total score was " + DC + ")");
				} else {
					JOptionPane.showMessageDialog(null, "Couldn't find any plants (Rolled a " + DCroll + ", total score was " + DC + ")");
				}}	
					catch(Exception error) {
					JOptionPane.showMessageDialog(null, "Please enter valid numbers into both Nature bonus and Int bonus");
					}}});
		
		CheckButton.setBounds(82, 161, 134, 23);
		frame.getContentPane().add(CheckButton);
	}
}
