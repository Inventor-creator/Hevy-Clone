import { useNavigate } from "react-router-dom";

const ErrorPage = () => {
    const navigate = useNavigate();

    const temp = () => {
        navigate("/");
    };

    return (
        <>
            <h1>Error</h1>
            <button onClick={temp}> Go Back </button>
        </>
    );
};

export default ErrorPage;
