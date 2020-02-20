import { getPersonalList } from "../utilities/api";
import { IPost } from "../model/IPost";
import IUser from "../model/IUser";

export const postTypes = {
    SUCCESSFUL_GET_PAGE_POSTS: 'POST_SUCCESSFUL_GET_PAGE_POSTS',
    UNSUCCESSFUL_GET_PAGE_POSTS: 'POST_UNSUCCESSFUL_GET_PAGE_POSTS'
}

export const getAllPosts = (limit: number, offset: number, currUser: IUser) => async (dispatch: any) => {
    try {
        let posts: any = await getPersonalList(offset, limit, currUser);

        dispatch({
            type: postTypes.SUCCESSFUL_GET_PAGE_POSTS,
            payload:{
                allPosts: posts.data
            }
        });
    } catch (e) {
        dispatch({
            type:postTypes.UNSUCCESSFUL_GET_PAGE_POSTS
        });
    }
}