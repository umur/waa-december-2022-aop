package edu.miu.aop.service.impl;

import edu.miu.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.dto.ProductDto;
import edu.miu.aop.dto.ReviewDto;
import edu.miu.aop.entity.Category;
import edu.miu.aop.entity.Product;
import edu.miu.aop.repository.CategoryRepo;
import edu.miu.aop.repository.ProductRepo;
import edu.miu.aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;
    @Override
    public Iterable<ProductDto> getAll() {
        return convertIteratorToList(productRepo.findAll());
    }

    @Override
    public ProductDto getById(int id) {
        return modelMapper.map(productRepo.findById(id).get(), ProductDto.class);
    }

    @Override
    public void save(ProductDto product) {
        productRepo.save(modelMapper.map(product, Product.class));
    }

    @Override
    public void update(int id, ProductDto product) {
        productRepo.save(modelMapper.map(product, Product.class));
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Iterable<ReviewDto> getReviewsById(int id) {
        return getById(id).getReviews().stream()
                .map(review -> modelMapper.map(review, ReviewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @ExecutionTime
    public Iterable<ProductDto> findAllByPriceGreaterThan(double minPrice) {
        return convertIteratorToList(productRepo.findAllByPriceGreaterThan(minPrice));
    }

    @Override
    @ExecutionTime
    public Iterable<ProductDto> findAllByCategoryAndPriceLessThan(String cat, double maxPrice) {
        Category category = categoryRepo.findByName(cat);
        return convertIteratorToList(productRepo.findAllByCategoryAndPriceLessThan(category, maxPrice));
    }

    @Override
    @ExecutionTime
    public Iterable<ProductDto> findAllByNameContainingIgnoreCase(String name) {
        return convertIteratorToList(productRepo.findAllByNameContainingIgnoreCase(name));
    }

    private List<ProductDto> convertIteratorToList(Iterable<Product> iterable){
        List<ProductDto> list = new ArrayList<>();
        iterable.forEach(e -> list.add(modelMapper.map(e, ProductDto.class)));
        return list;
    }

//    private <T, U> List<T> convertIteratorToList(Iterable<U> iterable){
//        List<T> list = new ArrayList<T>();
//        iterable.forEach(e -> list.add(modelMapper.map(e, T)));
//        return list;
//    }
}
