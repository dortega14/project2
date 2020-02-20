import { combineReducers } from 'redux';
import { currUserReducer } from "./curr-user-reducer";
import { IPost } from '../model/IPost';
import IUser from '../model/IUser';
import { postReducer } from './post-reducer';
import { mainPostReducer } from './main-post-reducer';


export interface ICurrUserState {
    currUser: IUser,
    loginMessage: string
}

export interface IPostState {
    allPosts:IPost[]
}

export interface IMainPostState {
    allPosts:IPost[]
}

export interface IState {
    CurrUserState: ICurrUserState,
    PostState: IPostState,
    MainPostState: IMainPostState
}

export const state = combineReducers<IState> ({
    CurrUserState: currUserReducer,
    PostState: postReducer,
    MainPostState: mainPostReducer
})