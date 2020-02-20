import { IMainPostState } from ".";
import { postTypes } from "../action-mappers/main-post-actions";


const initialState: IMainPostState = {
    allPosts:[]
}

export const mainPostReducer = (state = initialState, action:any) => {
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