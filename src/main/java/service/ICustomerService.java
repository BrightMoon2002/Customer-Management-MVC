package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    void update(int id, Customer customer);

    void remove(Customer customer);

    Customer findById(int id);

    int findIndexById(int id);

    Customer findByName(String name);
    List<Customer> findCustomerByAddress (String address);
}
