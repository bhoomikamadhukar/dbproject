// TODO: declare URL where server listens for HTTP requests
const REVIEWS_URL = "http://localhost:8080/api/reviews"

// TODO: retrieve all users from the server
export const findAllReviews = () =>
    fetch(REVIEWS_URL)
        .then(response => response.json())

// TODO: retrieve a single user by their ID
export const findReviewById = (id) =>
    fetch(`${REVIEWS_URL}/${id}`)
        .then(response => response.json())


// TODO: delete a user by their ID
export const deleteReview = (id) =>
    fetch(`${REVIEWS_URL}/${id}`, {
        method: "DELETE"
    })

// TODO: create a new user
export const createReview = (review) =>
    fetch(REVIEWS_URL, {
        method: 'POST',
        body: JSON.stringify(review),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())


// TODO: update a user by their ID
export const updateReview = (id, review) =>
    fetch(`${REVIEWS_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(review),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())


// TODO: export all functions as the API to this service
export default {
    findAllReviews,
    findReviewById,
    deleteReview,
    createReview,
    updateReview
}
