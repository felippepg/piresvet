package com.piresvet.adapters.outbound.service.PetOwner;

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
        return null;
    }

    @Override
    public Optional<PetOwner> findByCpf(String cpf) {
        return Optional.empty();
    }

    @Override
    public List<PetOwner> findAll() {
        return null;
    }
}
