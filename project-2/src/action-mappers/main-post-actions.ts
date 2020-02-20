import { getList } from "../utilities/api";
import { IPost } from "../model/IPost";

export const postTypes = {
    SUCCESSFUL_GET_PAGE_POSTS: 'POST_SUCCESSFUL_GET_PAGE_POSTS',
    UNSUCCESSFUL_GET_PAGE_POSTS: 'POST_UNSUCCESSFUL_GET_PAGE_POSTS'
}

export const getAllPosts = (limit: number, offset: number) => async (dispatch: any) => {
    try {
        let posts: any = await getList(offset, limit);

        dispatch({
            type: postTypes.SUCCESSFUL_GET_PAGE_POSTS,
            payload:{
                allPosts: posts
            }
        });
    } catch (e) {
        dispatch({
            type:postTypes.UNSUCCESSFUL_GET_PAGE_POSTS
        });
    }
}