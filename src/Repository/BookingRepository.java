package Repository;

import Entity.Booking;
/**
 * Repository that encapsulate the logic required to access the data sources for booking.
 * 
 */
public class BookingRepository extends Repository<Booking> {

    public BookingRepository(String fileName) {
        super(fileName);
    }
    
}
