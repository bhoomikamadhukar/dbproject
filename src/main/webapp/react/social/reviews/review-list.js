import reviewService from "./review-service"
const { useState, useEffect } = React;
const {Link, useHistory} = window.ReactRouterDOM;

const ReviewList = () => {
    const history = useHistory()
    const [reviews, setReviews] = useState([])
    useEffect(() => {
        findAllReviews()
    }, [])
    const findAllReviews = () =>
        reviewService.findAllReviews()
            .then(reviews => setReviews(reviews))
    return(
        <div>
            <h2>Reviews List</h2>
            <button className="btn-btn-primary" onClick={() => history.push("/reviews/new")}>
                Add Review
            </button>
            <ul className="list-group">
                {
                    reviews.map(review =>
                                   <li key={review.id} className="list-group-item">
                                       <Link to={`/reviews/${review.id}`}>
                                           {review.comments},
                                           {review.likes},
                                       </Link>
                                   </li>)
                }
            </ul>
        </div>
    )
}

export default ReviewList;