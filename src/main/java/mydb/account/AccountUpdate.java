package mydb.account;

import java.util.Set;

import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.Uid;

import mydb.Update;
import net.tirasa.connid.bundles.db.table.DatabaseTableConnector;
import net.tirasa.connid.bundles.ldap.LdapConnection;

public class AccountUpdate implements Update{


	DatabaseTableConnector connector;
   
	
	public AccountUpdate(DatabaseTableConnector conn) {
		connector = conn;
	}


	public Uid update(String account, Set<Attribute> attributes) {
		Uid result = connector.update(ObjectClass.ACCOUNT, new Uid(account), attributes, new OperationOptionsBuilder().build());
		if (result != null) {System.out.println("Successfully updated an account!");}
		else {System.out.println("An error occured during account update!");}
		System.out.println();
		return result;
	}
}
