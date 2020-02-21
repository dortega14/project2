import { IProfileState } from ".";
import { profileTypes } from "../action-mappers/profile-actions";


const initialState:IProfileState = {
    profile: {
        profileId:0,
        bio:"",
        coverImage:null,
        profileUser: {
            userId: 0,
            username: "",
            password: "",
            firstName: "",
            lastName: "",
            email:""
        }
    }
}

export const profileReducer = (state = initialState, action: any) => {
    switch (action.type) {
        case profileTypes.SUCCESSFUL_GET_PROFILE:
        case profileTypes.SUCCESSFUL_UPDATE_PROFILE:
            return {
                ...state,
                profile: action.payload.profile
            };

        case profileTypes.UNSUCCESSFUL_GET_PROFILE:
        case profileTypes.UNSUCCESSFUL_UPDATE_PROFILE:
            return state;

        case profileTypes.LOGOUT_REMOVE_PROFILE:
            return initialState;   
             
        default:
            return state;
    }
}