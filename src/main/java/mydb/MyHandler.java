package mydb;

import java.util.ArrayList;
import java.util.List;

import org.identityconnectors.framework.common.objects.ConnectorObject;
import org.identityconnectors.framework.common.objects.ResultsHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class MyHandler implements ResultsHandler {

    private final List<String> connectorObjects = new ArrayList<String>();
    Gson builder = new GsonBuilder().disableHtmlEscaping().create();
    
    private List<String> uids = new ArrayList<String>();
    
    public boolean handle(ConnectorObject object) {
    	System.out.println("handleeeeeeeeeeeeeeeeeee  "+object.getClass().arrayType()+"    "+object.getUid()+"    "+object.getUid().getUidValue()+"    "+object.getUid().toString());
    	uids.add(object.getUid().getUidValue());
    	connectorObjects.add(builder.toJson(object));
        return true;
    }

    public List<String> getObjects() {
        return connectorObjects;
    }
    public List<String> getUids() {
        return uids;
    }
    
    public void printObjects(){
    	 List<String> a= this.getObjects();
         int b= 0;
         for (int i =0; i < this.getObjects().size(); b++ ) {
         	System.out.println("Print oggetto " + (b+1) + ": "+a.remove(i));        	
         }
         
         System.out.println("Prito gli UIDDDDDUIDUIDUI");  
         
         a= this.getUids();
         for (int i =0; i < a.size(); i++ ) {
         	System.out.println("Print uidddd " + (i+1) + ": "+a.get(i));        	
         }
    }
    
    public int size () {
    	return connectorObjects.size();
    }

}