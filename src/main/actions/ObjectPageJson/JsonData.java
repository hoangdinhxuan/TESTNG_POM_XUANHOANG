
package ObjectPageJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonData {

	@SerializedName("NewCustomer")
	@Expose
	private NewCustomer newCustomer;
	@SerializedName("EditCustomer")
	@Expose
	private EditCustomer editCustomer;
	
	
	
	@SerializedName("ExpectedMsg")
	@Expose
	private ExpectedMsg expectedMsg;

	public NewCustomer NewCustomerPage() {
		return newCustomer;
	}

	public EditCustomer EditCustomerPage() {
		return editCustomer;
	}
	public ExpectedMsg ExpectedMsgPage() {
		return expectedMsg;
	}

}
