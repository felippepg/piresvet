package com.piresvet.adapters.service.Vet;

import com.piresvet.core.domain.Vet;
import com.piresvet.core.exception.PetOwnerNotFoundException;
import com.piresvet.core.exception.VetNotFoundException;
import com.piresvet.dataMapper.VetMapper;
import com.piresvet.gatewayContracts.Vet.FindVetGateway;
import com.piresvet.persistence.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindVetGatewayImplementation implements FindVetGateway {
    private final VetRepository repository;
    private final VetMapper mapper;


    @Override
    public Optional<Vet> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Vet> findByFullname(String firstname, String lastname) {
        var vet = repository.findByFirstnameIgnoreCaseAndLastnameIgnoreCase(firstname, lastname);
        return vet.stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Vet> findByCrm(String crmv) {
        return repository.findByCrmv(crmv).map(mapper::toDomain);
    }

    @Override
    public List<Vet> findAvailable() {
        return repository.findByAvailableTrue().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Vet> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Vet> findByName(String firstname) {
        var vet = repository.findByFirstnameIgnoreCase(firstname);
        return vet.stream().map(mapper::toDomain).collect(Collectors.toList());
    }
}
