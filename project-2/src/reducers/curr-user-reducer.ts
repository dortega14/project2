

const intialState:ICurrUserState = {
    id: 0,
    username: "",
    password: "",
    firstName: "",
    lastName: "",
    email: ""
}

export const CurrUserReducer = (state = intialState, action:any) => {
    switch (action.type) {
        case "yes":
            return null;
        case "no":
            return null;
        default:
            return state;
    }
}