import React, { useState } from "react";
import Nav from '../Component/Navbar';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

function EditProfile(props) {
  const [firstName, setFirstName] = useState(props.profile.firstName);
  const [lastName, setLastName] = useState(props.profile.lastName);
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const navigate = useNavigate();
  const location = useLocation();

  const handleSubmit = (e) => {
    e.preventDefault();
    // submit form data to the backend
    axios({
        method: 'put',
        url: 'http://localhost:80/EditProfile',
        data: {
          email: props.profile.email,
          firstName: firstName,
          lastName: lastName,
          pwd: password
        }
      }).then((data) => {
        // 여기서 방아온거 state으로 넣어주기
        var changedData = data
        console.log(changedData)
        props.setProfile({
          ...props.profile,
          lastName: lastName,
          firstName: firstName,
          pwd: changedData.pwd
        })

        navigate("/Profile");
      });
  };

  return (
      <div className="Edit_background">
        <Nav profile={props.profile} setProfile={props.setProfile}/>
        <div className="profile">
        <form onSubmit={handleSubmit}>
            <label>
            <input type="text" value={firstName} placeholder="First Name" onChange={(e) => setFirstName(e.target.value)} />
            </label>

    `       <label>
            <input type="text" value={lastName} placeholder="Last Name" onChange={(e) => setLastName(e.target.value)} />
            </label>
            <br></br>

            <label>
            <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} />
            </label>
            <br></br>
            
            {/* <input type="password" value={confirmPassword} placeholder="Confirm Password" onChange={(e) => setConfirmPassword(e.target.value)} /> */}
            <br></br>
            <button type="submit">Save Changes</button>
        </form>
        </div>
    </div>
  );
}

export default EditProfile;
