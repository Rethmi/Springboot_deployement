package lk.ijse.gdse72.springboot_deployement.service.impl;

import lk.ijse.gdse72.springboot_deployement.dto.CustomerDTO;
import lk.ijse.gdse72.springboot_deployement.entity.Customer;
import lk.ijse.gdse72.springboot_deployement.repository.CustomerRepository;
import lk.ijse.gdse72.springboot_deployement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if(customerDTO==null){
            throw new IllegalArgumentException("Customer id is null");
        }
        customerRepository.save(modelMapper.map(customerDTO, Customer.class));
    }
}
