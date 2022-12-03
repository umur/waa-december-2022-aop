package edu.miu.aop.service.impl;

import edu.miu.aop.dto.AddressDto;
import edu.miu.aop.entity.Address;
import edu.miu.aop.repository.AddressRepo;
import edu.miu.aop.service.AddressService;
import edu.miu.aop.dto.AddressDto;
import edu.miu.aop.repository.AddressRepo;
import edu.miu.aop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;
    @Override
    public Iterable<AddressDto> getAll() {
        List<AddressDto> list = new ArrayList<>();
        var address = addressRepo.findAll();
        address.forEach(p -> list.add(modelMapper.map(p, AddressDto.class)));
        return list;
    }

    @Override
    public AddressDto getById(int id) {
        return modelMapper.map(addressRepo.findById(id).get(), AddressDto.class);
    }

    @Override
    public void save(AddressDto address) {
        addressRepo.save(modelMapper.map(address, Address.class));
    }

    @Override
    public void update(int id, AddressDto address) {
        addressRepo.save(modelMapper.map(address, Address.class));
    }

    @Override
    public void delete(int id) {
        addressRepo.deleteById(id);
    }
}
