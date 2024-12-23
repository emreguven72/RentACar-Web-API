package com.tutorial.rentACar.business.abstracts;

import java.util.List;

import com.tutorial.rentACar.business.requests.CreateBrandRequest;
import com.tutorial.rentACar.business.requests.UpdateBrandRequest;
import com.tutorial.rentACar.business.responses.GetAllBrandsResponse;
import com.tutorial.rentACar.business.responses.GetBrandByIdResponse;

public interface BrandService {
	
	List<GetAllBrandsResponse> getAll();
	
	GetBrandByIdResponse getById(int id);
	
	void create(CreateBrandRequest request);
	
	void update(UpdateBrandRequest request);
	
	void delete(int id);
	
}
