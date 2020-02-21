import React, { SyntheticEvent } from 'react';
import { IProfile } from '../../model/IProfile';
import IUser from '../../model/IUser';
import { Form, FormGroup, Input } from 'reactstrap';

interface IEProfileState {
    profile: IProfile
}

interface IEProfileProps {
    profile: IProfile,
    user: IUser,
    updateBio: (profile: IProfile) => void
}

export class ProfileComponent extends React.Component<IEProfileProps, IEProfileState> {
    constructor(props: any) {
        super(props);
        this.state = {
            profile: this.props.profile
        }
    }

    updateBio = (event: any) => {
        this.setState({
            ...this.state,
            profile: {
                profileId: this.state.profile.profileId,
                bio: event.target.value,
                coverImage: this.state.profile.coverImage,
                profileUser: this.state.profile.profileUser
            }
        });
    }

    submitChanges = async (event:SyntheticEvent) => {
        event.preventDefault();
    }

    render() {
        return (
            <>
                <Form onSubmit={this.submitChanges}>
                    <FormGroup row>
                        <Input type="text"
                            placeholder="Please enter a short bio"
                            value={this.state.profile.bio}
                            onChange={this.updateBio}
                        />
                    </FormGroup>
                    <FormGroup row>
                        <Input type="submit">Update Bio</Input>
                    </FormGroup>
                </Form>
            </>
        )
    }
}