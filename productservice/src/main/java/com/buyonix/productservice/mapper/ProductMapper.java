package com.buyonix.productservice.mapper;

import com.buyonix.productservice.dto.ProductDTO;
import com.buyonix.productservice.model.Product;
import com.buyonix.productservice.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    Product toProduct(ProductDTO productDTO);
    ProductDTO toProductDTO(Product product);
    ProductResponse toResponse(Product product);
}
