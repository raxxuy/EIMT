package mk.ukim.finki.emc.lab.job;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.emc.lab.repository.AccommodationStatsViewRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MaterializedViewRefreshScheduler {
    private final AccommodationStatsViewRepository accommodationStatsViewRepository;

    public MaterializedViewRefreshScheduler(AccommodationStatsViewRepository accommodationStatsViewRepository) {
        this.accommodationStatsViewRepository = accommodationStatsViewRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void refreshAccommodationStatsView() {
        log.info("Refreshing ACCOMMODATION_STATS_VIEW...");
        accommodationStatsViewRepository.refresh();
        log.info("ACCOMMODATION_STATS_VIEW successfully refreshed.");
    }
}
