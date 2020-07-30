package mydb.account;

import java.util.List;

import org.identityconnectors.framework.common.objects.AttributeBuilder;
import org.identityconnectors.framework.common.objects.AttributeUtil;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;

import mydb.MyHandler;
import mydb.Search;
import net.tirasa.connid.bundles.db.table.DatabaseTableConnector;
import net.tirasa.connid.bundles.ldap.LdapConnection;
import net.tirasa.connid.commons.db.FilterWhereBuilder;
import net.tirasa.connid.commons.db.SQLParam;

public class AccountSearch implements Search{

	
	DatabaseTableConnector connector;
   
	
	public AccountSearch(DatabaseTableConnector conn) {
		connector = conn;
	}

	
	public List<String> search(String where) {

		FilterWhereBuilder tmp = new FilterWhereBuilder();
		
		//Object val =AttributeUtil.getSingleValue(new AttributeBuilder().build(attribute, value));
		//tmp.addBind(new SQLParam(attribute, val), comparison, false);
		MyHandler handler = new MyHandler();
		connector.executeQuery(ObjectClass.ACCOUNT, tmp, handler, new OperationOptionsBuilder().build());
		System.out.println(handler.getUids());
		
		return handler.getUids();
	}

	public List<String> searchDeterminedOccurrence(String comparison, String attribute, Object value) {

		FilterWhereBuilder tmp = new FilterWhereBuilder();
		new AttributeBuilder();
		Object val =AttributeUtil.getSingleValue(AttributeBuilder.build(attribute, value));
		tmp.addBind(new SQLParam(attribute, val), comparison, false);
		MyHandler handler = new MyHandler();
		connector.executeQuery(ObjectClass.ACCOUNT, tmp, handler, new OperationOptionsBuilder().build());
		System.out.println(handler.getUids());
		
		return handler.getUids();
	}

	public List<String> searchSubstring(String attribute, Object value) {
		FilterWhereBuilder tmp = new FilterWhereBuilder();
		new AttributeBuilder();
		Object val =AttributeUtil.getSingleValue(AttributeBuilder.build(attribute, "%"+value+"%"));
		tmp.addBind(new SQLParam(attribute, val), "LIKE", false);
		MyHandler handler = new MyHandler();
		connector.executeQuery(ObjectClass.ACCOUNT, tmp, handler, new OperationOptionsBuilder().build());
		System.out.println(handler.getUids());
		
		return handler.getUids();
	}


	
	
	
}
