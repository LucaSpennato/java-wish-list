package org.generation.italy.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public static class StringComparator implements Comparator<String> {
		
		@Override
		public int compare(String o1, String o2){
			
			String vows1 = "";
			String vows2 = "";
			
			for (int i = 0; i < o1.length(); i++) {
				
				char findVow = o1.charAt(i);
				
				if(findVow == 'a' || findVow == 'e' || findVow == 'i' || findVow == 'o' || findVow == 'u') {
					vows1 += findVow;
				}
				
			}
			
			for (int i = 0; i < o2.length(); i++) {
				
				char findVow = o2.charAt(i);
				
				if(findVow == 'a' || findVow == 'e' || findVow == 'i' || findVow == 'o' || findVow == 'u') {
					vows2 += findVow;
				}
				
			}
			
			// in base al ritorno lui sistema prima una e poi l'altra, se +1, 0 o -1
			return vows2.length() - vows1.length();
		}
	}

	public static void main(String[] args) {
		
		List<String> gifts = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int isAddingMore = 1;
		
		boolean putGift = true;
				
	
		while (putGift) {
			
			System.out.println("\nVuoi aggiungere un regalo?" + "\n1- Aggiungi!\n2- Fermati");
			isAddingMore = sc.nextInt();
			putGift = isAddingMore == 1 ? true : false;
			
			if(putGift) {
				System.out.println("Inserisci regalo:");
				String gift = sc.next(); 
				gifts.add(gift);
				
				System.out.println("Al momento hai: " + gifts.size() + " regali in lista!");
				
			}
			
			
			if(putGift == false && gifts.size() > 0) {
				sc.close();
				System.out.println("La tua lista di regali:\n");
				
				gifts.sort(new StringComparator());
				
				int i = 0;
				for(String g : gifts) {
					
					System.out.println(i++ + "-" + g);
					
				}
				
				
			}else if(putGift == false && gifts.size() == 0) {
				System.out.println("Non hai inserito nessun regalo :/");
				
				System.out.println("Inserisci una parola: ");
				String str = sc.next();
				
				Set<String> chars = new HashSet<>();
				Map<Integer, String> mapChars = new HashMap<>();
				
				for (int i = 0; i < str.length(); i++) {
					
					String c = str.charAt(i) + "";
					
					chars.add(c);
					
					mapChars.put(str.indexOf(c), c);
				}
				
				System.out.println(chars);
				
				System.out.println("---------------------------------------");
				
				System.out.println(mapChars);
				
			}
			
		
		}
		
	}	
}
