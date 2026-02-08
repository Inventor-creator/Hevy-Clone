import { useState } from "react";
import api from "../services/api";

const LoginPage = () => {
    localStorage.clear();
    const [disabled, setDisabled] = useState(false);

    const handleLogin = async () => {
        window.location.href =
            "http://localhost:8080/oauth2/authorization/google";

        setDisabled(true);
    };

    return (
        <>
            <p>testing login page</p>
            <h1>somethings</h1>
            <button onClick={handleLogin} disabled={disabled}>
                Login
            </button>
        </>
    );
};

export default LoginPage;
