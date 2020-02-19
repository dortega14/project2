import { IPostState } from ".";
import { postTypes } from "../action-mappers/post-actions";


const initialState: IPostState = {
    allPosts:[]
}

export const postReducer = (state = initialState, action:any) => {
    switch (action.type) {
        case postTypes.SUCCESSFUL_GET_PAGE_POSTS: {
            return {
                ...state,
                allPosts:action.payload.allPosts
            };
        }
        case postTypes.UNSUCCESSFUL_GET_PAGE_POSTS: {
            return state;
        }
        default:
            return state;
    }
}