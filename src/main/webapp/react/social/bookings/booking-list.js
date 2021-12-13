import bookingService from "./booking-service"
import guestService from "../users/guest-service";
const { useState, useEffect } = React;
const {Link, useHistory, useParams} = window.ReactRouterDOM;

const BookingList = () => {

    const history = useHistory()
    const [bookings, setBookings] = useState([])

    const params = useParams();
    const gid = params['gid'];

    const findBookingByGuestId = (id) =>
        guestService.findBookingByGuestId(id)
            .then(bookings => {
                setBookings(bookings)
            })

    useEffect(() => {
        if(gid) {
            findBookingByGuestId(gid);
        } else {
            findAllBookings()
        }
    }, []);

    const findAllBookings = () =>
        bookingService.findAllBookings()
            .then(bookings => setBookings(bookings))
    return(
        <div>
            <h2>Bookings List</h2>
            <button className="btn-btn-primary" onClick={() => history.push("/bookings/new")}>
                Add Booking
            </button>
            <ul className="list-group">
                {
                    bookings.map(booking =>
                        <li key={booking.id} className="list-group-item">
                            <Link to={`/bookings/${booking.id}`}>
                                {booking.numberOfGuests},
                                {booking.payment},
                                {booking.checkInDate},
                                {booking.checkOutDate}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default BookingList;