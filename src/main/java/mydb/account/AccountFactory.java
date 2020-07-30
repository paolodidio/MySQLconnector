package mydb.account;

import java.util.Properties;

import org.identityconnectors.common.security.GuardedString;

import mydb.Add;
import mydb.DbFactory;
import mydb.Delete;
import mydb.Search;
import mydb.Update;
import net.tirasa.connid.bundles.db.table.DatabaseTableConfiguration;
import net.tirasa.connid.bundles.db.table.DatabaseTableConnector;

public class AccountFactory implements DbFactory {

	//singleton???????
		DatabaseTableConnector connector;
		
		public AccountFactory() {this.setConnection();}
		
		//create a Search object for ACCOUNT elements
		public AccountSearch createSearch() {
			return new AccountSearch(connector);
		}

		//create an Add object for ACCOUNT elements
		public AccountAdd createAdd() {
			return new AccountAdd(connector);
		}
		
		//create a Delete object for ACCOUNT elements
		public AccountDelete createDelete() {
			return new AccountDelete(connector);
		}
		
		//create an Update object for ACCOUNT elements
		public AccountUpdate createUpdate() {
			return new AccountUpdate(connector);
		}
		
		private void setConnection() {
			DatabaseTableConfiguration config = new DatabaseTableConfiguration();
			
			 
		    final String USER = "root";
		    final GuardedString PASSWORD = new GuardedString("root".toCharArray());
		     final String DBTABLE = "Accounts";
		     final String HOST = "127.0.0.1";
		     final String PORT = "3306";
		     final String DATABASE = "monokee";
		     final String KEYCOLUMN = "accountId";
		     String PASSWORD_CHARSETNAME = "UTF-8";
		     final String CHANGELOG = "tstChangelogColumn";
		     final String URL = "jdbc:mysql://localhost:3306/monokee?serverTimezone=UTC";
		     final String URLTEMPLATE = "jdbc:mysql://%h:%p/%d";		     
		     final String DB_TABLE = "Accounts";		     
		     final Properties PROPS = new Properties();
		     final String PASSWORD_CHARSET = PROPS.getProperty("password_charset", "UTF-8");		     
		     final String DB = PROPS.getProperty("db");		     
		     final String DRIVER = "com.mysql.cj.jdbc.Driver";
	     
		     config.setJdbcDriver(DRIVER);
		        config.setUser(USER);
		        config.setPassword(PASSWORD);
		        config.setPasswordCharset(PASSWORD_CHARSETNAME);
		        config.setTable(DBTABLE);
		        config.setHost(HOST);
		        config.setPort(PORT);
		        config.setDatabase(DATABASE);
		        config.setKeyColumn(KEYCOLUMN);
		        config.setChangeLogColumn(CHANGELOG);
		        config.setJdbcUrlTemplate(URLTEMPLATE);
		
		        DatabaseTableConnector conn = new DatabaseTableConnector();
		    	conn.init(config);
		    	
		    	this.connector= conn;

		}
		
		public DatabaseTableConnector getConnection() {
			return this.connector;
		}
		
}
