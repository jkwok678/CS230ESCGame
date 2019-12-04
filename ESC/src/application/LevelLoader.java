package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/*
 * TextFile Structure
 * First 2 Lines is size of map
 * Second 2 is Player start location
 * third 3 StraightLineEnemy location followed by 1,2,3,4 as up,down,right,left
 *
 */
public class LevelLoader {
	//Method to get Size of map
	public static int[] getSize(String file) {
		try {
			File f = new File(file);
			Scanner in = new Scanner(f);
			int[] size = new int[2];
			int x = in.nextInt();
			int y = in.nextInt();
			size[0] = x;
			size[1] = y;
			in.close();
			return size;
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}
	}
	//Method to Player start location
	public static int[] getPlayerStart(String file) {
		try {
			File f = new File(file);
			Scanner in = new Scanner(f);
			int[] start = new int[2];
			in.nextLine();
			in.nextLine();
			int x = in.nextInt();
			int y = in.nextInt();
			start[0] = x;
			start[1] = y;
			in.close();
			return start;
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}
	}
	//Method to get StraightEnemy start location
	public static int[] getStraightEnemy(String file) {
		try {
			File f = new File(file);
			Scanner in = new Scanner(f);
			for (int i=0; i<4;i++) {
				in.nextLine();
			}
			int[] info = new int[3];
			int x = in.nextInt();// get startX
			int y = in.nextInt();//get startY
			int z = in.nextInt();// get directionfacing
			info[0] = x;
			info[1] = y;
			info[2] = z;
			in.close();
			return info;

		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}
	}
	//Method to get wallfollowing enemy start location
	/*
	public static int[] getWallFollowingEnemy(String file) {
		try {
			File f = new File(file);
			Scanner in = new Scanner(f);

			*Might need to change this loop*

			for (int i=0; i<4;i++) {
				in.nextLine();
			}

			int[] info = new int[3];
			int x = in.nextInt();// get startX
			int y = in.nextInt();//get startY
			int z = in.nextInt();// get directionfacing
			info[0] = x;
			info[1] = y;
			info[2] = z;
			in.close();
			return info;

		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}
	}
	*/





	// Load file
	public static Cell[][] loadLevel(String file) {
		try {
			File f = new File(file);
			Scanner in = new Scanner(f);
			int x = in.nextInt();
			int y = in.nextInt();
			for (int i=0;i<6;i++) {
				in.nextLine();

			}
			Cell[][] level = new Cell[x][y];
			for (int newY = 0; newY < y; newY++) {
				String s = in.nextLine();
				for (int newX = 0; newX < x; newX++) {
					if (s.charAt(newX) == '#') {
						level[newX][newY] = new Wall("wall", false,false, newX, newY);
					} else if (s.charAt(newX) == 'G') {
						level[newX][newY] = new Goal("goal", true,false, newX, newY);
					} else if (s.charAt(newX) == 'W') {
						level[newX][newY] = new Water("water", false,false, newX, newY);
					} else if (s.charAt(newX) == 'F') {
						level[newX][newY] = new Fire("fire", false,false, newX, newY);
					} else if (s.charAt(newX) == 'R') {
						level[newX][newY] = new Door("red door", false,false, newX, newY);
					} else if (s.charAt(newX) == 'B') {
						level[newX][newY] = new Door("blue door", false,false, newX, newY);
					} else if (s.charAt(newX) == 'D') {
						level[newX][newY] = new Door("green door", false,false, newX, newY);
					} else if (s.charAt(newX) == 'A') {
						level[newX][newY] = new Key("red", true,false, newX, newY);
					} else if (s.charAt(newX) == 'C') {
						level[newX][newY] = new Key("blue", true,false, newX, newY);
					} else if (s.charAt(newX) == 'E') {
						level[newX][newY] = new Key("green", true,false, newX, newY);
					}  else if (s.charAt(newX) == 'H') {
						level[newX][newY] = new Boot("boots", true,false, newX, newY);
					} else if (s.charAt(newX) == 'I') {
						level[newX][newY] = new Flipper("flippers", true,false, newX, newY);
					} else if (s.charAt(newX) == 'T') {
						level[newX][newY] = new Token("token", true,false, newX, newY);
					} else if (s.charAt(newX) == 'U') {
						level[newX][newY] = new TokenDoor("tokenDoor", false,false, newX, newY);
						//Add new Cells here, new Cells created through this
						// A redKey, B bluedoor, C bluekey, D greendoor, E greenkey, F fire, G goal, H Boots, I Flipper, R redDoor,T Token, U Token Door, W Water,   Cell , #  Wall
						// Flipper, Boots, Token, Token door
					} else if (s.charAt(newX) == ' ') {
						level[newX][newY] = new Cell("Cell", true,true, newX, newY);

					}
				}
			}

			in.close();
			return level;
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}
	}

}