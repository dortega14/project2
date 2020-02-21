import React, { SyntheticEvent } from 'react';
import { sendEmail } from '../../utilities/api';
import { Form, Input } from 'reactstrap';
import IUser from '../../model/IUser';

interface IForgotState {
    email: string
}

export class ForgotPasswordComponent extends React.Component<any, IForgotState> {
    constructor (props:any) {
        super(props);
        this.state = {
            email: ""
        }
    }

    updateEmail = (event: any) => {
        this.setState({
            ...this.state,
            email: event.target.value
        });
    }

    sendRecovery = async (event: SyntheticEvent) => {
        event.preventDefault();
        let user:IUser = {
            userId:0,
            username:"",
            password:"",
            firstName:"",
            lastName:"",
            email:this.state.email
        }
        sendEmail(user);
    }

    render () {
        return (
            <>
                <Form onSubmit={this.sendRecovery}>
                    <Input type="text" onChange={this.updateEmail} placeholder="Enter email, please"/>
                    <Input type="submit">Send me the email!</Input>
                </Form>
            </>
        )
    }
}