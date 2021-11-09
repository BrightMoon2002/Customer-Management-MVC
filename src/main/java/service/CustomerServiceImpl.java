package service;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService{
    private static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Dinh", "Dinh97@gmail.com", "Ha Nam"));
        customerList.add(new Customer(2, "Ha", "HaLoveD@gmail.com", "Phu Tho"));
        customerList.add(new Customer(3, "DiezC09", "DiezAnC@gmail.com", "Bai rac"));
        customerList.add(new Customer(4, "Meo", "Meo502@gmail.com", "An Giang"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList ;
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void update(int id, Customer customer) {
        customerList.set(id, customer);
    }

    @Override
    public void remove(Customer customer) {
        customerList.remove(customer);
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        for (int i = 0; i < customerList.size(); i++) {
            if (id == customerList.get(i).getId()) {
                customer = customerList.get(i);
                break;
            }
        }
        return customer;
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }
}
