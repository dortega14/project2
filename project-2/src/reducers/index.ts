import {combineReducers} from 'redux';
import { currUserReducer } from "./curr-user-reducer";


export interface ICurrUserState {
    currUser: { 
        id: number
        username: string
        password: string
        firstName: string
        lastName: string
        email: string
    },
    loginMessage: string;
}

export interface IState {
    CurrUserState: ICurrUserState
}

export const state = combineReducers<IState> ({
    CurrUserState: currUserReducer
})