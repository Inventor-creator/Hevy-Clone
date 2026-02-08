import { useState, useContext } from "react";
import { useEffect } from "react";
import Navbar from "./components/Navbar.jsx";
import "./App.css";
import api from "./services/api";
import LoginPage from "./pages/LoginPage.jsx";
import ErrorPage from "./pages/ErrorPage.jsx";
import Dashboard from "./pages/Dashboard.jsx";
import { AuthContext } from "./util/AuthContext.jsx";

import {
    BrowserRouter,
    Routes,
    Route,
    useLocation,
    Navigate,
} from "react-router-dom";

function RequireAuth({ children, requiredRole }) {
    const location = useLocation();
    const { user, setUser, loading, setLoading } = useContext(AuthContext);
    const [valid, setValid] = useState(false);

    const role = user.role;

    useEffect(() => {
        setLoading(true);
        if (requiredRole && role != requiredRole) {
            console.log("Role mismatch");
            setValid(false);
        } else {
            setValid(true);
        }

        setLoading(false);
    }, [requiredRole, user, loading, role]);

    if (loading) return <div>Checking authentication...</div>;
    if (!valid) return <Navigate to="/login" replace />;
    return children;
}

function App() {
    return (
        <>
            <BrowserRouter>
                <Navbar />
                <Routes>
                    <Route path="/" element={<Dashboard />} />
                    <Route path="/login" element={<LoginPage />} />

                    <Route
                        path="/idk"
                        element={
                            <RequireAuth requiredRole="user">
                                <p> fuck yeah</p>
                            </RequireAuth>
                        }
                    />
                    <Route path="/shit" element={<ErrorPage />} />
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
