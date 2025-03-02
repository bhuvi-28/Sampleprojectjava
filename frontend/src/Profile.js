import { useEffect, useState } from "react";

const Profile = ({ email }) => {
    const [user, setUser] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        if (!email) {
            setError("Email is missing!");
            return;
        }

        fetch(`http://localhost:8080/api/users/${email}`)
            .then(res => {
                if (!res.ok) throw new Error("Failed to fetch user");
                console.log('response',res);
                return res.json();

            })
            .then(data => setUser(data))
            .catch(err => {
                console.error("Error fetching user:", err);
                setError(err.message);
            });
    }, [email]);
console.log('usr',user);
console.log('name',user.user.name)
    if (error) return <p>Error : {error}</p>;
    if (!user) return <p>Loading...</p>;

    return (
        <div>
            <h1>{user.user.name}'s Profile</h1>
            <p>Email: {user.user.email}</p>
            <p>Age: {user.user.age}</p>
            <p>Birthday: {user.user.birthday}</p>
            <h2>Friends</h2>
            <ul>
                {user.friends && user.friends.map(friend => (
                    <li key={friend.id}>{friend.name} - {friend.email}</li>
                ))}
            </ul>
        </div>
    );
};

export default Profile;
