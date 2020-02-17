import  axiosConfig, { axiosConfg }  from "./axiosConfig";
//import axios from "axios";
import { IPost } from "../model/IPost";
import { ILike } from "../model/ILike";
import { IComment } from "../model/IComment";
import IRegister from "../model/IRegister";

export const getList = () =>{
    return axiosConfig.get("list.app");
}

export const publishPost = (body: IPost) => {
    return axiosConfig.post('add.app',body);
}

export const authenticateUser = async (username:string, password:string) => {
    let credentials = {
        username,
        password
    }

    //let response = await axios.get('https://api.myjson.com/bins/6amgk'/*, credentials*/);

    let response = await axiosConfg.post('login.app', credentials)
    //console.log(response);
    return response;
}

export const hitLike = (body: ILike) => {
    return axiosConfig.post('like.app', body);
}

export const postComment = (body: IComment) => {
    return axiosConfig.post('cmnt.app', body);
}

export const regUser = (body: IRegister) => {
    return axiosConfg.post('/newuser.app', body);
}