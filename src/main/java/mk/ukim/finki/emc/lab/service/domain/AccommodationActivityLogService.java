package mk.ukim.finki.emc.lab.service.domain;

import mk.ukim.finki.emc.lab.model.domain.AccommodationActivityLog;
import org.springframework.data.domain.Page;

public interface AccommodationActivityLogService {
    Page<AccommodationActivityLog> findAll(int page, int size, String sortBy);
    AccommodationActivityLog create(AccommodationActivityLog accommodationActivityLog);
}
