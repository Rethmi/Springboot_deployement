package lk.ijse.gdse72.springboot_deployement.controller;


import lk.ijse.gdse72.springboot_deployement.dto.APIResponse;
import lk.ijse.gdse72.springboot_deployement.dto.CustomerDTO;
import lk.ijse.gdse72.springboot_deployement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<APIResponse<String>> getCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);

        return new ResponseEntity<>(new APIResponse<>(
                200,
                "Customer saved successfully",
                null
        ), HttpStatus.CREATED);
    }
}
