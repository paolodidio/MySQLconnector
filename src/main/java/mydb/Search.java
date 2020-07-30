package mydb;

import java.util.List;

public interface Search {
	
	//search method where you need to write the where clause
	
	public List<String> search(String where);
	
	//SearchDeterminedOccurences**** search method where you need to write the attribute and the value you want to search, overloaded with custom pageSize
		//this will print the whole rows, overloaded with pageSize
		public List<String> searchDeterminedOccurrence(String comparison,String attribute, Object value);
		
		//SearchSubstring**** search method where you need to write the attribute and the substring you want to search, overloaded with custom pageSize
		//this will print the whole rows, overloaded with pageSize
		public List<String> searchSubstring(String attribute, Object value);
	
}
