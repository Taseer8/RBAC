import React from "react";
import { useNavigate } from "react-router-dom"; // Import useNavigate

const User = () => {
  const navigate = useNavigate(); // Initialize useNavigate hook

  const handleLogout = () => {
    // Clear any authentication tokens or session data
    localStorage.removeItem("authToken"); // Example: Remove token from localStorage
    sessionStorage.clear(); // Clear session data if any

    // Navigate to the sign-in page
    navigate("/signin");
  };

  return (
    <>
      <div className="nav">
        <div className="logo">
          <a href="/" className="">
            <h1>Logo</h1>
          </a>
        </div>
        <div className="nav-elements">
          <div id="elements">
            <button className="btn" onClick={handleLogout}>Sign-out</button>
          </div>
        </div>
      </div>
      <div>
        <h1>Welcome to the User</h1>
      </div>
    </>
  );
};

export default User;
