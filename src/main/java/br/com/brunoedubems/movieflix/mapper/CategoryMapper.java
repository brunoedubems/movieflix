package br.com.brunoedubems.movieflix.mapper;

import br.com.brunoedubems.movieflix.controller.request.CategoryRequest;
import br.com.brunoedubems.movieflix.controller.response.CategoryResponse;
import br.com.brunoedubems.movieflix.entity.Category;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest){
        return Category.builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return  CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
