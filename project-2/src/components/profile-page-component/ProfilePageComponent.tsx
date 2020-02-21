import React from "react";
import "../../css/Main.scss";
import "bootstrap/dist/css/bootstrap.css";
import { NavLink, Redirect } from "react-router-dom";
import IUser from "../../model/IUser";
import { IPost } from "../../model/IPost";
import { PostCardComponent } from "../post-card-component/PostCardComponent";
import {
  CardColumns,
  Pagination,
  PaginationItem,
  PaginationLink,
  Button,
  Collapse
} from "reactstrap";
import { postComment } from "../../utilities/api";
import { SubmitCardComponent } from "../submit-card-component/SubmitCardComponent";

interface IPostState {
  limit: number;
  offset: number;
  toggle: boolean
}

interface IPostProps {
  user: IUser;
  allPosts: IPost[];
  getAllPosts: (limit: number, offset: number, user: IUser) => void;
  logout: () => void;
}

export class ProfilePageComponent extends React.Component<
  IPostProps,
  IPostState
> {
  constructor(props: any) {
    super(props);
    this.state = {
      limit: 10,
      offset: 0,
      toggle: false
    };
  }

  async componentDidMount() {
    if (this.props.user) {
      if (this.props.allPosts.length === 0) {
        this.props.getAllPosts(10, 0, this.props.user);
      }
    }
  }

  pageTurnForward = () => {
    let newOffset = this.state.offset + this.state.limit;
    this.props.getAllPosts(this.state.limit, newOffset, this.props.user);
    this.setState({
      ...this.state,
      offset: newOffset
    });
  };

  pageTurnFirst = () => {
    let newOffset = 0;
    this.props.getAllPosts(this.state.limit, newOffset, this.props.user);
    this.setState({
      ...this.state,
      offset: newOffset
    });
  };

  pageTurnBack = () => {
    if (this.state.offset > 0) {
      let newOffset = this.state.offset - this.state.limit;
      this.props.getAllPosts(this.state.limit, newOffset, this.props.user);
      this.setState({
        ...this.state,
        offset: newOffset
      });
    }
  };

  toggleSubmitCard = () => {
    this.setState({
      ...this.state,
      toggle: !this.state.toggle
    })
  }

  render() {
    if (this.props.user.username) {
      return (
        <div className="MainButtons">
          <header>
            <nav>
              <ul>
                <li>
                  <NavLink to={{pathname: "/home"}}>
                    Home
                  </NavLink>
                </li>

                <li>
                  <NavLink
                    to={{pathname: "/register"}}>
                    Settings
                  </NavLink>
                </li>
                <li>
                  <NavLink
                    to={{pathname: "/"}} 
                    onClick={this.props.logout}>
                    Logout
                  </NavLink>
                </li>
              </ul>
            </nav>
          </header>
          <br/>
          <div>
            <Button color="primary" onClick={this.toggleSubmitCard}>Add post</Button>
            <Collapse isOpen={this.state.toggle}>
              <SubmitCardComponent currUser={this.props.user}></SubmitCardComponent>
            </Collapse>
          </div>
          <div>
            <CardColumns>
              {this.props.allPosts[0] && (
                <PostCardComponent
                  post={this.props.allPosts[0]}
                  currUser={this.props.user}
                  parent="pp"
                />
              )}
              {this.props.allPosts[1] && (
                <PostCardComponent
                  post={this.props.allPosts[1]}
                  currUser={this.props.user}
                  parent="pp"
                />
              )}
              {this.props.allPosts[2] && (
                <PostCardComponent
                  post={this.props.allPosts[2]}
                  currUser={this.props.user}
                  parent="pp"
                />
              )}
              {this.props.allPosts[3] && (
                <PostCardComponent
                  post={this.props.allPosts[3]}
                  currUser={this.props.user}
                  parent="pp"
                />
              )}
              {this.props.allPosts[4] && (
                <PostCardComponent
                  post={this.props.allPosts[4]}
                  currUser={this.props.user}
                  parent="pp"
                />
              )}
              {this.props.allPosts[5] && (
                <PostCardComponent
                  post={this.props.allPosts[5]}
                  currUser={this.props.user}
                  parent="pp"
                />
              )}
              {this.props.allPosts[6] && (
                <PostCardComponent
                  post={this.props.allPosts[6]}
                  currUser={this.props.user}
                  parent="pp"
                />
              )}
              {this.props.allPosts[7] && (
                <PostCardComponent
                  post={this.props.allPosts[7]}
                  currUser={this.props.user}
                  parent="pp"
                />
              )}
              {this.props.allPosts[8] && (
                <PostCardComponent
                  post={this.props.allPosts[8]}
                  currUser={this.props.user}
                  parent="pp"
                />
              )}
              {this.props.allPosts[9] && (
                <PostCardComponent
                  post={this.props.allPosts[9]}
                  currUser={this.props.user}
                  parent="pp"
                />
              )}
            </CardColumns>
            <Pagination aria-label="Page navigation example">
              <PaginationItem disabled>
                <PaginationLink first onClick={this.pageTurnFirst} />
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
        </div>
      );
    } else {
      return <Redirect to="/login" />;
    }
  }
}
