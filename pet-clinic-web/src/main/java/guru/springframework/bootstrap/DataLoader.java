package guru.springframework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.model.Owner;
import guru.springframework.model.Vet;
import guru.springframework.services.OwnerService;
import guru.springframework.services.VetService;
import guru.springframework.services.map.OwnerServiceMap;
import guru.springframework.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private OwnerService ownerService;
	private VetService vetService;
	
	public DataLoader() {
	this.ownerService = new OwnerServiceMap();
	this.vetService = new VetServiceMap();
	}
	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Michael");
		owner1.setLastName("Wston");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner1.setId(2L);
		owner1.setFirstName("Fiona");
		owner1.setLastName("Gleanne");
		
		ownerService.save(owner2);
		System.out.println("Loaded Owners...");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("George");
		vet2.setLastName("Viesel");
		
		vetService.save(vet2);
		System.out.println("Loaded Vets...");
	}

}
