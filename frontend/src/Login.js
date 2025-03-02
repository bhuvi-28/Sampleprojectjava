import React, { useState } from "react";
import Profile from "./Profile";

const Login = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [loggedIn, setLoggedIn] = useState(false);

    const handleLogin = (e) => {
        e.preventDefault();
        if (email && password) {
            setLoggedIn(true);
        } else {
            alert("Enter valid details!");
        }
    };

    return loggedIn ? (
        <Profile email = {email}/>
    ) : (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleLogin}>
                <input type="email" placeholder="Email" onChange={(e) => setEmail(e.target.value)} />
                <input type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)} />
                <button type="submit">Login</button>
            </form>
        </div>
    );
};

export default Login;
