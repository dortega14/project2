import IUser from "./IUser";
import { IPost } from "./IPost";

export interface IComment{
    commentId: number,
    comment: string,
    commentPost: IPost,
    commentUser: IUser
}