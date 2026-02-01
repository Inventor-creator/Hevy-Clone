import { useState } from "react";

const LoginPage = () => {
    localStorage.clear();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = () => {
        window.location.href =
            "http://localhost:8080/oauth2/authorization/google";
    };

    return (
        <>
            <p>testing login page</p>
            <h1>somethings</h1>
            <button onClick={handleLogin}>Login</button>
        </>
    );
};

export default LoginPage;
