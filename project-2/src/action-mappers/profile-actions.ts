import { IProfile } from "../model/IProfile"
import { updateProfile, getProfile } from "../utilities/api"
import IUser from "../model/IUser";


export const profileTypes = {
    SUCCESSFUL_GET_PROFILE: 'PROFILE_SUCCESSFUL_GET_PROFILE',
    UNSUCCESSFUL_GET_PROFILE: 'PROFILE_UNSUCCESSFUL_GET_PROFILE',
    SUCCESSFUL_UPDATE_PROFILE: 'PROFILE_SUCCESSFUL_UPDATE_PROFILE',
    UNSUCCESSFUL_UPDATE_PROFILE: 'PROFILE_UNSUCCESSFUL_UPDATE_PROFILE',
    LOGOUT_REMOVE_PROFILE: 'PROFILE_LOGOUT_REMOVE_PROFILE'
}

export const updateBio = (profile: IProfile) => async (dispatch:any) => {
    let response:any = await updateProfile(profile);

    if(response.status === 202) {
        dispatch({
            type: profileTypes.SUCCESSFUL_UPDATE_PROFILE,
            payload:{
                profile
            }
        });
    } else {
        dispatch({
            type: profileTypes.UNSUCCESSFUL_UPDATE_PROFILE,
            payload: {
                
            }
        });
    }
}

export const getBio = (user: IUser) => async (dispatch:any) => {
    let response:any = await getProfile(user);

    if(response.body) {
        dispatch({
            type:profileTypes.SUCCESSFUL_GET_PROFILE,
            payload: {
                profile: response.body
            }
        });
    } else {
        dispatch({
            type:profileTypes.UNSUCCESSFUL_GET_PROFILE,
            payload: {

            }
        });
    }
}

export const logout = () => (dispatch:any) => {
    dispatch({
        type: profileTypes.LOGOUT_REMOVE_PROFILE,
        payload: {

        }
    });
}