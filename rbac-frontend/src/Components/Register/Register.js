import React, { useState } from "react";
import "./Register.css";

import { useNavigate, Link} from "react-router-dom";

const SignUpForm = () => {
  const [userName, setName] = useState("");
  const [userEmail, setEmail] = useState("");
  const [userPassWord, setPassword] = useState("");
  const [userRole, setRole] = useState("");
  const [contactNumber, setContactNumber] = useState("");
  
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    const data = {
      userName,
      userEmail,
      userPassWord,
      userRole,
      contactNumber,
    };

    try {
      const response = await fetch("http://localhost:8080/user/save", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      });

      if (response.ok) {
        const result = await response.text();
        navigate("/User")
        alert("Registration successful: " + result);
        // navigate("/User")
      }
    } catch (error) {
      console.error("Error:", error);
      alert("An error occurred while Registration .");
    }
  };

  return (
    <div className="wel">
      <div className="main">
        <div className="form">
          <form onSubmit={handleSubmit}>
            <div className="cont">
              <h1>Sign-Up</h1>
            </div>
            <div className="name">
              <label>UserName</label>
              <input
                type="text"
                placeholder="username"
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
                placeholder="password"
                name="userPassWord"
                value={userPassWord}
                required
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>
            <div className="name">
              <label>Email</label>
              <input
                type="email"
                placeholder="email"
                name="userEmail"
                value={userEmail}
                required
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>
            <div className="name">
              <label>Phone Number</label>
              <input
                type="tel"
                placeholder="enter your number"
                name="contactNumber"
                value={contactNumber}
                required
                onChange={(e) => setContactNumber(e.target.value)}
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
            <div className="name">
              <p>
                <Link to="/SignIn">Sign in</Link>
              </p>
            </div>
            <div className="btn">
              <input type="submit" id="btn-2" value="Register" />
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default SignUpForm;
