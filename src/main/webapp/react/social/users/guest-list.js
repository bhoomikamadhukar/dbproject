import guestService from "./guest-service"
const { useState, useEffect } = React;
const {Link, useHistory} = window.ReactRouterDOM;

const GuestList = () => {
    const history = useHistory()
    const [guests, setGuests] = useState([])
    useEffect(() => {
        findAllGuests()
    }, [])
    const findAllGuests = () =>
        guestService.findAllGuests()
            .then(guests => setGuests(guests))
    return(
        <div>
            <h2>Guests List</h2>
            <button className="btn-btn-primary" onClick={() => history.push("/guests/new")}>
                Add Guest
            </button>
            <ul className="list-group">
                {
                    guests.map(guest =>
                        <li key={guest.id} className="list-group-item">
                            <Link to={`/guests/${guest.id}`}>
                            {guest.firstName},
                            {guest.lastName},
                            {guest.email},
                            {guest.dob},
                            {guest.gender}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default GuestList;