import  axiosConfig, { axiosConfg }  from "./axiosConfig";
import axios from "axios";
import { IPost } from "../model/IPost";
import { ILike } from "../model/ILike";
import { IComment } from "../model/IComment";
import IRegister from "../model/IRegister";
import IUser from "../model/IUser";
import { IProfile } from "../model/IProfile";

interface IReqBody {
    offset: number,
    limit: number,
    user:IUser
}

export const getPersonalList = (offset: number, limit: number, user: IUser) =>{
    //return axiosConfig.get("list.app?o=" + offset + "&l=" + limit + "&u=" + user.id);
    console.log(user);

    let PaginateReq:IReqBody = {
        offset,
        limit,
        user
    }

    console.log(PaginateReq);

    //return axiosConfg.post("userpost.app", PaginateReq);

    return axiosConfg.get("post" + user.userId + ".app");


    //return axios.get('https://api.myjson.com/bins/vpwds');
    //return axios.get('https://api.myjson.com/bins/1bxro8');
}

export const getList = (offset: number, limit: number) => {
    

    let PaginateReq:IReqBody = {
        offset,
        limit,
        user:{
            userId:0,
            username:"",
            password:"",
            firstName:"",
            lastName:"",
            email:""
        }
    }

    return axiosConfg.get("postlist.app");
}

export const publishPost = (body: IPost) => {
    return axiosConfig.post('newpost.app',body);
}

export const authenticateUser = async (username:string, password:string) => {
    let credentials:IUser = {
        username: username,
        password: password
    };

    //let response = await axios.get('https://api.myjson.com/bins/6amgk'/*, credentials*/);

    let response = await axiosConfg.post('login.app', credentials)
    console.log(response);
    return response;
}

export const hitLike = (body: ILike) => {
    return axiosConfig.post('newlike.app', body);
}

export const postComment = (body: IComment) => {
    return axiosConfig.post('newcomm.app', body);
}

export const regUser = (body: IRegister) => {
    return axiosConfg.post('/newuser.app', body);
}

export const getProfile = (body: IUser) => {
    return axiosConfg.get('prof' + body.userId + '.app');
}

export const updateProfile = (body: IProfile) => {
    return axiosConfg.post('newprof.app', body);
}

export const resetPassword = (body: IUser) => {
    return axiosConfg.post('reeee.app', body);
}

export const sendEmail = (body: IUser) => {
    console.log(body);
    return axiosConfg.post('recovery.app', body);
}