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
          <CardBody>
          <CardImg></CardImg>
            <CardTitle>{() => {if (this.props.post.title) return this.props.post.title}}</CardTitle>
            {/*Display category_name here*/}
            <CardSubtitle>{() => {if (this.props.post.postCategory) return this.props.post.postCategory}}</CardSubtitle>
            {/*Multiple Cardtexts to be tested if it works*/}
            <CardText>this.props.post.ingredients</CardText>
            <CardText>{() => {if (this.props.post.recipe) return this.props.post.recipe}}</CardText>
            <CardText>{() => {if (this.props.post.postSubmitted) return this.props.post.postSubmitted}}</CardText>
          </CardBody>
        </Card>
        {/*displayYoutube*/}
      </>
    );
  }
}
