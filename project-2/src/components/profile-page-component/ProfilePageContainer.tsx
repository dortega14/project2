import { IState } from "../../reducers";
import { connect } from "react-redux";
import { PostCardComponent } from "../post-card-component/PostCardComponent";
import { getAllPosts } from "../../action-mappers/post-actions";
import { logout } from "../../action-mappers/login-actions"
import { ProfilePageComponent } from "./ProfilePageComponent";


const mapStateToProps = (state: IState) => {
    return {
        user: state.CurrUserState.currUser,
        allPosts: state.PostState.allPosts
    };
}

const mapDispatchToProps = {
    getAllPosts,
    logout
}

export default connect(mapStateToProps, mapDispatchToProps)(ProfilePageComponent)
