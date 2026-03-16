package mk.ukim.finki.emc.lab.service.domain;

import mk.ukim.finki.emc.lab.model.domain.Host;

import java.util.List;

public interface HostService {
    Host findById(Long id);

    List<Host> findAll();

    Host create(Host host);

    Host update(Long id, Host host);

    Host deleteById(Long id);
}
