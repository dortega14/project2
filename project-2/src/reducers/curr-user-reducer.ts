import { ICurrUserState } from ".";
import { loginTypes } from "../action-mappers/login-actions";

const intialState:ICurrUserState = {
    currUser: {
        id: 0,
        username: "",
        password: "",
        firstName: "",
        lastName: "",
        email: ""
    },
    loginMessage: ""
}

export const currUserReducer = (state = intialState, action:any) => {
    switch (action.type) {
        case loginTypes.LOGIN_SUCCESS: {
            return {
                ...state,
                currUser:action.payload.currUser,
                loginMessage:"Login Successful!"
            };
        }
        case loginTypes.LOGIN_UNSUCCESS: {
            return {
                ...state,
                loginMessage:action.payload.loginMessage
            };
        }
        case loginTypes.LOGOUT: {
            return intialState;
        }
        default:
            return state;
    }
}