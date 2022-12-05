package miu.edu.springaop.service;


import org.springframework.stereotype.Service;
import miu.edu.springaop.dto.AddressDto;
import miu.edu.springaop.dto.ProductDto;

import java.util.List;

@Service
public interface AddressService {
    AddressDto save(AddressDto addressDto);
    List<AddressDto> getAllAddress();
    void delete(int id);
    AddressDto update(AddressDto addressDto);

    AddressDto getById(int id);

}
