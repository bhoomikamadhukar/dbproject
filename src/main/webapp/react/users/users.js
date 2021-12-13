// import User from "./user";
// import {findAllGuests} from "../social/users/guest-service";
//
// const { useState, useEffect } = React;
//
// const Users = () => {
//     const [guests, setGuests] = useState([])
//     const [newGuest, setNewGuests] = useState({})
//     const createUser = (user) =>
//         fetch(`https://wbdv-generic-server.herokuapp.com/api/jannunzi/users`, {
//             method: 'POST',
//             body: JSON.stringify(user),
//             headers: {'content-type': 'application/json'}
//         })
//             .then(response => response.json())
//             .then(user => setUsers(users => ([...users, user])))
//     const updateUser = (id, newUser) =>
//         fetch(`http://localhost:8080/orm/update/user/${id}/${newUser.password}`)
//             .then(response => response.json())
//             .then(user => setUsers(users => (users.map(user => user._id === id ? newUser : user))))
//     const findAllUsers = () =>
//         fetch(`http://localhost:8080/api/guests`)
//             .then(response => response.json())
//             .then(guests => setGuests(guests))
//     const deleteUser = (id) =>
//         fetch(`https://wbdv-generic-server.herokuapp.com/api/jannunzi/users/${id}`, {
//             method: "DELETE"
//         })
//             .then(response => response.json())
//             .then(users => setUsers(users => users.filter(user => user._id !== id)))
//     useEffect(() => {
//         findAllGuests()
//     }, [])
//     return(
//         <div>
//             <h2>Users {guests.length}</h2>
//             <input value={newGuest.title}
//                    onChange={(e) => setNewGuests(newGuest => ({...newGuest, title: e.target.value}))}/>
//             <input value={newGuest.owner}
//                    onChange={(e) => setNewGuests(newGuest => ({...newGuest, owner: e.target.value}))}/>
//             <button onClick={() => createUser(newGuest)}>Create</button>
//             {
//                 guests.map(guest =>
//                     <User key={guest._id}
//                         updateUser={updateUser}
//                         deleteUser={deleteUser}
//                         guest={guest}/>)
//             }
//         </div>
//     )
// }
//
// export default Users;
//
//
