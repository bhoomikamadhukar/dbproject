import guestService from "./guest-service"
import bookingService from "../bookings/booking-service"
const {useState, useEffect} = React;
const {useParams, useHistory, Link} = window.ReactRouterDOM;

const GuestFormEditor = () => {
        const {id} = useParams()
        const [guest, setGuest] = useState({})
        const [bookings, setBookings] = useState([])
        useEffect(() => {
                if(id !== "new") {

                        findGuestById(id)
                }
        }, []);
        const createGuest = (guest) =>
            guestService.createGuest(guest)
                .then(() => history.back())
        const findGuestById = (id) =>
            guestService.findGuestById(id)
                .then(guest => setGuest(guest))
        const deleteGuest = (id) =>
            guestService.deleteGuest(id)
                .then(() => history.back())
        const updateGuest = (id, newGuest) =>
            guestService.updateGuest(id, newGuest)
                .then(() => history.back())
        const bookingsForGuest = (id) =>
            guestService.findBookingByGuestId(id)
                .then(booking => setBookings(bookings))
        return (
        <div>
            <h2>Guest Editor</h2>
            <label>Id</label>
            <input className="form-control"
                   value={guest.id}/><br/>
            <label>First Name</label>
            <input className="form-control" onChange={(e) =>
                setGuest(guest =>
                             ({...guest, firstName: e.target.value}))} value={guest.firstName}/><br/>
            <label>Last Name</label>
            <input className="form-control" onChange={(e) =>
                setGuest(guest =>
                             ({...guest, lastName: e.target.value}))} value={guest.lastName}/><br/>
            <label>Email</label>
            <input className="form-control" onChange={(e) =>
                setGuest(guest =>
                             ({...guest, email: e.target.value}))} value={guest.email}/><br/>
            <label>Password</label>
            <input className="form-control" onChange={(e) =>
                setGuest(guest =>
                             ({...guest, password: e.target.value}))} value={guest.password}/><br/>
            <label>Date of Birth</label>
                <input className="form-control" onChange={(e) =>
                    setGuest(guest =>
                                 ({...guest, dob: e.target.value}))} value={guest.dob}/><br/>
                <label>Gender</label>
                <input className="form-control" onChange={(e) =>
                    setGuest(guest =>
                                 ({...guest, gender: e.target.value}))}value={guest.gender}/><br/>
            <button className="btn btn-warning" onClick={() => {
                    history.back()}}
            >Cancel</button>
            <button className="btn btn-danger" onClick={() => deleteGuest(guest.id)}>Delete</button>
            <button className="btn btn-primary" onClick={() => updateGuest(guest.id, guest)}>Save</button>
            <button className="btn btn-success" onClick={() => createGuest(guest)}>Create</button>
            {/*<button className="btn btn-success" onClick={() => bookingsForGuest(guest.id)}>View all Bookings</button>*/}
            <Link to={`/guests/${guest.id}/bookings`}>
                Guest bookings
            </Link>
        </div>
    )
}

export default GuestFormEditor