package pojos;

public class BookingResponseBodyPojo {
    /*
    1. tum key ler icin private veriable lar olusturuyoruz
    2. tum parametrelerle ve bir de parametresiz constructor larimizi olusturuyoruz
    3. Getters ve setters lar olusturulur
    4. toString() methodu olusturulur
     */

    // 1. adim; tum key ler icin private veriable lar olusturuyoruz

    private Integer bookingId;
    private BookingPojo booking;

    // 2. adim; tum parametrelerle ve bir de parametresiz constructor larimizi olusturuyoruz

    public BookingResponseBodyPojo(Integer bookingId, BookingPojo booking) {
        this.bookingId = bookingId;
        this.booking = booking;
    }

    public BookingResponseBodyPojo() {
    }

    // 3. adim; Getters ve setters lar olusturulur

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    // 4.adim ; toString() methodu olusturulur

    @Override
    public String toString() {
        return "BookingResponseBodyPojo{" +
                "bookingId=" + bookingId +
                ", booking=" + booking +
                '}';
    }
}
