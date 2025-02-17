package a2;

import java.util.Random;

public class Waltz {
	
	/**
	 * The number of precomposed musical fragments making up a minuet
	 * sequence.
	 */
	public static final int MINUET_SEQUENCE_LENGTH = 16;

	/**
	 * The number of precomposed musical fragments making up a trio
	 * sequence.
	 */
	public static final int TRIO_SEQUENCE_LENGTH = 16;
	
	/**
	 * The available instrument recordings. 
	 */
	
	public static final String[] INSTRUMENTS = {
			"clarinet",
			"flute-harp",
			"mbira",
			"piano",
	};

	/**
	 * The random number generator used by this class.
	 */
	public static final Random RNG = new Random();

	/**
	 * Returns the full pathname for the musical fragment specified by
	 * {@code filename}.
	 * 
	 * <p>
	 * For minuets, {@code filename} is assumed to have the form
	 * <i>instrument</i>{@code /minuet}<i>i</i>{@code -}<i>s</i> where
	 * <i>instrument</i> is the name of an instrument found in {@code INSTRUMENTS},
	 * <i>i</i> is the position of the fragment in the sequence, and <i>s</i> is the
	 * sum obtained by rolling two standard 6-sided dice.
	 * 
	 * <p>
	 * For trios, {@code filename} is assumed to have the form
	 * <i>instrument</i>{@code /trio}<i>i</i>{@code -}<i>v</i> where
	 * <i>instrument</i> is the name of an instrument found in {@code INSTRUMENTS},
	 * <i>i</i> is the position of the fragment in the trio and <i>v</i> is the
	 * value obtained by rolling one standard 6-sided dice.
	 * 
	 * @param filename the name of a minuet or trio fragment as specified above
	 * @return the full pathname to the audio file for the fragment
	 */
	public static String toPathname(String filename) {
		return System.getProperty("user.dir") + "/mozart/" + filename + ".wav";
	}

	
	public static int roll(int n) {
		
		int sumRoll = 0;
		
		for (int i = 0; i < n; i++) {
			int diceNum = RNG.nextInt(5) + 1; //get a random number 0-5 and plus 1 to simulate a dice roll
			sumRoll = sumRoll + diceNum;
		}
		
		return sumRoll; 
	}
	

	public static boolean hasInstrument(String instrument) {
		
		for (String instru : INSTRUMENTS) {
			if (instru.equals(instrument)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static String[] makeMinuet(String instrument) {

		if (!hasInstrument(instrument)) {
			throw new IllegalArgumentException("This instrument not in the list.");
		}
		
		String[] minuet = new String[MINUET_SEQUENCE_LENGTH];
		
		for (int i = 0; i < MINUET_SEQUENCE_LENGTH; i++) {
			
			int s = roll(2);
			String tempString = instrument + "/minuet" + i + "-" + s;
			
			minuet[i] = tempString;
		}
		
		return minuet;
	}
	

	public static String[] makeTrio(String instrument) {
		
		if (!hasInstrument(instrument)) {
			throw new IllegalArgumentException("This instrument not in the list.");
		}
		
		String[] trio = new String[TRIO_SEQUENCE_LENGTH];
		
		for (int i = 0; i < TRIO_SEQUENCE_LENGTH; i++) {
			
			int v = roll(1);
			String tempString = instrument + "/trio" + i + "-" + v;
			
			trio[i] = tempString;
		} 
		
		return trio;
	}
	

	public static String[] makeRandomMinuet() {
		
		String[] randMinuet = new String[MINUET_SEQUENCE_LENGTH];
		
		for (int i = 0; i < MINUET_SEQUENCE_LENGTH; i++) {
			
			int s = roll(2); 
			
			int randInt = RNG.nextInt(INSTRUMENTS.length);
			String instrument = INSTRUMENTS[randInt];
			
			String tempString = instrument + "/minuet" + i + "-" + s;
			
			randMinuet[i] = tempString;
		}
		
		return randMinuet;
	}


	public static String[] makeRandomTrio() {
		
		String[] randTrio = new String[TRIO_SEQUENCE_LENGTH];
				
		for (int i = 0; i < TRIO_SEQUENCE_LENGTH; i++) {
			
			int v = roll(1); 
			
			int randInt = RNG.nextInt(INSTRUMENTS.length);
			String instrument = INSTRUMENTS[randInt]; 
			
			String tempString = instrument + "/trio" + i + "-" + v;
			
			randTrio[i] = tempString;
		}
		
		return randTrio;
	}


	/**
	 * Plays a waltz on a piano.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		String[] minuet = Waltz.makeMinuet("piano");
		String[] trio = Waltz.makeTrio("piano");
		
		for (String f : minuet) {
			StdAudio.play(toPathname(f));
		}
		
		for (String f : trio) {
			StdAudio.play(toPathname(f));
		}

	}

}
