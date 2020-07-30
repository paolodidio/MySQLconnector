package mydb.account;

import java.util.Set;

import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.Uid;

import mydb.Add;
import net.tirasa.connid.bundles.db.table.DatabaseTableConnector;

public class AccountAdd implements Add{


	DatabaseTableConnector connector;
	
   
	
	public AccountAdd(DatabaseTableConnector conn) {
		connector = conn;
	}
	
	public Uid add(Set<Attribute> attrs) {
		
		Uid result = connector.create(ObjectClass.ACCOUNT, attrs, new OperationOptionsBuilder().build());
		
		if (result != null) {System.out.println("Successfully created an account!");}
		else {System.out.println("An error occured during account creation!");}
		System.out.println();
		
		return result;
	}
}
