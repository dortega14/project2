import React from 'react';
import '../../css/Register.css'
import 'bootstrap/dist/css/bootstrap.css';
import {Redirect, NavLink} from 'react-router-dom';
import { Route } from 'react-router-dom';

function Register() {
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
            <form id ="RegisterForm" className="form-horizontal">
                <div id="RegisterElements" className="row">
                <div className="TextForRegister">
                    <p>Indulge in an exciting experence </p>
                    <p>by becoming a memeber of</p>
                    <p>the recipe family</p>
                </div>
                <div id="FirstName" className="form-group col-md-4">
                        <label>First Name</label>
                        <input className="form-control input-lg" placeholder="first name" /> 
                </div>
                <div className="form-group col-md-4">
                        <label>Last Name</label>
                        <input className="form-control input-lg" placeholder="last name" /> 
                </div>
                <div className="form-group col-md-4">
                        <label>User Name</label>
                        <input className="form-control input-lg" placeholder="user name" /> 
                    </div>
                    <div className="form-group col-md-4">
                        <label htmlFor="exampleInputEmail1">Email address </label>
                        <input type="email" className="form-control input-lg" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" />
                        <small id="emailHelp" className="form-text text-muted"></small>
                    </div>
                    
                    <div className="form-group col-md-4">
                        <label htmlFor="exampleInputPassword1">Password</label>
                        <input type="password" className="form-control input-lg" id="exampleInputPassword1" placeholder="Password" /> 
                        <button id="SubmitButton" type="submit" className="btn btn-primary">Submit</button>
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