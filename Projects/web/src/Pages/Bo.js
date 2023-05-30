import React from 'react';
import Nav from '../Component/Navbar';
function Bo(props){
    return(
        <div>
            <Nav profile={props.profile} setProfile={props.setProfile}/>
                
        </div>
    )
}
export default Bo;