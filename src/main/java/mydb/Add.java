package mydb;

import java.util.Set;

import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.Uid;

public interface Add {
		
	
	public Uid add(Set<Attribute> attrs);
}
