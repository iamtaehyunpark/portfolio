import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * Name: Taehyun Park
 *
 */
public class SpellCheck<K, V> {
	final String path = "dictionary.txt";
	Table tab = new Table<String, String>(99999);

	public SpellCheck() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				// 'line' is a valid word
				tab.addTable(line);
			}
			br.close();
		} catch (Exception e) {
			System.err.println("File error: " + e.getMessage());
			System.exit(-1);
		}
	}

	/*
	 * The length of the return array should be the same as the number of words in
	 * 'sentence'.
	 * The i-th element of the return array is the substitute candidate for the i-th
	 * word in the sentence.
	 * If the i-th word is a valid word (i.e., not a typo), then the array should be
	 * empty.
	 */

	 //This will splice sentences into words and check if the word is in the dictionary.
	 //If not, it will modify the word with four different cases that can occur an typo and then check the modified word in the dictionary again.
	 //All the words in the dictionary will be added in the hash hashtable structure(more like hash set since the key and value values are the same).
	 //Certain word's index is determined as its hashcode() value.
	 //If other words already exist in the same index of the hashtable array, use chaining and place the word next to the existing word (similar to the list structure).
	
	 //Time complexity of this method will be linear in the best case(O(n) where n is the number of words in the sentence)
	 // since there's only one operation to check if it is valid for each word and the checking operation in hash table structure is nearly O(1).
	 //In the worst case, there are moderating operations that takes O(n) where n is number of the characters for each word, and they are repeated for the number of words.
	 //Therefore the time complexity is quadratic.
	public ArrayList<String>[] spellCheck(String sentence) {
		String[] words = sentence.split("\\s"); // 'words' is the list of words in 'sentence'
		ArrayList<String>[] outee = new ArrayList[words.length]; //output
		for (int i = 0; i < words.length; i++) {

			String checking = words[i].toLowerCase();
			if (checkInDict(checking)) //if checking word is valid, just add null to the output array
				outee[i] = null;
			else {
				ArrayList<String> out = new ArrayList<String>(0);
				// check four cases of the error
				// case 1
				for (int j = 0; j < checking.length(); j++) {
					String replacing = checking.substring(0, j) + checking.substring(j + 1);
					if (checkInDict(replacing)) { // if modified word is valid, add it into the candidates arraylist
						if (out.contains(replacing)) //if the same candidate exist in arraylist, just dismiss
							continue;
						out.add(replacing);
					}
				}

				// case 2
				for (int j = 97; j < 123; j++) {
					for (int k = 0; k <= checking.length(); k++) {
						String replacing = checking.substring(0, k) + (char) j + checking.substring(k);
						if (checkInDict(replacing)) {
							if (out.contains(replacing))
								continue;
							out.add(replacing);
						}
					}
				}

				// case 3
				for (int j = 97; j < 123; j++) {
					for (int k = 0; k < checking.length(); k++) {
						String replacing = checking.substring(0, k) + (char) j + checking.substring(k + 1);
						if (checkInDict(replacing)) {
							if (out.contains(replacing))
								continue;
							out.add(replacing);
						}
					}
				}

				// case 4
				for (int j = 0; j < checking.length()-1; j++) {
						char fow = checking.charAt(j);
						char beh = checking.charAt(j+1);
						String replacing = checking.substring(0, j) + beh + fow + checking.substring(j + 2);
						if (checkInDict(replacing)) {
							if (out.contains(replacing))
								continue;
							out.add(replacing);
						}
				}
				outee[i] = out;
			}
		}

		return outee;
	}

	//method checkInDict will return the boolean that represents if the input word exist in the dictionary
	//this will compare input word and the word inside the index as the input word's hashcode of the hashtable array
	//If index,which is same with the input word's hashcode, of the hashtable array is not null but the value is different, check the chaining
	public boolean checkInDict(String input) {
		if(input.equals("")) return true;//dismiss blank
		Table.WordInTable temp = tab.wordList[(input.hashCode() & 0x7FFFFFFF) % tab.wordList.length]; //hashcode the input word and find it in the hashtable array
		while (temp != null) {
			if (input.equals(temp.value)) { //if exist, return true
				return true;
			}
			temp = temp.next; //if exist but the value is different, check the chaining
		}
		return false;
	}

	//This class operates as Hash Table(much similar to hash set in this program)
	public class Table<K, V> {
		WordInTable<?, ?>[] wordList;

		public Table(int capacity) {
			wordList = new WordInTable<?, ?>[capacity];
		}

		//This inner class will operates as entry of the hash table
		private static class WordInTable<K, V> {
			final int hash;
			final K key;
			V value;
			WordInTable<K, V> next;

			WordInTable(K key, V value) {
				this.hash = key.hashCode();
				this.key = key;
				this.value = value;
				this.next = null;
			}
		}

		//Method addTable will add the input word in to the hash table
		//the input word will be placed in the index of its hashcode value
		//If other words already exist in the its hashcode index, use chaining
		//Chaining is implemented similar with the linked list implementation.
		public void addTable(String line) {
			WordInTable added = new WordInTable(line, line); //key and value are just the same
			WordInTable temp = wordList[(line.hashCode() & 0x7FFFFFFF) % wordList.length];

			while (wordList[(line.hashCode() & 0x7FFFFFFF) % wordList.length] != null) { //if certain entry already exists in the same hashcode index, use chaining
				if (temp.next == null) {
					temp.next = added;
					return;
				}
				temp = temp.next;
			}
			wordList[(line.hashCode() & 0x7FFFFFFF) % wordList.length] = added;

		}

	}

	public static void main(String[] args) {
		SpellCheck sc = new SpellCheck();

		String[] sentences = {"I love my uant but my cousine is not a goood gui realy","","banel","loki"};
		// Feel free to change the following printout routine
		for (String sent : sentences) {
			String[] words = sent.split("\\s");
			ArrayList<String>[] ret = sc.spellCheck(sent);
			if (ret == null)
				continue;
			String cand = "";
			for (int i = 0; i < ret.length; i++) {
				if (ret[i] == null) {
					System.out.print(words[i] + " ");
					continue;
				}
				Iterator<String> it = ret[i].iterator();
				while (it.hasNext())
					cand += (it.next() + ",");
				System.out.print("(" + cand + ") ");
				cand = "";
			}
			System.out.println();
		}
	}

}
