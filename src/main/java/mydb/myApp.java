package mydb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.identityconnectors.common.security.GuardedString;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.AttributeBuilder;
import org.identityconnectors.framework.common.objects.AttributeUtil;
import org.identityconnectors.framework.common.objects.Name;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;

import mydb.account.AccountFactory;
import mydb.query.MyParser;
import mydb.query.QueryFilter;
import net.tirasa.connid.bundles.db.table.DatabaseTableConfiguration;
import net.tirasa.connid.bundles.db.table.DatabaseTableConnection;
import net.tirasa.connid.bundles.db.table.DatabaseTableConnector;
import net.tirasa.connid.commons.db.DatabaseConnection;
import net.tirasa.connid.commons.db.FilterWhereBuilder;
import net.tirasa.connid.commons.db.OperationBuilder;
import net.tirasa.connid.commons.db.SQLParam;
import net.tirasa.connid.commons.db.Constants;
public class myApp {

	
	public static void main (String[] args) {
	
		/*DatabaseTableConfiguration config = new DatabaseTableConfiguration();
	
	 
	    final String USER = "root";

	     final GuardedString PASSWORD = new GuardedString("root".toCharArray());
	    
	     final String DBTABLE = "Accounts";

	     final String HOST = "127.0.0.1";

	     final String PORT = "3306";

	     final String DATABASE = "monokee";

	     final String KEYCOLUMN = "accountId";

	     //final String PASSDCOLUMN = "tstPasswordColumn";

	     String PASSWORD_CHARSETNAME = "UTF-8";

	     final String CHANGELOG = "tstChangelogColumn";

	     final String URL = "jdbc:mysql://localhost:3306/monokee?serverTimezone=UTC";

	     final String URLTEMPLATE = "jdbc:mysql://%h:%p/%d";
	     
	     final String DB_TABLE = "Accounts";
	     
	     final Properties PROPS = new Properties();

	     final String PASSWORD_CHARSET = PROPS.getProperty("password_charset", "UTF-8");
	     
	     final String DB = PROPS.getProperty("db");
	     
	     final String DRIVER = "com.mysql.cj.jdbc.Driver";
	     //final String DRIVER = "mysql-connector-java";
	
    // check defaults.. 
	     config.setJdbcDriver(DRIVER);
	        config.setUser(USER);
	        config.setPassword(PASSWORD);
	        config.setPasswordCharset(PASSWORD_CHARSETNAME);
	        config.setTable(DBTABLE);
	        config.setHost(HOST);
	        config.setPort(PORT);
	        config.setDatabase(DATABASE);
	        config.setKeyColumn(KEYCOLUMN);
	       // config.setPasswordColumn(PASSDCOLUMN);
	        config.setChangeLogColumn(CHANGELOG);
	        config.setJdbcUrlTemplate(URLTEMPLATE);
	

	//DatabaseConnection conn = new DatabaseConnection();
	DatabaseTableConnector connector = new DatabaseTableConnector();
	connector.init(config);
	connector.checkAlive();
	//connector.executeQuery(ObjectClass.ACCOUNT, new FilterWhereBuilder(), new MyHandler(), new OperationOptionsBuilder().build());
	/*FilterWhereBuilder tmp = new FilterWhereBuilder();
	
	System.out.println();
	*/
	/* where salary > 21111111111111
	Object value =AttributeUtil.getSingleValue(new AttributeBuilder().build("salary", "2111.11"));
	tmp.addBind(new SQLParam("salary", value), ">", false);
	System.out.println();
	System.out.println(tmp.getWhere());
	System.out.println("aodhosdoahsohadoa");
	System.out.println();
	System.out.println(tmp.getWhereClause());
	System.out.println();
	System.out.println(AttributeUtil.getSingleValue(new AttributeBuilder().build("mwmw", "44332211")));
	System.out.println();
	System.out.println("aodhosdoahsohadoa");
	System.out.println("aodhosdoahsohadoa");
	System.out.println("aodhosdoahsohadoa");
	System.out.println("aodhosdoahsohadoa");
	System.out.println("aodhosdoahsohadoa");
	MyHandler handler = new MyHandler();
	connector.executeQuery(ObjectClass.ACCOUNT, tmp, handler, new OperationOptionsBuilder().build());*/
	
	/* where salary > 2111 & < 3999 
	Object value =AttributeUtil.getSingleValue(new AttributeBuilder().build("salary", "2111.11"));
	tmp.addBind(new SQLParam("salary", value), ">", false);
	 value =AttributeUtil.getSingleValue(new AttributeBuilder().build("salary", "3999.99"));
	FilterWhereBuilder aaa = new FilterWhereBuilder();
	aaa.addBind(new SQLParam("salary", value), "<", false);
	FilterWhereBuilder bbb = new FilterWhereBuilder();
	bbb.join("AND", tmp, aaa);
	MyHandler handler = new MyHandler();
	System.out.println(bbb.getWhereClause());
	connector.executeQuery(ObjectClass.ACCOUNT, bbb, handler, new OperationOptionsBuilder().build());
	System.out.println(handler.getUids());*/
	
	/*
	Object value =AttributeUtil.getSingleValue(new AttributeBuilder().build("email", "%ns-mail7%"));
	tmp.addBind(new SQLParam("email", value), "LIKE", false);
	MyHandler handler = new MyHandler();
	connector.executeQuery(ObjectClass.ACCOUNT, tmp, handler, new OperationOptionsBuilder().build());
	System.out.println(handler.getUids());
	*/
	
		/*DbFactory factory = new AccountFactory();
        Search search = factory.createSearch();
        
		List<String> result = new ArrayList<String>();
		
		result = search.searchDeterminedOccurrence("<", "age", 35);
		
		search.searchSubstring("email", "mail8");*/
		
		MyParser<String> myp = new MyParser<String>();
		String b = "!(/CDACCOUNTTYPE eq \"PERSONALE ELIMINATO\") AND !((/CDACCOUNTTYPE eq \"PERSONALE CESSATO\" and (/CDROLETYPE eq \"3\" or /CDROLETYPE eq \"8\" or /CDROLETYPE eq \"13\")))";
		QueryFilter<String> a = myp.valueOf(b);
		QueryFilter<String> d = myp.valueOf("/PIANTA eq \"777\"");
		QueryFilter<String> e = QueryFilter.present("PIANTA");
		QueryFilter<Attribute> f = QueryFilter.present(AttributeBuilder.build("PALLONE"));
		System.out.println("quetyyyy:     "+b);
		System.out.println("aaaaaaaaaaaaa:     "+a.toString());
		System.out.println("ddddddddd:     "+d);
		System.out.println("eeeeeeeeeeeee:     "+e);
		System.out.println("ffffffffffff:     "+f);
		
		DbFactory factory = new AccountFactory();
        Search search = factory.createSearch();
        Add add = factory.createAdd();
        Delete delete = factory.createDelete();
        Update update = factory.createUpdate();
		List<String> result = new ArrayList<String>();
		
		result = search.searchDeterminedOccurrence("=", "age", 35);
		
		//create the set of attributes
       /*Set<Attribute> attributes = new HashSet<Attribute>();
        //attributes.add(AttributeBuilder.build("accountId", "rp"));
        attributes.add(new Name("9999")); //accountID not null
        attributes.add(AttributeBuilder.build("password", "Password5"));
        attributes.add(AttributeBuilder.build("manager", "11111"));
        attributes.add(AttributeBuilder.build("firstname", "Riccardo")); //not null
        attributes.add(AttributeBuilder.build("lastname", "Fusilli"));  //not null
        attributes.add(AttributeBuilder.build("changed", "2034-01-19 04:14:07")); //not null
        
        
		//works
		add.add(attributes);*/
		//works -> put accountId
		//delete.delete("Riccardo");
		
		/*Set<Attribute> toUpdate = new HashSet<Attribute>();
        toUpdate.add(AttributeBuilder.build("middlename", "Linguine"));
		//works -> put accountId
        update.update("9999", toUpdate);*/
        
		/*
		!(/CDACCOUNTTYPE eq \"PERSONALE ELIMINATO\") AND "
				+ "!((/CDACCOUNTTYPE eq \"PERSONALE CESSATO\""
				+ " and (/CDROLETYPE eq \"3\" or /CDROLETYPE eq \"8\""
				+ " or /CDROLETYPE eq \"13\")))"
		*/
	}
}
