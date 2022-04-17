package ledgerbanking.controllers;

import ledgerbanking.data.CustomerDBService;
import ledgerbanking.model.Customer;

public class CustomerController {
    public void createCustomer(Customer customer){
        CustomerDBService cxService = new CustomerDBService();
        cxService.storeCustomer(customer);
    }

    public Customer getCustomer(String cxName) {
        CustomerDBService cxService = new CustomerDBService();
        return cxService.getCustomer(cxName);
    }
}
