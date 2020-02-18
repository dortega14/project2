import React, { useState } from 'react';
import '../../css/Register.css'
import 'bootstrap/dist/css/bootstrap.css';
import { NavLink} from 'react-router-dom';
import { regUser } from '../../utilities/api';

export const Register:React.FC<any> = (props:any) => {
    const [email, setemail] = useState("");
    const [username, setuname] = useState("");
    const [password, setpass] = useState("");
    const [firstName, setfirst] = useState("");
    const [lastName, setlast] = useState("");
    
    return(
        <div >
            <header className="MainButtons">
            <nav >
                <ul className="LinkElements">
                    <li>< NavLink className="mainLink" to={{
                        pathname: '/main'
                    }}>Home</ NavLink></li>

                    <li><NavLink className="mainLink" to={{
                        pathname: '/Login'
                    }}>Login</NavLink></li>
                </ul>
            </nav>
        </header>

        <div className="container">
            <form id ="RegisterForm" className="form-horizontal" onSubmit={()=>regUser({
                user_id:0,
                email: email,
                username: username,
                password: password,
                firstName: firstName,
                lastName: lastName
            }).then(r=>console.log(r.data))}>
                <div id="RegisterElements" className="row">
                <div className="TextForRegister">
                    <p>Indulge in an exciting experience </p>
                    <p>by becoming a memeber of</p>
                    <p>the recipe family</p>
                </div>
                <div id="FirstName" className="form-group col-md-4">
                        <label>First Name</label>
                        <input className="form-control input-lg" placeholder="first name" onChange={val=>setfirst(val.target.value)}/> 
                </div>
                <div className="form-group col-md-4">
                        <label>Last Name</label>
                        <input className="form-control input-lg" placeholder="last name" onChange={val=>setlast(val.target.value)}/> 
                </div>
                <div className="form-group col-md-4">
                        <label>User Name</label>
                        <input className="form-control input-lg" placeholder="user name" onChange={val=>setuname(val.target.value)}/> 
                    </div>
                    <div className="form-group col-md-4">
                        <label htmlFor="exampleInputEmail1">Email address </label>
                        <input type="email" className="form-control input-lg" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" onChange={val=>setemail(val.target.value)}/>
                        <small id="emailHelp" className="form-text text-muted"></small>
                    </div>
                    
                    <div className="form-group col-md-4">
                        <label htmlFor="exampleInputPassword1">Password</label>
                        <input type="password" className="form-control input-lg" id="exampleInputPassword1" placeholder="Password" onChange={val=>setpass(val.target.value)}/> 
                        <button id="SubmitButton" type="submit" className="btn btn-primary">Sign Up</button>
                    </div> 
                </div>
    
            </form>       
        </div> 
                    <div className="SpaceNeededDiv">

                    </div>

        </div>
        
    );
    
}
export default Register;