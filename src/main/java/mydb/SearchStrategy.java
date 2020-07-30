package mydb;

import java.util.List;

public interface SearchStrategy {
	
	List<String> search(boolean equals,String attribute, Object value);

}
