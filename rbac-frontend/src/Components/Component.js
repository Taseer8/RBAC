import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Navbar from './NavBar/Navbar';
import Register from './Register/Register';
import SignIn from './Register/SignIn';
import UserDashboard from './WelCome/User';  // Assuming this is your user dashboard component
import Admin from './WelCome/Admin';

const Component = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false); 
  const [userRole, setUserRole] = useState(''); // Track the user's role

  // Function to handle login, set user role
  const handleLogin = (role) => {
    console.log("User logged in as:", role); // Debugging log
    setIsLoggedIn(true);
    setUserRole(role); // Set user role after login
  };

  // Function to handle logout
  const handleLogout = () => {
    console.log("User logged out"); // Debugging log
    setIsLoggedIn(false);
    setUserRole(''); // Clear the user role on logout
  };

  return (
    <div>
      <Router>
        {/* Conditionally render Navbar */}
        {!isLoggedIn && <Navbar onLogout={handleLogout} />}

        <Routes>
          {/* Public Routes */}
          <Route path="/register" element={<Register />} />
          <Route path="/signin" element={<SignIn onLogin={handleLogin} />} />

          {/* Protected Route for Dashboards */}
          <Route
            path="/dashboard"
            element={
              isLoggedIn ? (
                userRole === 'user' ? (
                  <UserDashboard onLogout={handleLogout} /> // Redirect to user dashboard if role is 'user'
                ) : (
                  <Admin onLogout={handleLogout} /> // Redirect to admin dashboard if role is 'admin'
                )
              ) : (
                <Navigate to="/signin" replace /> // Redirect to sign-in if not logged in
              )
            }
          />

          {/* Default Redirect */}
          {/* {!isLoggedIn && <Navbar onLogout={handleLogout} />} */}
          <Route
            path="*"
            element={<Navigate to={isLoggedIn ? "/dashboard" : "/signin"} replace />}
          />
        </Routes>
      </Router>
    </div>
  );
};

export default Component;
