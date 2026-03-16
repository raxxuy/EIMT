package mk.ukim.finki.emc.lab.model.dto;

import mk.ukim.finki.emc.lab.model.domain.Host;

import java.util.List;

public record DisplayHostDto(
        Long id,
        String fullName,
        String country
) {
    public static DisplayHostDto from(Host host) {
        return new DisplayHostDto(
                host.getId(),
                "%s %s".formatted(host.getName(), host.getSurname()),
                host.getCountry().getName()
        );
    }

    public static List<DisplayHostDto> from(List<Host> hosts) {
        return hosts.stream().map(DisplayHostDto::from).toList();
    }
}
