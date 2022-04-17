package ledgerbanking.data;

import ledgerbanking.model.Customer;

public class CustomerDBService {
    public void storeCustomer(Customer customer) {
        DataStore.getCustomerDetails().putIfAbsent(customer.getCustomerName(), customer);
    }

    public Customer getCustomer(String customerName) {
        return DataStore.getCustomerDetails().getOrDefault(customerName, null);
    }
}
