import React from "react";
import {
  CardBody,
  Card,
  CardText,
  CardSubtitle,
  CardTitle,
  CardImg,
  Button,
  ButtonGroup
} from "reactstrap";
import { IPost } from "../../model/IPost";
import { YTComponent } from "../yt-component/YTComponent"
import { IYoutube } from "../../model/IYoutube";

interface IPostProps {
  post: IPost;
}

export class PostCardComponent extends React.PureComponent<IPostProps> {

    cardTextBuilder() {
        return `Ingredients:  ${this.props.post.ingredients}\n
            Recipe:  ${this.props.post.recipe}\n
            Submitted on: ${this.props.post.postSubmitted}`
    }

  render() {

    return (
      <>
        <Card>
          {/*<CardImg>{() => this.props.post.image && this.props.post.image}</CardImg>*/}
          <CardBody>
            <CardTitle>{this.props.post.title}</CardTitle>
            <CardSubtitle>{this.props.post.postCategory.category}</CardSubtitle>
            <CardText>{this.cardTextBuilder()}</CardText>
          </CardBody>
        </Card>
        {this.props.post.postYtLink && <YTComponent youtubeLinks={this.props.post.postYtLink}/>}
        <ButtonGroup>
            <Button color="success">Tasty</Button>
            <Button color="warning">Looks Good</Button>
            <Button color="danger">Needs Salt</Button>
        </ButtonGroup>
      </>
    );
  }
}
