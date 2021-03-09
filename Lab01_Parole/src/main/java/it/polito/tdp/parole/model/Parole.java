package it.polito.tdp.parole.model;

import java.util.*;


public class Parole {
	
	private List<String> parole;	
	//private List<String> Aparole;
	
	
	public Parole() {
		this.parole = new LinkedList<String> ();
		//this.Aparole = new ArrayList<String> ();
	}
	
	public void addParola(String p) {
		parole.add(p);	
		//Aparole.add(p);
	}
	
	public class ComparatoreDiStringhe implements  Comparator {
		
		public int compare(Object o1, Object o2) {
			
			String s1 = (String) o1;
			String s2 = (String) o2;
			
			return s1.compareTo(s2);
		}
		
	}
	
	public List<String> getElenco() {
		Collections.sort(parole , new ComparatoreDiStringhe());
		//Collections.sort(Aparole , new ComparatoreDiStringhe());
		return parole;
		//return Aparole;
	}
	
	public void reset() {
		parole.removeAll(parole);
		//Aparole.removeAll(Aparole);
	}

	@Override
	public String toString() {
		String s = "";
		for(String ss :  parole) {
			s += ss + "\n";
		}
		
		/*for(String ss :  Aparole) {
			s += ss + "\n";
		}*/
		
		return s;
	}
	
	public void cancel(String s) {
		parole.remove(s);
		//Aparole.remove(s);
	}

	
	
	
}
