package assignment07;

import java.nio.file.Paths;
import java.util.*;
import java.io.IOException;

public class P19_7{

	public static void main(String[] args) throws IOException {
		//iterates through female names to find # of total names with <=2 vowels, longest of those names, and # of those names of each length
		try(Scanner fileIn = new Scanner(Paths.get("fem1stnames.txt"))){
			//sets the vowel set for comparing
			Set<Character> vowels = new HashSet<Character>();
			vowels.add('a');
			vowels.add('e');
			vowels.add('i');
			vowels.add('o');
			vowels.add('u');
			//counts the number of names with at most two vowels
			int retCount = 0;
			//initializes the value for the longest name with at most two vowels
			String retName = "";
			//map for looking at the length of every name with at most two vowels, and how many there are of each length : key = length of name, value = number of names with that length
			Map<Integer, Long> eachName = new HashMap<Integer, Long>();
			while(fileIn.hasNextLine()) {
				String temp = fileIn.nextLine();
				int countVowel = 0;
				for(int i = 0; i<temp.length(); i++) {
					for(char el : vowels) {
						if(temp.charAt(i) == el) {
							countVowel++;
							continue;
						}
					}
				}
				if(countVowel <= 2) {
					retCount++;
					if(temp.length() > retName.length()) retName = temp;
					//flag keeps track if each name was placed into the Map
					boolean tempFlag = false;
					if(eachName.keySet().size() == 0) {
						eachName.put(temp.length(), (long)1);
						continue;
					}
					for(Integer key : eachName.keySet()) {
						if(temp.length() == key) {
							eachName.put(key, eachName.get(key)+1);
							tempFlag = true;
							continue;
						}
					}
					//if the name was not placed into the map, we create a new entry
					if(!tempFlag) eachName.put(temp.length(), (long)1);
				}
			}
			System.out.println("There are "+retCount+" female names with at most 2 vowels.\n");
			System.out.println("The longest female name with at most 2 vowels is "+retName+".\n");
			for(Integer key : eachName.keySet()) {
				if(eachName.get(key) == 1) System.out.println("There is "+eachName.get(key)+" name of length "+key+".");
				else{ System.out.println("There are "+eachName.get(key)+" names of length "+key+".");
				}
			}
			System.out.println();
			fileIn.close();
		}
		//iterates through male names to categorize them by first letter
		try(Scanner fileIn2 = new Scanner(Paths.get("mal1stnames.txt"))){
			Map<Character, List<String>> men = new HashMap<Character, List<String>>(); //map of male names, k = first letter of name, v = list of names
			while(fileIn2.hasNextLine()) {
				boolean tempFlag = false; //checks to see if the name has been placed into the map yet or not
				String temp = fileIn2.nextLine();
				for(char key : men.keySet()) {
					if(temp.charAt(0) == key) {
						men.get(key).add(temp);
						tempFlag = true;
					}
				}
				if(!tempFlag) {
					ArrayList<String> gene = new ArrayList<>();
					gene.add(temp);
					men.put(temp.charAt(0), gene);
				}
			}
			for(char key : men.keySet()) {
				System.out.println(key+": "+men.get(key));
			}
			fileIn2.close();
		}
		
		
	}
}