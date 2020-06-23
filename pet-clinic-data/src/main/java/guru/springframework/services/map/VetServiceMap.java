package guru.springframework.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.model.Specialty;
import guru.springframework.model.Vet;
import guru.springframework.services.SpecialtyService;
import guru.springframework.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialtyService specialtyService;
	
	
	
	public VetServiceMap(SpecialtyService specialtyService) {
	
	this.specialtyService = specialtyService;
}
@Override
	public Set<Vet> findAll() {

		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	
	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Vet save(Vet object) {

			if(object.getSpecialties().size() > 0) {
				object.getSpecialties().forEach(spec ->{
					if(spec.getId() == null) {
						Specialty savedSpecialty = specialtyService.save(spec);
						spec.setId(savedSpecialty.getId());
					}
				});
			}
		return super.save(object);
	}
}
