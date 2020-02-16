import {combineReducers} from 'redux';


export interface ICurrUser {
    id: number
    username: string
    password: string
    firstName: string
    lastName: string
    email: string
}

export interface IState {
    CurrUserState: ICurrUser
}

export const state = combineReducers<IState> ({
    CurrUserState = CurrUserReducer
})