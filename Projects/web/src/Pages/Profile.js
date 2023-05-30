import React, { useState } from "react";
import Nav from '../Component/Navbar';
import { Link, useLocation } from 'react-router-dom';

function Profile(props) {
  const location = useLocation();
  
  const testUser = [{
    FistName: "Gyuri",
    LastName: "Kim",
    Gender: "F",
    Dogtype: "Golden retriever",
    DogName: "Inzulme",
    DogAge: "3 month"
  }]
  const viewDogInfo = () =>{
    alert("About me!\n   Dog type: "+testUser[0].Dogtype +"\n   Age: "+testUser[0].DogAge)
  }
  const handleSubmit = (e) => {
    e.preventDefault();
    // submit form data to the backend
  };

  return (
      <div className="Edit_background">
        <Nav profile={props.profile} setProfile={props.setProfile}/>
        <div className="profile">
          <form onSubmit={handleSubmit}>
           <p className="profileHeader">Profile</p>
           <div className="userInfo">
            <img className = "ProfileImage"src="account_default.svg" alt="default_profile"/>
            <p className="userName">Name: {props.profile.firstName} {props.profile.lastName}</p>
           </div>
           <div className="DogInfo" onClick={viewDogInfo}>
            <img className = "ProfileImage"src="account_default.svg" alt="default_profile"/>
            {/* <p className="userName">Dog type: {testUser[0].Dogtype}</p> */}
            <p className="DogName">Name: {props.profile.pets}</p>
            <p className="click_me">Click to see more about me :D </p>
          </div>
          <Link to= "/EditProfile"><button className="Edit">Edit Profile</button></Link>
          </form>
        </div>
    </div>
  );
}

export default Profile;
