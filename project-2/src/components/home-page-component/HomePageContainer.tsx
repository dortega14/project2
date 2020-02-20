import { IState } from "../../reducers";
import { connect } from "react-redux";

import { getAllPosts } from "../../action-mappers/main-post-actions";
import { logout } from "../../action-mappers/login-actions";
import { HomePageComponent } from "./HomePageComponent";


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

export default connect(mapStateToProps, mapDispatchToProps)(HomePageComponent)
