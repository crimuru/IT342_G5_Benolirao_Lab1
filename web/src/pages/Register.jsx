import React, { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import axios from "axios";
import "../styles/auth.css";

const Register = () => {
  const navigate = useNavigate();
  
  // State must match User.java fields exactly
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleRegister = async (e) => {
    e.preventDefault();
    try {
      // Sending the JSON object to http://localhost:8080/api/auth/register
      const response = await axios.post("http://localhost:8080/api/auth/register", {
        firstName, // maps to private String firstName
        lastName,  // maps to private String lastName
        email,     // maps to private String email
        password,  // maps to private String password
      });

      alert(response.data); 
      navigate("/login");
    } catch (error) {
      console.error("Error details:", error.response?.data);
      alert("Registration failed: " + (error.response?.data || "Server error"));
    }
  };

  return (
    <div className="auth-container">
      <div className="auth-card">
        <div className="auth-header">
          <h2><span className="highlight">Milestone</span>Mind</h2>
          <p>Join to track your achievements</p>
        </div>

        <form className="auth-form" onSubmit={handleRegister}>
          <div className="input-group">
            <label>First Name</label>
            <input 
              type="text" 
              placeholder="First Name" 
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              required 
            />
          </div>
          <div className="input-group">
            <label>Last Name</label>
            <input 
              type="text" 
              placeholder="Last Name" 
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
              required 
            />
          </div>
          <div className="input-group">
            <label>Email Address</label>
            <input 
              type="email" 
              placeholder="you@example.com" 
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required 
            />
          </div>
          <div className="input-group">
            <label>Password</label>
            <input 
              type="password" 
              placeholder="Create a password" 
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required 
            />
          </div>
          <button type="submit" className="btn-auth">Create Account</button>
        </form>

        <div className="auth-footer">
          Already a member? <Link to="/login" className="auth-link">Sign In</Link>
        </div>
      </div>
    </div>
  );
};

export default Register;