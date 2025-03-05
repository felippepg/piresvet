package com.piresvet.adapters.service.PetOwner;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.core.exception.PetOwnerNotFoundException;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.gatewayContracts.PetOwner.FindPetOwnerGateway;
import com.piresvet.persistence.PetOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindPetOwnerGatewayImplementation implements FindPetOwnerGateway {
    private final PetOwnerRepository repository;
    private final PetOwnerMapper mapper;
    @Override
    public Optional<PetOwner> findById(UUID id) {
        var petOwner = repository.findById(id).orElseThrow(() -> new PetOwnerNotFoundException("Tutor não encontrado"));
        return Optional.ofNullable(mapper.toDomain(petOwner));
    }

    @Override
    public List<PetOwner> findByFullname(String firstname, String lastname) {
        var petOwners = repository.findByFirstnameAndLastname(firstname, lastname);
        return petOwners.stream().map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PetOwner> findByCpf(String cpf) {
        var petOwner = repository.findByCpf(cpf).orElseThrow(() -> new PetOwnerNotFoundException("Tutor não encontrado"));
        return Optional.ofNullable(mapper.toDomain(petOwner));
    }

    @Override
    public List<PetOwner> findAll() {
        var petOwners = repository.findAll();
        return petOwners.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<PetOwner> findByName(String firstname) {
        var petOwners = repository.findByFirstname(firstname);
        return petOwners.stream().map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
