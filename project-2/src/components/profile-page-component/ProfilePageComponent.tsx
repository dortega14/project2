import React from "react";
import "../../css/Main.css";
import "bootstrap/dist/css/bootstrap.css";
import { NavLink, Redirect } from "react-router-dom";
import IUser from "../../model/IUser";
import { IPost } from "../../model/IPost";
import { PostCardComponent } from "../post-card-component/PostCardComponent";
import {
  CardColumns,
  Pagination,
  PaginationItem,
  PaginationLink
} from "reactstrap";
import { getAllPosts } from "../../action-mappers/post-actions";
import { getPersonalList } from "../../utilities/api";

interface IPostState {
  limit: number;
  offset: number;
  allPosts?: any;
}

interface IPostProps {
  user: IUser;
  allPosts: IPost[];
  getAllPosts: (limit: number, offset: number, user: IUser) => void;
}

export class ProfilePageComponent extends React.Component<
  IPostProps,
  IPostState
> {
  constructor(props: any) {
    super(props);
    this.state = {
      limit: 10,
      offset: 0
    };
  }

  async componentDidMount() {
    console.log("Entered componentDidMount");
    if (this.props.user) {
      console.log("user is true");
      if (this.props.allPosts.length === 0) {
        console.log("posts is empty, grabbing posts");
        let posts = await getPersonalList(0, 10, this.props.user);
        this.setState({
          ...this.state,
          allPosts: posts
        });
      }
    }
  }

  pageTurnForward = () => {
    let newOffset = this.state.offset + this.state.limit;
    this.props.getAllPosts(newOffset, this.state.limit, this.props.user);
    this.setState({
      ...this.state,
      offset: newOffset
    });
  };

  pageTurnFirst = () => {
    let newOffset = 0;
    this.props.getAllPosts(newOffset, this.state.limit, this.props.user);
    this.setState({
      ...this.state,
      offset: newOffset
    });
  };

  pageTurnBack = () => {
    if (this.state.offset > 0) {
      let newOffset = this.state.offset - this.state.limit;
      this.props.getAllPosts(newOffset, this.state.limit, this.props.user);
      this.setState({
        ...this.state,
        offset: newOffset
      });
    }
  };

  render() {

    const displayList: PostCardComponent[] = this.props.allPosts.map<any>(
      (post: IPost) => {
        return <PostCardComponent post={post} key={post.postId} />;
      }
    );

    if (this.props.user) {
        
      return (
        <>
          <div className="MainButtons">
            <header>
              <nav>
                <ul>
                  <li>
                    <NavLink
                      to={{
                        pathname: "/profile"
                      }}
                    >
                      Home
                    </NavLink>
                  </li>

                  <li>
                    <NavLink
                      to={{
                        pathname: "/register"
                      }}
                    >
                      Settings
                    </NavLink>
                  </li>

                  <li>
                    <NavLink
                      to={{
                        pathname: "/main"
                      }}
                    >
                      Logout
                    </NavLink>
                  </li>
                </ul>
              </nav>
            </header>
            <CardColumns>{displayList}</CardColumns>

            <Pagination aria-label="Page navigation example">
              <PaginationItem
                disabled={!this.state.offset}
                onClick={this.pageTurnFirst}
              >
                <PaginationLink first />
              </PaginationItem>
              <PaginationItem
                disabled={!this.state.offset}
                onClick={this.pageTurnBack}
              >
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
        </>
      );
    } else {
      return <Redirect to="/login" />;
    }
  }
}
