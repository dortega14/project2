import React from 'react';
import '../../css/Main.css'
import 'bootstrap/dist/css/bootstrap.css';
import {Redirect, Route, NavLink} from 'react-router-dom';

function ProfileP () {
    return(
        <div className="MainButtons">
        <header >
            <nav >
                <ul>
                    <li>< NavLink to={{
                        pathname: '/profile'
                    }}>Home</ NavLink></li>

                    <li><NavLink to={{
                        pathname: '/register'
                    }}>Settings</NavLink></li>
                </ul>
            </nav>
        </header>
        </div>
            
    );
    
}
export default ProfileP;