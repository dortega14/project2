import { axiosConfig } from "./axiosConfig";
import { IPost } from "../model/IPost";
import IUser from "../model/IUser";
import { ILike } from "../model/ILike";
import { IComment } from "../model/IComment";

export const getList = () =>{
    return axiosConfig.get("list.app");
}

export const publishPost = (body: IPost) => {
    return axiosConfig.post('add.app',body);
}

export const authenticateUser = (body: IUser) => {
    return axiosConfig.post('auth.app', body);
}

export const hitLike = (body: ILike) => {
    return axiosConfig.post('like.app', body);
}

export const postComment = (body: IComment) => {
    return axiosConfig.post('cmnt.app', body);
}
