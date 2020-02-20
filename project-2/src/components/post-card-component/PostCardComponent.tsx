import React, { SyntheticEvent } from "react";
import {
  CardBody,
  Card,
  CardText,
  CardSubtitle,
  CardTitle,
  CardImg,
  Button,
  ButtonGroup,
  Form,
  Input,
  Row
} from "reactstrap";
import { IPost } from "../../model/IPost";
import { YTComponent } from "../yt-component/YTComponent";
import { IYoutube } from "../../model/IYoutube";
import IUser from "../../model/IUser";
import { hitLike, postComment } from "../../utilities/api";
import { ILike } from "../../model/ILike";
import { IComment } from "../../model/IComment";

interface IPostProps {
  post: IPost,
  currUser: IUser,
  parent: string
}

interface IPostState {
  newComment: string
}

export class PostCardComponent extends React.Component<IPostProps, IPostState> {
  constructor(props:any) {
    super(props);
    this.state = {
      newComment:""
    }
  }

  updateNewComment = (event:any) => {
    this.setState({
      ...this.state,
      newComment:event.target.value
    })
  }

  cardTextBuilder() {
    return `Ingredients:  ${this.props.post.ingredients}\n\r
            Recipe:  ${this.props.post.recipe}\n\r
            Submitted on: ${new Date(this.props.post.postSubmitted)} by ${this.props.post.postUser.firstName}`;
  }

  submitComment(event:SyntheticEvent) {
    event.preventDefault();
    let comment:IComment = {
      commentId:0,
      comment: this.state.newComment,
      commentPost: this.props.post,
      commentUser: this.props.currUser
    };
    postComment(comment);
    console.log("submitted comment");
  }

  submitLike(type:number) {
    let like:ILike = {
      likeUser: this.props.currUser,
      likePost: this.props.post,
      likeLikeType: {likeTypeId: type, likeType: (type===1?"Tasty":(type===2?"Looks good":"Needs salt"))}
    };
    hitLike(like);
  }

  render() {
    return (
      <>
        <Row>
          <Card>
            {/*<CardImg>{() => this.props.post.image && this.props.post.image}</CardImg>*/}
            <CardBody>
              <CardTitle>{this.props.post.title}</CardTitle>
              <CardSubtitle>
                {this.props.post.postCategory.category}
              </CardSubtitle>
              <CardText>{this.cardTextBuilder()}</CardText>
            </CardBody>
          </Card>
        </Row>
        <Row>
          <ButtonGroup>
            <Button color="success" onClick={() => this.submitLike(1)}>Tasty</Button>
            <Button color="warning" onClick={() => this.submitLike(2)}>Looks Good</Button>
            <Button color="danger" onClick={() => this.submitLike(3)}>Needs Salt</Button>
          </ButtonGroup>
        </Row>
        <Row>
          {this.props.post.postComment}
        </Row>
        <Row>
          <Form onSubmit={this.submitComment}>
            <Input
              type="textarea"
              placeholder="What do you think about this dish?"
              value={this.state.newComment}
              onChange={this.updateNewComment}
            />
            <Input type="submit" value="Leave Comment" />
          </Form>
        </Row>
        <Row>
          {this.props.post.postYtLink && (
            <YTComponent youtubeLinks={this.props.post.postYtLink} />
          )}
        </Row>
      </>
    );
  }
}
