import React, { useState } from 'react';
import '../../css/Main.css'
import 'bootstrap/dist/css/bootstrap.css';
import {Redirect, Route, NavLink} from 'react-router-dom';
import { render } from '@testing-library/react';
import { authenticateUser } from '../../utilities/api';


export const Login:React.FC<any> = (props:any) =>{
    const [username, setuname] = useState("");
    const [password, setpass] = useState("");
    return(
        <div >
        <header className="MainButtons">
            <nav >
                <ul className="LinkElements">
                    <li>< NavLink className="mainLink" to={{
                        pathname: '/main'
                    }}>Home</ NavLink></li>
                <li><NavLink className="mainLink" to={{
                        pathname: '/register'
                    }}>Register</NavLink></li>
                </ul>
            </nav>
        </header>
        <div className="container">
          
            <form id ="LoginForm" className="form-horizontal" onSubmit={()=>authenticateUser({
                user_id:0,
                username,
                password
            }).then(r=>{
                console.log(r.data);
                sessionStorage.setItem("user", r.data);
            })}>   
                <div id="LoginElements" className="row">
                <div className="TextForLogin">
                    <p>Share your favorite recipies </p>
                    <p>with friends and family</p>
                </div>
                    <div className="form-group col-md-4">
                        <label id="EmailInput" htmlFor="exampleInputEmail1">Username</label>
                        <input type="email" className="form-control input-lg" id="username" aria-describedby="usernameField" placeholder="Username" onChange={val=>setuname(val.target.value)}/>
                        <small id="emailHelp" className="form-text text-muted"></small>
                    </div>
                    <div className="form-group col-md-4">
                        <label htmlFor="exampleInputPassword1">Password</label>
                        <input type="password"className="form-control input-lg" id="exampleInputPassword1" placeholder="Password" onChange={val=>setpass(val.target.value)}/>
                        <button onClick={toProfileP} id="SubmitButton" type="submit" className="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form>
        </div>
        </div>

    );
}


function toProfileP (){
 
}


export default Login;