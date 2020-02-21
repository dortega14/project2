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
import { hitLike } from "../../utilities/api";
import { ILike } from "../../model/ILike";

interface IPostProps {
  post: IPost,
  currUser: IUser,
  parent: string
}

export class PostCardComponent extends React.PureComponent<IPostProps> {
  cardTextBuilder() {
    return `Ingredients:  ${this.props.post.ingredients}\n\r
            Recipe:  ${this.props.post.recipe}\n\r
            Submitted on: ${new Date(this.props.post.postSubmitted)} by ${this.props.post.postUser.firstName}`;
  }

  submitComment(event:SyntheticEvent) {
    event.preventDefault();
    console.log("submitted comment");
  }

  submitLike(type:number) {
    let like:ILike = {
      likeUser: this.props.currUser.username,
      likePost: this.props.post.postId,
      likeLikeType: type
    }
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
            <Button color="success" size="sm" onClick={() => this.submitLike(1)}>Tasty</Button>
            <Button color="warning" size="sm" onClick={() => this.submitLike(2)}>Looks Good</Button>
            <Button color="danger" size="sm" onClick={() => this.submitLike(3)}>Needs Salt</Button>
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
