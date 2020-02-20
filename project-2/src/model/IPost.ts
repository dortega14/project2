import { IYoutube } from "./IYoutube";
import { ICategory } from "./ICategory";
import IUser from "./IUser";
import { IComment } from "./IComment";

export interface IPost {
    postId: number,
    title: string,
    postSubmitted: Date,
    image?: any,
    recipe: string,
    ingredients: string,
    postCategory: ICategory,
    postComment?: IComment[],
    postUser: IUser,
    postYtLink?: IYoutube
}