package guru.springframework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.model.Owner;
import guru.springframework.model.PetType;
import guru.springframework.model.Vet;
import guru.springframework.services.OwnerService;
import guru.springframework.services.PetTypeService;
import guru.springframework.services.VetService;
import guru.springframework.services.map.OwnerServiceMap;
import guru.springframework.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType saveDogType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatType = petTypeService.save(cat);
		

		Owner owner1 = new Owner();

		owner1.setFirstName("Michael");
		owner1.setLastName("Wston");

		ownerService.save(owner1);

		Owner owner2 = new Owner();

		owner2.setFirstName("Fiona");
		owner2.setLastName("Gleanne");

		ownerService.save(owner2);
		System.out.println("Loaded Owners... " + ownerService.findAll().size());

		Vet vet1 = new Vet();

		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");

		vetService.save(vet1);

		Vet vet2 = new Vet();

		vet2.setFirstName("George");
		vet2.setLastName("Viesel");

		vetService.save(vet2);
		System.out.println("Loaded Vets...");
	}

}
