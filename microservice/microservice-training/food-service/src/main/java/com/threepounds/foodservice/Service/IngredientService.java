package com.threepounds.foodservice.Service;

import com.threepounds.foodservice.data.entity.Ingredient;
import com.threepounds.foodservice.data.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository repository;

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Ingredient save(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public Optional<Ingredient> getById(UUID id) {
        return repository.findById(id);
    }

    public List<Ingredient> list() {
        return repository.findAll();
    }

    public List<Ingredient> listById(List<UUID> ingredients) {
        return repository.findAllById(ingredients);
    }

    public Page<Ingredient> listById(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable);
    }

}
