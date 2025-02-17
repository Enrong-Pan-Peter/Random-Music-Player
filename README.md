# Random Musical Waltz Player

## Overview
This project is a Java-based implementation of a musical dice game that generates and plays a random waltz using a selective instrument. The program selects musical fragments using simulated dice rolls and plays them sequentially using the `StdAudio` class.

## Files

### `StdAudio.java`
This class provides audio playback functionality. It allows the program to:
- Play individual audio samples.
- Play entire audio files (WAV, AU, AIFF, MIDI).
- Read and write audio files.
- Play audio files in the background.

### `Waltz.java`
This class manages the composition and playback of randomly generated waltzes. Key features include:
- Defines constants for minuet and trio sequence lengths.
- Uses dice rolls to select musical fragments.
- Supports multiple instruments (`piano`, `clarinet`, `flute-harp`, `mbira`).
- Generates and plays waltzes using `StdAudio.play()`.

## How It Works

### Generating a Waltz
A waltz consists of two parts:
1. **Minuet:** A sequence of 16 randomly chosen minuet fragments.
2. **Trio:** A sequence of 16 randomly chosen trio fragments.

Musical fragments are selected based on dice rolls:
- Minuet fragments are chosen using the sum of two six-sided dice (values 2-12).
- Trio fragments are chosen using a single six-sided die (values 1-6).

### Playing the Waltz
1. The program generates filenames for each musical fragment.
2. It converts filenames to full paths using `toPathname()`.
3. `StdAudio.play()` plays each fragment in sequence.

## Usage

### Compilation
To compile the project, run:
```sh
javac StdAudio.java Waltz.java
```

### Execution
To generate and play a random waltz, run:
```sh
java Waltz
```

### Expected Output
The program will play a randomly selected sequence of minuet and trio fragments, simulating a Mozart-style musical dice game.

## Future Improvements
- Expand the instrument list.
- Support custom user-defined waltz structures.
- Improve randomness for more diverse compositions.

## License
This project is licensed under the MIT License.

## Author
Pan, Enrong