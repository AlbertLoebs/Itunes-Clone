import { useNavigate } from "react-router-dom";

function Login() {
    const navigate = useNavigate();

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

                <form className="login-form">
                    <label className="login-label">
                        Email
                        <input
                            className="login-input"
                            type="email"
                            placeholder="yourEmail@example.com"
                            autoComplete="email"
                        />
                    </label>

                    <label className="login_label">
                        Password
                        <input
                            className="login-input"
                            type="password"
                            placeholder="**********"
                            autoComplete="current-password"
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

                    <button className="login-button" type="submit" onClick={() => navigate("/home")}>
                        Sign in
                    </button>

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