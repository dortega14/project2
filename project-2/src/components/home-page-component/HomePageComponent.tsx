import React from 'react';
import '../../css/Main.css'
import 'bootstrap/dist/css/bootstrap.css';
import { NavLink, Redirect } from 'react-router-dom';
import IUser from '../../model/IUser';
import { IPost } from '../../model/IPost';
import { PostCardComponent } from "../post-card-component/PostCardComponent";
import { CardColumns, Pagination, PaginationItem, PaginationLink } from 'reactstrap';

interface IMainPostState {
    limit: number,
    offset: number
}

interface IMainPostProps {
    user:IUser,
    allPosts: IPost[],
    getAllPosts:(limit: number, offset: number) => void,
    logout:() => void
}

export class HomePageComponent extends React.Component<IMainPostProps, IMainPostState> {
    constructor(props: any) {
        super(props);
        this.state = {
            limit: 10,
            offset: 0
        };
    }

    async componentDidMount() {
        if (this.props.user) {
            if (this.props.allPosts.length === 0) {
                this.props.getAllPosts(10, 0);
            }
        }
    }

    pageTurnForward = () => {
        let newOffset = this.state.offset + this.state.limit;
        this.props.getAllPosts(this.state.limit, newOffset);
        this.setState({
            ...this.state,
            offset: newOffset
        });
    }

    pageTurnFirst = () => {
        let newOffset = 0;
        this.props.getAllPosts(this.state.limit, newOffset);
        this.setState({
            ...this.state,
            offset: newOffset
        });
    }

    pageTurnBack = () => {
        if (this.state.offset > 0) {
            let newOffset = this.state.offset - this.state.limit;
            this.props.getAllPosts(this.state.limit, newOffset);
            this.setState({
                ...this.state,
                offset: newOffset
            });
        }
    }

    render () {

        const displayList: PostCardComponent[] = this.props.allPosts.map<any>((post: IPost) => {
            return <PostCardComponent post= {post}
            />
        });

        if (this.props.user) {
            return(
                <div className="MainButtons">
                <header >
                    <nav >
                        <ul>
                            <li>< NavLink to={{
                                pathname: '/profile'
                            }}>My Profile</ NavLink></li>

                            <li><NavLink to={{
                                pathname: '/register'
                            }}>Settings</NavLink></li>
                            <li><NavLink to={{
                                pathname: '/'
                            }}
                            onClick={this.props.logout}>Logout</NavLink></li>
                        </ul>
                    </nav>
                </header>
                <div>
                    <CardColumns>
                        {displayList}
                    </CardColumns>
                    <Pagination aria-label="Page navigation example">
                        <PaginationItem disabled>
                            <PaginationLink first onClick={this.pageTurnFirst}/>
                        </PaginationItem>
                        <PaginationItem disabled={!this.state.offset} onClick={this.pageTurnBack}>
                            <PaginationLink previous />
                        </PaginationItem>
                        <PaginationItem onClick={this.pageTurnForward}>
                            <PaginationLink next />
                        </PaginationItem>
                        <PaginationItem>
                            <PaginationLink last />
                        </PaginationItem>
                    </Pagination>
                </div>
                </div>
                    
            );
        } else {
            return (
                <Redirect to="/login"/>
            )
        }
    }
}