import React, {useState}from 'react';
import Nav from '../Component/Navbar';
import axios from 'axios';
// import GoogleLogin from '../Component/GoogleOAuth';
import { useNavigate } from 'react-router-dom';
// const clientID = "807197922292-712nlt2ij625oqc3e0hkdjdmpvk6447j.apps.googleusercontent.com";

function Login (props) {
  const [email, setEmail] = useState('');
  const [Password, setPassword] = useState('');
  const navigate = useNavigate();

  const clickLogin = (e, email, password) => {
    e.preventDefault();
    axios({
      method: 'post',
      url: 'http://localhost:80/login',
      data: {
        email: email,
        pwd: password
      }
    }).then((data) => {
      console.log(data)
      // 여기서 방아온거 state으로 넣어주기
      if (data.data == 400) {
        alert("No credential matched")
      } else {
        data = data.data
        props.setProfile({
          firstName : data.firstName,
          lastName  : data.lastName,
          email     : data.email,
          license   : data.license,
          pets      : data.pets,
          loggedIn  : true
        })
        navigate("/Main");
      }}).catch((err) => {
        alert(err)
      })
  }
    return (
      <div>
        <Nav profile={props.profile} setProfile={props.setProfile}></Nav>
          <div className="login-page">
      <div className="form">
        <form className="login-form">
          <input type="text" required value = {email} onChange={ (e)=> setEmail(e.target.value)} placeholder="Email" />
          <input type="password" value ={Password} onChange={ (e)=> setPassword(e.target.value)}placeholder="password"/>
          <button onClick={(e)=>clickLogin(e, email,Password)}>Login</button>
          <p className="messagel">Not registered? <a href="Signup">Create an account</a></p>
          {/* <p className="other-way-to-signin">-----Easier Sign-in-----</p>
          <div className='google-Login'>
          <GoogleLogin></GoogleLogin>
          </div> */}
          
        </form>
      </div>
    </div>
      </div>
    );
  }
  export default Login;