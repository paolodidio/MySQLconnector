package mydb;

import java.util.Set;

import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.Uid;

public interface Update {

	//given the java identifier of an element and a list of attributes, update the entry
	public Uid update(String account, Set<Attribute> attributes);
}
