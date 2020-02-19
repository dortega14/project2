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
import { YTComponent } from "../yt-component/YTComponent"
import { IYoutube } from "../../model/IYoutube";

interface IPostProps {
  post: IPost;
}

export class PostCardComponent extends React.PureComponent<IPostProps> {
  render() {
      /*const displayYoutube: YTComponent = () => {
          if (this.props.post.postYtLink) {
              return (
                <YTComponent youtubeLinks={this.props.post.postYtLink} />
              );
          }
      }*/
    return (
      <>
        <Card>
          <CardImg>{() => {if (this.props.post.image) return this.props.post.image}}</CardImg>
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
        {/*displayYoutube*/}
      </>
    );
  }
}
