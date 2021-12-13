// TODO: declare URL where server listens for HTTP requests

const GUESTS_URL = "http://localhost:8080/api/guests"
const BOOKINGS_URL = "http://localhost:8080/api/bookings"

// TODO: retrieve all users from the server
export const findAllGuests = () =>
    fetch(GUESTS_URL)
        .then(response => response.json())

// TODO: retrieve a single user by their ID
export const findGuestById = (id) =>
    fetch(`${GUESTS_URL}/${id}`)
        .then(response => response.json())
//
export const findBookingByGuestId = (id) =>
    fetch(`${BOOKINGS_URL}/guest/${id}`)
        .then(response => response.json())

// TODO: delete a user by their ID
export const deleteGuest = (id) =>
    fetch(`${GUESTS_URL}/${id}`, {
        method: "DELETE"
    })

// TODO: create a new user
export const createGuest = (guest) =>
    fetch(GUESTS_URL, {
        method: 'POST',
        body: JSON.stringify(guest),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())


// TODO: update a user by their ID
export const updateGuest = (id, guest) =>
    fetch(`${GUESTS_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(guest),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())


// TODO: export all functions as the API to this service
export default {
    findAllGuests,
    findGuestById,
    deleteGuest,
    createGuest,
    updateGuest,
   findBookingByGuestId
}
