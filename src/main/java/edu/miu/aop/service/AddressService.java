package edu.miu.aop.service;

import edu.miu.aop.dto.AddressDto;

public interface AddressService {
    Iterable<AddressDto> getAll();
    AddressDto getById(int id);
    void save(AddressDto address);
    void update(int id, AddressDto address);
    void delete(int id);
}

