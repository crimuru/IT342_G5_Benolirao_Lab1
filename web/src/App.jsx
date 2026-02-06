import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Landing from "./pages/Landing";

import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import Profile from "./pages/Profile";
import AchievementForm from "./pages/AchievementForm";
import Navbar from "./components/Navbar";



//import ProfileSettings from "./pages/profile";
//import AccountSettings from "./pages/AccountSettings";



export default function App() {
  return (
    <Router>
      <Navbar />
    
      <Routes>
      <Route path="/" element={<Landing />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/profile" element={<Profile />} />
            <Route path="/add" element={<AchievementForm/>} />
       
        

      </Routes>
    </Router>
  );
}



