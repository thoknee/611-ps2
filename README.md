This is a terminal based simple game engine made completely in java. The high level idea is to create a game engine that is easily extendable to add other games - especially those based on a grid system like the two games currently implemented.

Currently, this game engine has 2 games.
- Sliding puzzle
- Dots and boxes

Sliding puzzle is an old school puzzle you have probably played at least once in your life. It is a one player game where the objective is to fix the numbers in chronological order being able to move them one at a time through an empty space.

Dots and boxes is a 2 player game where you face off against an opponent. The game starts with an array of dots of which every turn you can connect with a line. Upon completing an entire box with 4 lines you get 1 point and the player with more points wins.

To use this game engine it is quite simple. Open a terminal and navigate to the directory in which the files exist. From there, you need to compile the Main.java as so:

```javac Main.java```

Upon finishing compilation, you can then simply run the code using the following command:

```java Main```

Upon running it with this command you should be prompted with an introduction and all the information you need to be able to play either game. Have fun playing!


Some info and online resources we used in creating this:

adding color to console source: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println