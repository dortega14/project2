import React from 'react';
import '../../css/Main.css'
import 'bootstrap/dist/css/bootstrap.css';
import { NavLink} from 'react-router-dom';


function main () {


    return(
        <div className="MainButtons">
        <header>
            <nav >
                <ul className="LinkElements">
                    <li>< NavLink className="mainLink" to={{
                        pathname: '/Login'
                    }}>Login</ NavLink></li>

                    <li><NavLink className="mainLink" to={{
                        pathname: '/register'
                    }}>Register</NavLink></li>
                </ul>
            </nav>
        </header>
        </div>
        // <div className="MainButtons" >
        //     <button onClick = {profileP} type="button" className="btn btn-warning btn-lg" >Login</button>
        //     <button type="button" id="RegisterButton" className="btn btn-warning btn-lg">Register</button>
        // </div>      
        
    );
    
}

const profileP = () => {
   console.log("Back to home page");
    
}


export default main;