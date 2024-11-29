import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';

export default class NavBar extends Component {
  render() {
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
              <Link to="/signin">Sign In</Link> {/* Updated the path to '/signin' */}
              <Link to="/register">Sign Up</Link> {/* Updated the path to '/register' */}
            </div>
          </div>
        </div>
      </>
    );
  }
}
