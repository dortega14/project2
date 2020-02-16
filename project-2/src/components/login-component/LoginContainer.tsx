import { IState } from "../../reducers";
import { connect } from "react-redux";
import { LoginComponent } from "./LoginComponent";
import { updateCurrentUser } from "../../action-mappers/login-actions";


const mapStateToProps = (state:IState) => {
    return {
        loginMessage:state.CurrUserState.loginMessage
    }
};

const mapDispatchToProps = {
    updateCurrentUser
};

export default connect(mapStateToProps, mapDispatchToProps)(LoginComponent);