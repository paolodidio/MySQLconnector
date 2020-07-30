package mydb.account;

import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.Uid;

import mydb.Delete;
import net.tirasa.connid.bundles.db.table.DatabaseTableConnector;
public class AccountDelete implements Delete{


	DatabaseTableConnector connector;
   
	
	public AccountDelete(DatabaseTableConnector conn) {
		connector = conn;
	}


	public void delete(String uid) {
		
		connector.delete(ObjectClass.ACCOUNT, new Uid(uid), new OperationOptionsBuilder().build());
		System.out.println("Successfully deleted an account!");
		
	}
}
