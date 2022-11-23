package org.generation.italy.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static class StringComparator implements Comparator<String> {
		
		@Override
		public int compare(String o1, String o2){
			return o1.length() - o2.length();
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
			}
			
		
		}
		
	}	
}
