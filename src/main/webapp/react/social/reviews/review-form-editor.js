import reviewService from "./review-service"
const {useState, useEffect} = React;
const {useParams, useHistory} = window.ReactRouterDOM;

const ReviewFormEditor = () => {
    const {id} = useParams()
    const [review, setReview] = useState({})
    useEffect(() => {
        if(id !== "new") {

            findReviewById(id)
        }
    }, []);
    const createReview = (review) =>
        reviewService.createReview(review)
            .then(() => history.back())
    const findReviewById = (id) =>
        reviewService.findReviewById(id)
            .then(review => setReview(review))
    const deleteReview = (id) =>
        reviewService.deleteReview(id)
            .then(() => history.back())
    const updateReview = (id, newReview) =>
        reviewService.updateReview(id, newReview)
            .then(() => history.back())
    return (
        <div>
            <h2>Review Editor</h2>
            <label>Id</label>
            <input className="form-control"
                   value={review.id}/><br/>
            <label>Comments</label>
            <input className="form-control" onChange={(e) =>
                setReview(review =>
                             ({...review, comments: e.target.value}))} value={review.comments}/><br/>
            <label>likes</label>
            <input className="form-control" onChange={(e) =>
                setReview(review =>
                             ({...review, likes: e.target.value}))} value={review.likes}/><br/>
            <button className="btn btn-warning" onClick={() => {
                history.back()}}
            >Cancel</button>
            <button className="btn btn-danger" onClick={() => deleteReview(review.id)}>Delete</button>
            <button className="btn btn-primary" onClick={() => updateReview(review.id, review)}>Save</button>
            <button className="btn btn-success" onClick={() => createReview(review)}>Create</button>
        </div>
    )
}

export default ReviewFormEditor