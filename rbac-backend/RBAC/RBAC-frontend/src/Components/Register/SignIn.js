import React, { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import "./Register.css";

const SignInForm = ({ onLogin }) => {
  const [userName, setName] = useState('');
  const [userPassword, setPassWord] = useState('');
  const [userRole, setRole] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    const data = { userName, userPassword, userRole };
    console.log("Data being sent:", data);

    try {
      const response = await fetch("http://localhost:8080/user/signin", {
        method: "POST",
        headers: {
          "Content-Type": "application/x-www-form-urlencoded",
        },
        body: new URLSearchParams(data), // Encode the data properly
      });

      if (response.ok) {
        console.log("Login successful");
        onLogin(); // Update the parent state to mark the user as logged in

        // Navigate based on the user role
        if (userRole === 'user') {
          navigate("/user"); // Redirect to the user dashboard
        } else if (userRole === 'admin') {
          navigate("/admin"); // Redirect to the admin dashboard
        }
      } else {
        console.log("Login failed");
        alert("Invalid username or password");
      }
    } catch (error) {
      console.log("Login failed");
      alert("Invalid username or password");
    }
  };

  return (
    <div className="wel">
      <div className="main">
        <div className="form">
          <form onSubmit={handleSubmit}>
            <div className="cont">
              <h1>Sign-In</h1>
            </div>
            <div className="name">
              <label>UserName</label>
              <input
                type="text"
                placeholder="Username"
                name="userName"
                value={userName}
                required
                onChange={(e) => setName(e.target.value)}
              />
            </div>
            <div className="name">
              <label>Password</label>
              <input
                type="password"
                placeholder="Password"
                name="userPassword"
                value={userPassword}
                required
                onChange={(e) => setPassWord(e.target.value)}
              />
            </div>
            <div className="state">
              <label>Select Role</label>
              <select
                name="userRole"
                value={userRole}
                onChange={(e) => setRole(e.target.value)}
              >
                <option value="">Select role</option>
                <option value="user">User</option>
                <option value="admin">Admin</option>
              </select>
            </div>
            <div className="register">
              <Link to="/Register">Sign-Up</Link>
            </div>
            <div className="btn" id="btn">
              <input type="submit" id="btn-2" value="Sign-In" />
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default SignInForm;
