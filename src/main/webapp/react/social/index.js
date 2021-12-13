import GuestList from "./users/guest-list";
import GuestFormEditor from "./users/guest-form-editor";
import BookingList from "./bookings/booking-list";
import BookingFormEditor from "./bookings/booking-form-editor";
import ReviewList from "./reviews/review-list";
import ReviewFormEditor from "./reviews/review-form-editor";

const {HashRouter, Route} = window.ReactRouterDOM; 
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/guests", "/"]} exact={true}>
                    <GuestList/>
                </Route>
                <Route path={["/bookings", "/guests/:gid/bookings"]} exact={true}>
                    <BookingList/>
                </Route>
                {/*<Route path = {["/bookings",]} exact = {true}>*/}
                {/*    <BookingList/>*/}
                {/*</Route>*/}
                <Route path={["/reviews"]} exact={true}>
                    <ReviewList/>
                </Route>
                <Route path="/guests/:id" exact={true}>
                    <GuestFormEditor/>
                </Route>
                <Route path="/bookings/:id" exact={true}>
                    <BookingFormEditor/>
                </Route>
                <Route path="/reviews/:id" exact={true}>
                    <ReviewFormEditor/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
