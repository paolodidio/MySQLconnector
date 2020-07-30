package mydb.query;

import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.AttributeBuilder;

public class MyParser<F> extends QueryFilterParser<F>{

	/**
     * Parses the field description from the current filter token into the type of field
     * description the QueryFilter uses.
     * @param fieldDescription The token from parsing the query string.
     * @return The field description.
     */
	@Override
	protected F parseField(String fieldDescription) {
		
		System.out.println("parse field call   "+  fieldDescription);
		F b = (F) new String(fieldDescription);
		Attribute c = AttributeBuilder.build(fieldDescription);
		
		System.out.println("aa:   " +b);
		System.out.println("c    " +b);
		return (b);
	}

}
