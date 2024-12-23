package com.tutorial.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutorial.rentACar.business.abstracts.ModelService;
import com.tutorial.rentACar.business.requests.CreateModelRequest;
import com.tutorial.rentACar.business.requests.UpdateModelRequest;
import com.tutorial.rentACar.business.responses.GetAllModelsResponse;
import com.tutorial.rentACar.business.responses.GetModelByIdResponse;
import com.tutorial.rentACar.core.utilities.mappers.ModelMapperService;
import com.tutorial.rentACar.dataAccess.abstracts.BrandRepository;
import com.tutorial.rentACar.dataAccess.abstracts.ModelRepository;
import com.tutorial.rentACar.entities.concretes.Brand;
import com.tutorial.rentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	private BrandRepository brandRepository;

	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = this.modelRepository.findAll();

		List<GetAllModelsResponse> responses = models.stream()
				.map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).toList();

		return responses;
	}

	@Override
	public GetModelByIdResponse getById(int id) {
		Model model = this.modelRepository.findById(id).orElseThrow();
		GetModelByIdResponse modelResponse = this.modelMapperService.forResponse().map(model,
				GetModelByIdResponse.class);
		return modelResponse;
	}

	@Override
	public void create(CreateModelRequest createModelRequest) {
		Brand brand = brandRepository.findById(createModelRequest.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        Model model = new Model();
        model.setName(createModelRequest.getName());
        model.setBrand(brand);

        modelRepository.save(model);
    }

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
		this.modelRepository.save(model);
	}

	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);
	}

}
