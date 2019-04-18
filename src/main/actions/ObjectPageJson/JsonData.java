
package ObjectPageJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonData {

    @SerializedName("NewCustomer")
    @Expose
    private NewCustomer newCustomer;
    @SerializedName("ExpectedMsg")
    @Expose
    private ExpectedMsg expectedMsg;
    @SerializedName("EditCustomer")
    @Expose
    private EditCustomer editCustomer;

    public NewCustomer NewCustomerPage() {
        return newCustomer;
    }

    public ExpectedMsg ExpectedMsgPage() {
        return expectedMsg;
    }

    public EditCustomer EditCustomerPage() {
        return editCustomer;
    }

}
