import { IState } from "../../reducers";
import { connect } from "react-redux";
import { ProfileComponent } from "./ProfileComponent";
import { updateBio } from '../../action-mappers/profile-actions'


const mapStateToProps = (state:IState) => {
    return {
        profile: state.ProfileState.profile,
        user: state.CurrUserState.currUser
    };
}

const mapDispatchToProps = {
    updateBio
}

export default connect(mapStateToProps, mapDispatchToProps)(ProfileComponent);