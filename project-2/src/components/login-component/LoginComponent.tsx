import React, {  SyntheticEvent } from 'react';
import '../../css/Main.css'
import 'bootstrap/dist/css/bootstrap.css';
import {NavLink} from 'react-router-dom';

interface ILoginState {
    username: string,
    password: string
};

interface ILoginProps {
    updateCurrentUser: (username: string, password: string) => void,
    loginMessage: string
};

export class LoginComponent extends React.Component<ILoginProps, ILoginState>{
    constructor(props: any) {
        super(props);
        this.state = {
            username: "",
            password: ""
        };
    }

    updateUsername = (event: any) => {
        this.setState({
            ...this.state,
            username:event.target.value
        });
    }

    updatePassword = (event: any) => {
        this.setState({
            ...this.state,
            password:event.target.value
        });
    }

    submitLogin = async (event: SyntheticEvent) => {
        event.preventDefault();
        this.props.updateCurrentUser(this.state.username, this.state.password);
    }

    render() {
        return (
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
                        <li><NavLink className="mainLink" to={{
                            pathname: '/profile'
                        }}>Profile</NavLink></li>
                    </ul>
                </nav>
            </header>
            <div className="container">
            
                <form id ="LoginForm" className="form-horizontal" onSubmit={this.submitLogin}>   
                    <div id="LoginElements" className="row">
                    <div className="TextForLogin">
                        <p>Share your favorite recipies </p>
                        <p>with friends and family</p>
                    </div>
                        <div className="form-group col-md-4">
                            <label id="EmailInput" htmlFor="exampleInputEmail1">Username</label>
                            <input type="text" className="form-control input-lg" id="username" aria-describedby="usernameField" placeholder="Username" value={this.state.username} onChange={this.updateUsername}/>
                            <small id="emailHelp" className="form-text text-muted"></small>
                        </div>
                        <div className="form-group col-md-4">
                            <label htmlFor="exampleInputPassword1">Password</label>
                            <input type="password"className="form-control input-lg" id="exampleInputPassword1" placeholder="Password" value={this.state.password} onChange={this.updatePassword}/>
                            <button onClick={toProfileP} id="SubmitButton" type="submit" className="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </form>
                <p>{this.props.loginMessage}</p>
            </div>
            </div>

        );
    };
}


function toProfileP (){
 
}
