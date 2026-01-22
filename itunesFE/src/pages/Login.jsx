import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {
    const navigate = useNavigate();

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    async function handleSubmit(e) {
        e.preventDefault();
        setError("");

        try {
            const res = await fetch("http://localhost:8080/auth/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    email,
                    password,
                }),
            });

            if (!res.ok) {
                setError("Invalid email or password");
                return;
            }

            const data = await res.json();
            navigate("/home");
        } catch (err) {
            setError("Could not reach, backend isssue");
        }
    }

    return (
        <div className="login">
            <div className="login-bg" />

            <main className="login-card" role="main">
                <div className="login-brand">
                    <div className="login-logo">♪</div>
                    <div>
                        <h1 className="login-title">Sign in</h1>
                        <p className="login-subtitle">Welcome back</p>
                    </div>
                </div>

                <form className="login-form" onSubmit={handleSubmit}>
                    <label className="login-label">
                        Email
                        <input
                            className="login-input"
                            type="email"
                            placeholder="yourEmail@example.com"
                            autoComplete="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                        />
                    </label>

                    <label className="login-label">
                        Password
                        <input
                            className="login-input"
                            type="password"
                            placeholder="**********"
                            autoComplete="current-password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </label>

                    <div className="login-row">
                        <label className="login-checkbox">
                            <input type="checkbox" />
                            <span>Remember me</span>
                        </label>

                        <button type="button" className="login-linkBtn">
                            Forgot password?
                        </button>
                    </div>

                    <button className="login-button" type="submit">
                        Sign in
                    </button>

                    {error && <p className="login-error">{error}</p>}

                    <p className="login-footer">
                        Don't have an account?
                        <button type="button" className="login-linkBtn">
                            Create account
                        </button>
                    </p>


                </form>

            </main>
        </div>
    )
}

export default Login;