import React, { SyntheticEvent } from 'react';
import { sendEmail } from '../../utilities/api';
import { Form, Input } from 'reactstrap';
import IUser from '../../model/IUser';

interface IForgotState {
    username: string
}

export class ForgotPasswordComponent extends React.Component<any, IForgotState> {
    constructor (props:any) {
        super(props);
        this.state = {
            username: ""
        }
    }

    updateUsername = (event: any) => {
        this.setState({
            ...this.state,
            username: event.target.value
        });
    }

    sendRecovery = async (event: SyntheticEvent) => {
        event.preventDefault();
        let user:IUser = {
            userId:0,
            username:this.state.username,
            password:"",
            firstName:"",
            lastName:"",
            email:""
        }
        sendEmail(user);
    }

    render () {
        return (
            <>
                <Form onSubmit={this.sendRecovery}>
                    <Input type="text" onChange={this.updateUsername} placeholder="Enter username, please"/>
                    <Input type="submit">Send me the email!</Input>
                </Form>
            </>
        )
    }
}