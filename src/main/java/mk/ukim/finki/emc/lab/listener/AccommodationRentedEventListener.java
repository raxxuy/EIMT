package mk.ukim.finki.emc.lab.listener;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.emc.lab.event.AccommodationRentedEvent;
import mk.ukim.finki.emc.lab.model.domain.Accommodation;
import mk.ukim.finki.emc.lab.model.domain.AccommodationActivityLog;
import mk.ukim.finki.emc.lab.service.domain.AccommodationActivityLogService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class AccommodationRentedEventListener {
    private final AccommodationActivityLogService accommodationActivityLogService;

    public AccommodationRentedEventListener(AccommodationActivityLogService accommodationActivityLogService) {
        this.accommodationActivityLogService = accommodationActivityLogService;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    public void onAccommodationRented(AccommodationRentedEvent event) {
        Accommodation accommodation = event.accommodation();
        log.info("[ASYNC - thread: {}] Accommodation rented: [id={}, name={}, host={}]",
                Thread.currentThread().getName(),
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getHost().getName() + " " + accommodation.getHost().getSurname());

        log.warn("[ASYNC - thread: {}] Accommodation [id={}, name={}] is now fully occupied - no free rooms available.",
                Thread.currentThread().getName(),
                accommodation.getId(),
                accommodation.getName());

        accommodationActivityLogService.create(
                new AccommodationActivityLog(
                        accommodation.getId(),
                        accommodation.getName(),
                        "ACCOMMODATION_RENTED"
                )
        );
    }
}
