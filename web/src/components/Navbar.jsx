import React from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import "../styles/navbar.css";

const Navbar = () => {
  const location = useLocation();
  const navigate = useNavigate();

  // Hide Navbar on Landing, Login, and Register pages
  const hideOnPages = ["/", "/login", "/register"];
  if (hideOnPages.includes(location.pathname)) return null;

  return (
    <nav className="app-navbar">
      <div className="nav-container">
        <div className="nav-logo" onClick={() => navigate("/dashboard")}>
          <span className="highlight">Milestone</span>Mind
        </div>
        
        <div className="nav-links">
          <Link to="/dashboard" className={location.pathname === "/dashboard" ? "active" : ""}>
            Dashboard
          </Link>
          <Link to="/profile" className={location.pathname === "/profile" ? "active" : ""}>
            Profile
          </Link>
        </div>

        <div className="nav-user-section">
          <button className="nav-logout-btn" onClick={() => navigate("/login")}>
            Logout
          </button>
          <div className="nav-avatar" onClick={() => navigate("/profile")}>
            👤
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;