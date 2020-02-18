import { combineReducers } from 'redux';
import { currUserReducer } from "./curr-user-reducer";
import { IPost } from '../model/IPost';


export interface ICurrUserState {
    currUser: { 
        id: number
        username: string
        password: string
        firstName: string
        lastName: string
        email: string
    },
    loginMessage: string
}

export interface IPostState {
    allPosts:IPost[]
}

export interface IState {
    CurrUserState: ICurrUserState,
    PostState: IPostState
}

export const state = combineReducers<IState> ({
    CurrUserState: currUserReducer,
    PostState: postReducer
})