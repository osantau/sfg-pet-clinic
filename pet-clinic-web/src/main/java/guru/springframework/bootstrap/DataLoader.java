package guru.springframework.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.model.Owner;
import guru.springframework.model.Pet;
import guru.springframework.model.PetType;
import guru.springframework.model.Specialty;
import guru.springframework.model.Vet;
import guru.springframework.model.Visit;
import guru.springframework.repositories.VisitRepository;
import guru.springframework.services.OwnerService;
import guru.springframework.services.PetTypeService;
import guru.springframework.services.SpecialtyService;
import guru.springframework.services.VetService;
import guru.springframework.services.VisitService;
import guru.springframework.services.map.OwnerServiceMap;
import guru.springframework.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtyService specialtyService,VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();

		if (count == 0) {

			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType saveDogType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatType = petTypeService.save(cat);

		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty savedRadiology = specialtyService.save(radiology);

		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		Specialty savedSurgery = specialtyService.save(surgery);

		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		Specialty savedDentistry = specialtyService.save(dentistry);

		Owner owner1 = new Owner();
		Owner.builder().address("sdsd").firstName("sss").lastName("zzz").build();
		owner1.setFirstName("Michael");
		owner1.setLastName("Wston");
		owner1.setAddress("123 Clujului");
		owner1.setCity("Oradea");
		owner1.setTelephone("0259-390-123");

		Pet mikesPet = new Pet();
		mikesPet.setPetType(saveDogType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Blacky");
		owner1.getPets().add(mikesPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();

		owner2.setFirstName("Fiona");
		owner2.setLastName("Gleanne");
		owner1.setAddress("123 Aiudului");
		owner1.setCity("Beius");
		owner1.setTelephone("0259-423-566");

		Pet fionaPet = new Pet();
		fionaPet.setPetType(savedCatType);
		fionaPet.setOwner(owner2);
		fionaPet.setBirthDate(LocalDate.now());
		fionaPet.setName("Angela");
		owner2.getPets().add(fionaPet);

		ownerService.save(owner2);
		Visit catVisit = new Visit();
		catVisit.setPet(fionaPet);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy kitty!!!");
		visitService.save(catVisit);
		
		System.out.println("Loaded Owners... " + ownerService.findAll().size());

		Vet vet1 = new Vet();

		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialties().add(savedDentistry);
		vet1.getSpecialties().add(savedRadiology);
		vetService.save(vet1);

		Vet vet2 = new Vet();

		vet2.setFirstName("George");
		vet2.setLastName("Viesel");
		vet2.getSpecialties().add(savedSurgery);
		vetService.save(vet2);
		System.out.println("Loaded Vets...");
	}

}
