const BOOKINGS_URL = "http://localhost:8080/api/bookings"

// TODO: retrieve all users from the server
export const findAllBookings = () =>
    fetch(BOOKINGS_URL)
        .then(response => response.json())

// TODO: retrieve a single user by their ID
export const findBookingById = (id) =>
    fetch(`${BOOKINGS_URL}/${id}`)
        .then(response => response.json())

/*// TODO: retrieve a single user by their ID
export const findBookingByGuestId = (id) =>
    fetch(`${Booking_guest_url}/${id}`)
        .then(response => response.json())*/

// TODO: delete a user by their ID
export const deleteBooking = (id) =>
    fetch(`${BOOKINGS_URL}/${id}`, {
        method: "DELETE"
    })

// TODO: create a new user
export const createBooking = (booking) =>
    fetch(BOOKINGS_URL, {
        method: 'POST',
        body: JSON.stringify(booking),
        headers: {'Content-Type': 'application/json'}
    })
        .then(response => response.json())


// TODO: update a user by their ID
export const updateBooking = (id, bookings) =>
    fetch(`${BOOKINGS_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(bookings),
        headers: {'Content-Type': 'application/json'}
    })
        .then(response => response.json())

// TODO: export all functions as the API to this service
export default {
    findAllBookings,
    findBookingById,
    deleteBooking,
    createBooking,
    updateBooking,
}