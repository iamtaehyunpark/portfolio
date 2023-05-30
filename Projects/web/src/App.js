import { useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './Pages/Login';
import Signup from './Pages/Signup';
import Education from './Pages/Education'
import Community from './Pages/Community';
import Main from './Pages/Main'
import Chat from './Pages/Chat'
import Profile from './Pages/Profile';
import EditProfile from './Pages/EditProfile';
import './App.css';
import Au from './Pages/Au';
import Bi from './Pages/Bi';
import Bu from './Pages/Bu';


function App() {
  const [profile, setProfile] = useState({
    email: '',
    firstName: '',
    lastName: '',
    license: -1,
    pets: [],
    loggedIn: false
  });
  
  return (
    <div className="App">
      <BrowserRouter>
      <Routes>
        <Route path="/"            element={<Login        profile={profile} setProfile={setProfile}/>}></Route>
        <Route path="/Signup"      element={<Signup       profile={profile} setProfile={setProfile}/>}></Route>
        <Route path="/Education"   element={<Education    profile={profile} setProfile={setProfile}/>}></Route>
        <Route path="/Community"   element={<Community    profile={profile} setProfile={setProfile}/>}></Route>
        <Route path="/Main"        element={<Main         profile={profile} setProfile={setProfile}/>}></Route>
        <Route path="/Chat"        element={<Chat         profile={profile} setProfile={setProfile}/>}></Route>
        <Route path="/Profile"     element={<Profile      profile={profile} setProfile={setProfile}/>}></Route>
        <Route path="/EditProfile" element={<EditProfile  profile={profile} setProfile={setProfile}/>}></Route>
        <Route path="/Au"          element={<Au profile={profile} setProfile={setProfile}/>}></Route>
        <Route path="/Bi"          element={<Bi profile={profile} setProfile={setProfile}/>}></Route>
        <Route path="/Bu"          element={<Bu profile={profile} setProfile={setProfile}/>}></Route>
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
