import { IPostState } from ".";


const initalState: IPostState = {
    allPosts:[]
}

export const postReducer = (state = initialState, action:any) => {
    switch (action.type) {
        case postTypes.: {
            return {
                ...state,
                allPosts:action.payload.allPosts
            }
        }
    }
}