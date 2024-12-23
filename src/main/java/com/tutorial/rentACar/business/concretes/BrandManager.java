package com.tutorial.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutorial.rentACar.business.abstracts.BrandService;
import com.tutorial.rentACar.business.requests.CreateBrandRequest;
import com.tutorial.rentACar.business.requests.UpdateBrandRequest;
import com.tutorial.rentACar.business.responses.GetAllBrandsResponse;
import com.tutorial.rentACar.business.responses.GetBrandByIdResponse;
import com.tutorial.rentACar.business.rules.BrandBusinessRules;
import com.tutorial.rentACar.core.utilities.mappers.ModelMapperService;
import com.tutorial.rentACar.dataAccess.abstracts.BrandRepository;
import com.tutorial.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = this.brandRepository.findAll();
		
		List<GetAllBrandsResponse> response = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).toList();
		
		return response;
	}

	@Override
	public GetBrandByIdResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetBrandByIdResponse response = this.modelMapperService.forResponse().map(brand, GetBrandByIdResponse.class);
		return response;
	}

	@Override
	public void create(CreateBrandRequest request) {
		this.brandBusinessRules.checkIfBrandNameExists(request.getName());
		Brand brand = this.modelMapperService.forRequest().map(request, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void update(UpdateBrandRequest request) {
		Brand brand = this.modelMapperService.forRequest().map(request, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);

	}

}
