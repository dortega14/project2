import { IYoutube } from "./IYoutube";

export interface IPost {
    postId: number;
    title: string;
    postSubmitted: Date;
    image: any;
    recipe: string;
    ingredients: string;
    postCategory: number;
    postUser: number;
    postYtLink: IYoutube
}