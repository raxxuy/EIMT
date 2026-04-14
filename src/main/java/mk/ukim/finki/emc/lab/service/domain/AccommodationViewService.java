package mk.ukim.finki.emc.lab.service.domain;

import mk.ukim.finki.emc.lab.model.view.AccommodationView;

import java.util.List;

public interface AccommodationViewService {
    List<AccommodationView> findAll();
}
