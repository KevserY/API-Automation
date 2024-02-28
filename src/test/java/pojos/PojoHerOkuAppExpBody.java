package pojos;

public class PojoHerOkuAppExpBody {
    /*
    {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10",
                        "additionalneeds":"wi-fi"
                    }
     */
    private int bookingid;
    private PojoHerOkuAppRequestBody booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public PojoHerOkuAppRequestBody getBooking() {
        return booking;
    }

    public void setBooking(PojoHerOkuAppRequestBody booking) {
        this.booking = booking;
    }

    public PojoHerOkuAppExpBody(int bookingid, PojoHerOkuAppRequestBody booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public PojoHerOkuAppExpBody() {
    }

    @Override
    public String toString() {
        return "PojoHerOkuAppExpBody{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
