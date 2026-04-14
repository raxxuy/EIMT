package mk.ukim.finki.emc.lab.service.domain.impl;

import mk.ukim.finki.emc.lab.model.domain.Host;
import mk.ukim.finki.emc.lab.model.exception.HostNotFoundException;
import mk.ukim.finki.emc.lab.repository.HostRepository;
import mk.ukim.finki.emc.lab.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public Host findById(Long id) {
        return hostRepository
                .findById(id)
                .orElseThrow(() -> new HostNotFoundException(id));
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }
}
