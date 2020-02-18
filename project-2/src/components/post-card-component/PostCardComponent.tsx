import React from "react";
import {
  CardBody,
  Card,
  CardText,
  CardSubtitle,
  CardTitle,
  CardImg
} from "reactstrap";
import { IPost } from "../../model/IPost";
import { YouTubeComponent } from "../youtube-component/YouTubeComponent"
import { IYoutube } from "../../model/IYoutube";

interface IPostProps {
  post: IPost;
}

export class PostCardComponent extends React.PureComponent<IPostProps> {
  render() {
      const displayYoutube: YouTubeComponent = () => {
          if (this.props.post.yt) {
              return (
                <YouTubeComponent youtubeLinks={this.props.post.yt} />
              );
          }
      }
    return (
      <>
        <Card>
          <CardImg>{this.props.post.image}</CardImg>
          <CardBody>
            <CardTitle>{this.props.post.title}</CardTitle>
            {/*Display category_name here*/}
            <CardSubtitle>{this.props.post.postCategory}</CardSubtitle>
            {/*Multiple Cardtexts to be tested if it works*/}
            <CardText>{this.props.post.ingredients}</CardText>
            <CardText>{this.props.post.recipe}</CardText>
            <CardText>{this.props.post.postSubmitted}</CardText>
          </CardBody>
        </Card>
      </>
    );
  }
}
