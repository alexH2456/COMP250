package Assignment4;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.util.Iterator;
import java.util.Random;
/**
 * Class for testing your implementation of the HashTable class.
 */
public class HashTableTester2 {

	/**
	 * Returns a list of songs to use for testing the hash table.
	 * @return A list of songs to use for testing the hash table
	 */
	private static ArrayList<Song> initSongList() {
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(new Song("Le Premier Bonheur du Jour", "Os Mutantes", 1968));
		songs.add(new Song("Stretch Out And Wait", "The Smiths", 1987));
		songs.add(new Song("Scream", "Black Flag", 1984));
		songs.add(new Song("Europe, After the Rain", "Max Richter", 2002));
		songs.add(new Song("Why Are You Looking Grave?", "Mew", 2005));
		songs.add(new Song("Fallen Angel", "King Crimson", 1974));
		return songs;
	}

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		ArrayList<Song> songs = initSongList();

		String csvFile = "C:\\Users\\zizou\\eclipse-workspace\\COMP250\\src\\Assignment4\\Songs.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try 
		{

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] song = line.split(cvsSplitBy);
				songs.add(new Song(song[0],song[1],parseInt(song[2])));
			}

		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if (br != null) 
			{
				try 
				{
					br.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		MyHashTable<String,Song> songTable;
		int numBuckets = 7;
		// Initialize the hash table.   Key will be the song title.

		songTable = new MyHashTable<String,Song>(numBuckets);
		for (Song song: songs) {
			songTable.put(song.getTitle(), song);
		}

		System.out.println("number of songs: " + songTable.size());
		System.out.println("number of buckets in hashtable: " + songTable.getNumBuckets());

		StringBuffer errors = new StringBuffer();		

		songTable.rehash();
		System.out.println("number of songs: " + songTable.size());
		System.out.println("number of buckets in hashtable: " + songTable.getNumBuckets());


		// Try to retrieve a song
		Song testSong1 = songTable.get("Scream");
		System.out.println(testSong1);
		if (testSong1 == null || !testSong1.getArtist().equals("Black Flag") || testSong1.getYear() != 1984) {
			errors.append("Failed to retrieve song 'Scream'.\n");
		}

		@SuppressWarnings("rawtypes")
		Iterator iterator = songTable.iterator();
		while(iterator.hasNext())
		{
			HashNode<String, Song> song;
			song = (HashNode<String, Song>)iterator.next();
			System.out.print(song.getValue() + "\n");
		}

		//   PUT MORE TESTS HERE.

		// Try to remove a song
		int songRemoved =0;
		int numToRemove = 15;
		Random rand = new Random();
		for(int i = 0; i < numToRemove; i++)
		{
			int songToRemove = rand.nextInt(songs.size()-1);
			Song toRemove = songs.remove(songToRemove);

			System.out.print("Song to remove: " + toRemove.getTitle() + "\n");

			Song removedSong = songTable.remove(toRemove.getTitle());
			Song retrievedSong = songTable.get(toRemove.getTitle());
			
			songRemoved++;
			if (removedSong == null || !removedSong.getArtist().equals(toRemove.getArtist())
					|| removedSong.getYear() != toRemove.getYear() || retrievedSong != null) {
				errors.append("Failed to remove song " + toRemove.getTitle() + ".\n");
				System.out.print("Failed to remove song " + toRemove.getTitle() + ".\n");
				songRemoved--;
			}
		}

		System.out.print("Songs Removed: " + songRemoved + "\n");

		iterator = songTable.iterator();
		while(iterator.hasNext())
		{
			HashNode<String, Song> song;
			song = (HashNode<String, Song>)iterator.next();
			System.out.print(song.getValue() + "\n");
		}

		// Display the test results
		System.out.println();
		System.out.println("---------------\nTEST 1 RESULTS:\n---------------\n");
		if (errors.length() == 0) {
			errors.append("All tests passed successfully.");
		}

		System.out.println(errors.toString());
		System.out.println("Number of songs left: " + songTable.size());
		System.out.println(songTable.keys());
		System.out.println(songTable.values());

	}

}
