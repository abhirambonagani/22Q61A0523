package com.app.calculator.averagecaluclator2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numbers")
public class Cal {

    
public Cal(NumberService service) {
        this.service = service;
    }

private final NumberService service;

public NumberService getService() {
    return service;
}

@GetMapping("/{numberId}")
public ResponseDTO  getNumbers(@PathVariable String numberId){
    
return service.processnumber(numberId);
}

}
