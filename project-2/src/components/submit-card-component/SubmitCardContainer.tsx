import { IState } from "../../reducers";
import { connect } from "react-redux";
import { SubmitCardComponent } from "./SubmitCardComponent";



const mapStateToProps = (state: IState) => {
    return {
        currUser: state.CurrUserState.currUser
    };
};

const mapDispatchToProps = {
    
};

export default connect(mapStateToProps, mapDispatchToProps)(SubmitCardComponent)