import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import api from "./services/api";
import LoginPage from "./pages/LoginPage.jsx";
import {
    BrowserRouter,
    Routes,
    Route,
    useLocation,
    Navigate,
} from "react-router-dom";

function RequireAuth({ children, requiredRole, requiredLevel }) {
    const location = useLocation();
    const [checking, setChecking] = useState(true);
    const [valid, setValid] = useState(false);
    let id = localStorage.getItem("userId");

    useEffect(() => {
        // Get user info from localStorage
        //mail
        const username = localStorage.getItem("user");
        let role = localStorage.getItem("role");
        let id = localStorage.getItem("userId");
        let accessLvl = localStorage.getItem("accessLevel");
        //checks if the local storage username and role is valid or not
        api.post("/checkValid", {
            name: username,
            role: role,
            id: id,
            accessLevel: accessLvl,
        })
            .then(() => {
                // If a requiredRole is specified, check if user has it
                if (requiredRole && role != requiredRole) {
                    console.log("Role mismatch");
                    setValid(false);
                } else {
                    setValid(true);
                }
                setChecking(false);

                if (accessLvl && accessLvl != requiredLevel) {
                    console.log("Access Permission mismatch");
                    setValid(false);
                } else {
                    setValid(true);
                }
                setChecking(false);
            })
            .catch(() => {
                setValid(false);
                setChecking(false);
            });
    }, [location, requiredRole, id, requiredLevel]);

    if (checking) return <div>Checking authentication...</div>;
    if (!valid) return <Navigate to="/login" replace />;
    return children;
}

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<LoginPage />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
