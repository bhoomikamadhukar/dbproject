
import bookingService, {findBookingById} from "../bookings/booking-service"
const {useState, useEffect} = React;
const {useParams, useHistory} = window.ReactRouterDOM;

const BookingFormEditor = () => {
    const {id} = useParams()
    const [bookings, setBookings] = useState({})
    useEffect(() => {
        if(id !== "new") {

            findBookingById(id)
        }
    }, []);
    const createBooking = (booking) =>
        bookingService.createBooking(booking)
            .then(() => history.back())
    const findBookingById = (id) =>
        bookingService.findBookingById(id)
            .then(bookings => setBookings(bookings))
    const deleteBooking = (id) =>
        bookingService.deleteBooking(id)
            .then(() => history.back())
    const updateBooking = (id, newBooking) =>
        bookingService.updateBooking(id, newBooking)
            .then(() => history.back())


    return (
        <div>
            <h2>Booking Editor</h2>
            <label>Id</label>
            <input className="form-control"
                   value={bookings.id}/><br/>
            <label>Number of guests</label>
            <input className="form-control" onChange={(e) =>
                setBookings(bookings =>
                    ({...bookings, numberOfGuests: e.target.value}))} defaultValue={2} value={bookings.numberOfGuests || ''}/><br/>
            <label>Payment</label>
            <input className="form-control" onChange={(e) =>
                setBookings(bookings =>
                    ({...bookings, payment: e.target.value}))} defaultValue={'cash'} value={bookings.payment}/><br/>
            <label>Check In</label>
            <input className="form-control" onChange={(e) =>
                setBookings(bookings =>
                    ({...bookings, checkin: e.target.value}))} value={bookings.checkin}/><br/>
            <label>Checkout</label>
            <input className="form-control" onChange={(e) =>
                setBookings(bookings =>
                    ({...bookings, checkout: e.target.value}))} value={bookings.checkout}/><br/>

            <button className="btn btn-warning" onClick={() => {
                history.back()}}
            >Cancel</button>
            <button className="btn btn-danger" onClick={() => deleteBooking(bookings.id)}>Delete</button>
            <button className="btn btn-primary" onClick={() => updateBooking(bookings.id, bookings)}>Save</button>
            <button className="btn btn-success" onClick={() => createBooking(bookings)}>Create</button>
            <button className="btn btn-success" onClick={() => b(guest.id)}>View all bookings</button>
        </div>
    )
}

export default BookingFormEditor