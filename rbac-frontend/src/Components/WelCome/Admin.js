import React from "react";
import { useNavigate } from "react-router-dom"; // Import useNavigate
import './Admin.css'

const User = () => {
  const navigate = useNavigate(); // Initialize useNavigate hook

  const handleLogout = () => {
    // Clear any authentication tokens or session data
    localStorage.removeItem("authToken"); 
    sessionStorage.clear(); 

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
        <h1 >Welcome to the admin</h1>
        <table>
            <tr>
                <th>UserId</th>
                <th>userName</th>
                <th>UserEmail</th>
                <th>UserRole</th>
                <th>UserContact</th>
            </tr>
            <tr>
                <td class=""></td>
                <td class=""></td>
                <td class=""></td>
                <td class=""></td>
                <td class=""></td>
       
            </tr>
         </table>
    </div>
    </>
  );
};

export default User;
