import React, { SyntheticEvent } from 'react';
import { Form, Input } from 'reactstrap';
import { resetPassword } from '../../utilities/api';
import IUser from '../../model/IUser';

interface IPasswordState {
    password:string
    username:string
}

export class ResetPasswordComponent extends React.Component<any, IPasswordState> {
    constructor(props:any) {
        super(props);
        this.state = {
            password:"",
            username:""
        }
    }

    updateUsername = (event: any) => {
        this.setState({
            ...this.state,
            username: event.target.value
        });
    }

    updatePassword = (event: any) => {
        this.setState({
            ...this.state,
            password: event.target.value
        });
    }

    resetPassword = async (event: SyntheticEvent) => {
        event.preventDefault();
        let user:IUser = {
            userId:0,
            username:this.state.username,
            password:this.state.password,
            firstName:"",
            lastName:"",
            email:""
        }
        resetPassword(user);
    }

    render() {
        return (
            <>
    	        <Form onSubmit={this.resetPassword}>
                    <Input type="text" onChange={this.updateUsername}>username</Input>
                    <Input type="text" onChange={this.updatePassword}>New Password</Input>
                    <Input type="submit">Submit new password</Input>
                </Form>
            </>
        )
    }
}