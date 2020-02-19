import { authenticateUser } from "../utilities/api";

export const loginTypes = {
    LOGIN_SUCCESS: 'LOGIN_LOGIN_SUCCESS',
    LOGIN_UNSUCCESS: 'LOGIN_LOGIN_UNSUCCESS',
    LOGOUT: 'LOGIN_LOGOUT'
}

export const updateCurrentUser = (username:string, password:string) =>
        async (dispatch:any) => {
    

    let response:any = await authenticateUser(username, password);
    //console.log(response.data);
    switch (response.status) {
        case 202:
            dispatch({
                type:loginTypes.LOGIN_SUCCESS,
                payload:{
                    currUser:response.data
                }
            });
            break;
        case 401:
            dispatch({
                type:loginTypes.LOGIN_UNSUCCESS,
                payload: {
                    loginMessege:response.status + " login failed!"
                }
            })
    }

}