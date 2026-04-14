package mk.ukim.finki.emc.lab.service.domain;

import mk.ukim.finki.emc.lab.model.view.AccommodationStatsView;

import java.util.List;

public interface AccommodationStatsViewService {
    List<AccommodationStatsView> findAll();
}
