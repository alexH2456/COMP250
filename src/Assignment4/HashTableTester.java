package Assignment4;

import java.util.ArrayList;
/**
 * Class for testing your implementation of the HashTable class.
 */
public class HashTableTester {

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
		songs.add(new Song("20 Minutes", "Lil Uzi Vert", 2017));
		songs.add(new Song("Saint Pablo", "Kanye West", 2016));
		songs.add(new Song("Hit This Hard", "Post Malone", 2016));
		songs.add(new Song("Summer Sixteen", "Drake", 2016));
		songs.add(new Song("Waves", "Joey Bada$$", 2012));
		songs.add(new Song("How Much a Dollar Cost (feat. James Fauntleroy)", "Kendrick Lamar", 2015));
		songs.add(new Song("FEAR.", "Kendrick Lamar", 2017));
		songs.add(new Song("High for This", "The Weeknd", 2014));
		songs.add(new Song("Murder to Excellence", "Jay Z & Kanye West", 2011));
		songs.add(new Song("Through the Wire", "Kanye West", 2003));
		songs.add(new Song("Tuscan Leather", "Drake", 2013));
		songs.add(new Song("Thought It Was a Drought", "Future", 2015));
		return songs;
	}

	public static void main(String[] args) {
		ArrayList<Song> songs = initSongList();
		MyHashTable<String,Song> songTable;
		int numBuckets = 7;
		// Initialize the hash table.   Key will be the song title.

		songTable = new MyHashTable<String,Song>(numBuckets);
		for (Song song: songs) {
			songTable.put(song.getTitle(), song);
		}

		System.out.println("number of songs: " + songTable.size());
		System.out.println("number of buckets in hashtable: " + songTable.getNumBuckets());

		// Try to retrieve a song
		StringBuffer errors = new StringBuffer();
		Song testSong0 = songTable.get("Scream");
		System.out.println(testSong0);
		if (testSong0 == null || !testSong0.getArtist().equals("Black Flag") || testSong0.getYear() != 1984) {
			errors.append("Failed to retrieve song 'Scream'.\n");
		}			
		//  rehashing changes the capacity of the table, but not the number of entries

		//songTable.rehash();
		
		System.out.println("number of songs: " + songTable.size());
		System.out.println("number of buckets in hashtable: " + songTable.getNumBuckets());


		// Try to retrieve a song
		Song testSong1 = songTable.get("Scream");
		System.out.println(testSong1);
		if (testSong1 == null || !testSong1.getArtist().equals("Black Flag") || testSong1.getYear() != 1984) {
			errors.append("Failed to retrieve song 'Scream'.\n");
		}
		
		System.out.println();
		System.out.println("Before removal:");
		System.out.println("number of songs: " + songTable.size());
		System.out.println("number of buckets in hashtable: " + songTable.getNumBuckets());
		System.out.println(songTable.toString());
		
		// Try to remove a song
		Song removedSong = songTable.remove("Fallen Angel");
		Song retrievedSong = songTable.get("Fallen Angel");
		if (removedSong == null || !removedSong.getArtist().equals("King Crimson")
				|| removedSong.getYear() != 1974 || retrievedSong != null) {
			errors.append("Failed to remove song 'Fallen Angel'.\n");
		}
		
		Song removedSong1 = songTable.remove("Europe, After the Rain");
		Song retrievedSong1 = songTable.get("Europe, After the Rain");
		if (removedSong1 == null || !removedSong1.getArtist().equals("Max Richter")
				|| removedSong1.getYear() != 2002 || retrievedSong1 != null) {
			errors.append("Failed to remove song 'Europe, After the Rain'.\n");
		}
		
		Song removedSong2 = songTable.remove("Scream");
		Song retrievedSong2 = songTable.get("Scream");
		if (removedSong2 == null || !removedSong2.getArtist().equals("Black Flag")
				|| removedSong2.getYear() != 1984 || retrievedSong2 != null) {
			errors.append("Failed to remove song 'Scream'.\n");
		}
		
		Song removedSong3 = songTable.remove("Why Are You Looking Grave?");
		Song retrievedSong3 = songTable.get("Why Are You Looking Grave?");
		if (removedSong3 == null || !removedSong3.getArtist().equals("Mew")
				|| removedSong3.getYear() != 2005 || retrievedSong3 != null) {
			errors.append("Failed to remove song 'Why Are You Looking Grave?'.\n");
		}
		
		Song removedSong4 = songTable.remove("Stretch Out And Wait");
		Song retrievedSong4 = songTable.get("Stretch Out And Wait");
		if (removedSong4 == null || !removedSong4.getArtist().equals("The Smiths")
				|| removedSong4.getYear() != 1987 || retrievedSong4 != null) {
			errors.append("Failed to remove song 'Stretch Out And Wait'.\n");
		}
		
		Song removedSong5 = songTable.remove("Le Premier Bonheur du Jour");
		Song retrievedSong5 = songTable.get("Le Premier Bonheur du Jour");
		if (removedSong5 == null || !removedSong5.getArtist().equals("Os Mutantes")
				|| removedSong5.getYear() != 1968 || retrievedSong5 != null) {
			errors.append("Failed to remove song 'Le Premier Bonheur du Jour'.\n");
		}
		
		System.out.println();
		System.out.println("After removal:");
		System.out.println("number of songs: " + songTable.size());
		System.out.println("number of buckets in hashtable: " + songTable.getNumBuckets());
		System.out.println(songTable.toString());

		// Display the test results
		System.out.println("---------------\nTEST 1 RESULTS:\n---------------\n");
		if (errors.length() == 0) {
			errors.append("All tests passed successfully.");
		}
		//System.out.println(songTable.toString());
		System.out.println(errors.toString());
		System.out.println();

	}

}
