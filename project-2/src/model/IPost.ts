import { IYoutube } from "./IYoutube";
import { ICategory } from "./ICategory";
import IUser from "./IUser";

export interface IPost {
    postId: number;
    title: string;
    postSubmitted: Date;
    image: any;
    recipe: string;
    ingredients: string;
    postCategory: ICategory;
    postUser: number;
    postYtLink?: IYoutube
}