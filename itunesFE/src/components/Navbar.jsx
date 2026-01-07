import { Link } from "react-router-dom"

function Navbar(){
    return (
        <nav className="navbar">
            <div className="navbar-links">
                <Link to="/home">Home</Link>
                <Link to="/library">Library</Link>
                <Link to="/browse">Browse</Link>
                <Link to="/profile">Profile</Link>
            </div>
        </nav>
    )
}

export default Navbar