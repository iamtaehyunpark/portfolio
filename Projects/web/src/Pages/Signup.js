import React, { useState } from 'react';
import Nav from '../Component/Navbar';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Signup(props) {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState('');
  const [license, setLicense] = useState(-1);
  const navigate = useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    // Here you can handle the form submission, for example, by sending the data to a server or performing validation
    
  };
  const Submit_filter = (e, firstName, lastName, email, password) =>{
    e.preventDefault()
    if(firstName===''||lastName===''){
      alert("Please type your name.")
    }
    // else if(!(email.slice(-14)==='stonybrook.edu'||email.slice(-15)==='sunykorea.ac.kr')){
    //   alert("Please use your school email.")
    // }
    else if(password===''){
      alert("Please enter the password.")
    } else {
      console.log({
        firstName: firstName,
        lastName: lastName,
        email: email,
        pwd: password,
        license: license,
        pets: []
      })
      axios({
        method: 'post',
        url: 'http://localhost:80/register',
        data: {
          firstName: firstName,
          lastName: lastName,
          email: email,
          pwd: password,
          license: license,
          pets: []
        }
      }).then((data) => {
        if (data.status > 299) {
          alert("There is something wrong with your data");
        } else {
          alert("Successfully Regsitered");
          navigate("/Main",{state:{user:true}});
        }
      });
    }
  }
  return (
  <div>
    <Nav profile={props.profile} setProfile = {props.setProfile}></Nav>
    <div className="signup-page">
      <div className="form">
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="First name"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
          />
          <input
            type="text"
            placeholder="Last name"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
          />
          <input
            className='input-email'
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <p className='email-notice'></p>
          <input
            type="number"
            placeholder="License"
            value={license}
            onChange={(e) => setLicense(e.target.value)}
          />

          <button type="submit" onClick={(e)=>Submit_filter(e, firstName,lastName,email,password)}>Sign up</button>
        </form>
      </div>
    </div>
    </div>
  );
}

export default Signup;
