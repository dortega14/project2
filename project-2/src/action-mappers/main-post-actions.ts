import { getList } from "../utilities/api";
import { IPost } from "../model/IPost";

export const postTypes = {
    SUCCESSFUL_GET_PAGE_POSTS: 'MAIN_SUCCESSFUL_GET_PAGE_POSTS',
    UNSUCCESSFUL_GET_PAGE_POSTS: 'MAIN_UNSUCCESSFUL_GET_PAGE_POSTS'
}

export const getAllPosts = (limit: number, offset: number) => async (dispatch: any) => {

        let response: any = await getList(offset, limit);
    switch (response.status) {
        case 200:
        case 202: 
            dispatch({
                type: postTypes.SUCCESSFUL_GET_PAGE_POSTS,
                payload:{
                    allPosts: response.data
                }
            });
            break;
        default:
            dispatch({
                type:postTypes.UNSUCCESSFUL_GET_PAGE_POSTS
            });
    }
}