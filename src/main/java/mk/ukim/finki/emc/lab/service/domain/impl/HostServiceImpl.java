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

    @Override
    public Host create(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public Host update(Long id, Host host) {
        Host existing = findById(id);
        existing.setName(host.getName());
        existing.setSurname(host.getSurname());
        existing.setCountry(host.getCountry());
        return hostRepository.save(existing);
    }

    @Override
    public Host deleteById(Long id) {
        Host host = findById(id);
        hostRepository.delete(host);
        return host;
    }
}
