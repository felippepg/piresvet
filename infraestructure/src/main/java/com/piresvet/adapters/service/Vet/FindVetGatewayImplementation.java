package com.piresvet.adapters.service.Vet;

import com.piresvet.core.domain.Vet;
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
        var vet = repository.findById(id);
        return Optional.ofNullable(mapper.toDomain(vet.get()));
    }

    @Override
    public List<Vet> findByFullname(String firstname, String lastname) {
        return null;
    }

    @Override
    public Optional<Vet> findByCrm(String crmv) {
        return Optional.empty();
    }

    @Override
    public List<Vet> findAvailable() {
        return null;
    }

    @Override
    public List<Vet> findAll() {
        return repository.findAll().stream()
                .map(vetEntity -> mapper.toDomain(vetEntity))
                .collect(Collectors.toList());
    }
}
