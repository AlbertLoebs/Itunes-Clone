import { useNavigate } from "react-router-dom";

function Login() {
    const navigate = useNavigate();

    const handleLogin = () => {
        navigate("/home");
    }

    return (
     <div className="login">
        <h1>Login Page</h1>
        <button onClick={handleLogin}>Login</button>
     </div>   
    )
}

export default Login;