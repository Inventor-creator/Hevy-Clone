import { Link, useLocation, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

const Navbar = () => {
    const location = useLocation();
    const navigate = useNavigate();
    // const [username, setUsername] = useState("");
    // const [userRole, setRole] = useState("");

    useEffect(() => {}, [location]);

    const linkStyle = (paths) => {
        const match = Array.isArray(paths)
            ? paths.includes(location.pathname)
            : location.pathname === paths;
        return {
            marginRight: "2rem",
            fontWeight: "bold",
            fontSize: "1.1rem",
            textDecoration: "none",
            color: match ? "#00ffea" : "#fff",
            textShadow: match ? "0 0 8px #00ffea" : "none",
            transition: "color 0.2s",
        };
    };

    const handleUsernameClick = () => {
        navigate("/login");
    };

    return (
        <nav
            style={{
                position: "fixed",
                top: 0,
                left: 0,
                width: "100%",
                zIndex: 1000,
                display: "flex",
                alignItems: "center",
                padding: "1rem 2rem",
                background: "#222",
                borderBottom: "2px solid #424242ff",
                boxShadow: "0 2px 8px rgba(0,0,0,0.05)",
                borderRadius: "8px 8px 8px 8px",
                marginLeft: "4px",
                marginRight: "4px",
            }}
        >
            <div>
                <Link to="/" style={linkStyle("/")}>
                    Home
                </Link>
            </div>
            <div>
                <Link to="/" style={linkStyle("/")}>
                    Home
                </Link>
            </div>
        </nav>
    );
};

export default Navbar;
