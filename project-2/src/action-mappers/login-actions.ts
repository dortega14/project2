import { authenticateUser } from "../utilities/api";
import IUser from "../model/IUser";

export const loginTypes = {
    LOGIN_SUCCESS: 'LOGIN_LOGIN_SUCCESS',
    LOGIN_UNSUCCESS: 'LOGIN_LOGIN_UNSUCCESS'
}

export const updateCurrentUser = (username:string, password:string) =>
        async (dispatch:any) => {
    

    let response:any = await authenticateUser(username, password);
    switch (response.status) {
        case 200:
            dispatch({
                type:loginTypes.LOGIN_SUCCESS,
                payload:{
                    currUser:response.body
                }
            });
            break;
        case 401:
            dispatch({
                type:loginTypes.LOGIN_UNSUCCESS,
                payload: {
                    loginMessege:response.loginMessege
                }
            })
    }

}