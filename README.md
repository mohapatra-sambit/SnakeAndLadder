# Snake And Ladder

1. This is a simple, command-line based snake & ladder game that I wrote to demonstrate the basic OOPs concepts and how a typical project code base has to be structured.

2. The only input that the user is asked for is the number of players for the game. The game is a self-driven one.

3. The placement of Snakes and that of Ladders are configurable in a text file which is present in the rules folder.
   
   - The rules are defined in the following structure:
     
     *source*,*destination*
   
   - If source < destination, it's a Ladder, otherwise Snake.

4. Invalid rules are ignored.

5. Main program: `com.snl.main.SnLMain`.