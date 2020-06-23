package guru.springframework.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.model.PetType;
import guru.springframework.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService{

	@Override
	public Set<PetType> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public PetType findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public PetType save(PetType object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(PetType object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

}
