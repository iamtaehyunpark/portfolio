import React from 'react';
import { Link } from 'react-router-dom';

function Nav(props) {
    function logout() {
    props.setProfile({
      ...props.profile, loggedIn: false
    })
  }
  if( props.profile.loggedIn === true){
    return (
      <div className="top-bar">
        <div className="app-name">PawSome Pet Hub</div>
        <div className="nav-links">
          <Link to="/Main"      >Home</Link>
          <Link to="/Education" >Education</Link>
          <Link to="/Chat"      >Chat</Link>
        </div>
        <div className="login-signup">
          <img className = "profileImage"src="account_default.svg" alt="default_profile"/>
          <Link to = '/Profile'>{props.profile.firstName + " " + props.profile.lastName}</Link>
          <Link to='/' onClick={logout}>Log out</Link>
        </div>
      </div>
    );
  } else {
    return (
      <div className="top-bar">
        <div className="app-name">PawSome Pet Hub</div>
              <div className="nav-links">
                <Link to="/">Home</Link>
                <Link to="/">Education</Link>
                <Link to="/">Chat</Link>
              </div>
              <div className="login-signup">
                <Link to="/" >Log In</Link>
                <Link to="/Signup">Sign Up</Link>
              </div>
            </div>
          );
    }
    
  }
  
  export default Nav;