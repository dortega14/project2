import { ILikeType } from "./ILikeType";
import { IPost } from "./IPost";
import IUser from "./IUser";

export interface ILike{
    likeId?: number;
    likeLikeType: ILikeType;
    likePost: IPost;
    likeUser: IUser;
}