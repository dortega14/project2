import React from 'react';
import { IPost } from "../../model/IPost";
import { CardBody, CardTitle, CardSubtitle, CardText, CardImg } from 'reactstrap';
import { YTComponent } from "../yt-component/YTComponent";

export interface IPst{
    post: IPost
}

export const PostBodyComponent:React.FC<IPst> = (props:IPst) => {
    return(
        <>
          <CardImg>{props.post.image}</CardImg>
          <CardBody>
            <CardTitle>{props.post.title}</CardTitle>
            {/*Display category_name here*/}
            <CardSubtitle>{props.post.postCategory}</CardSubtitle>
            {/*Multiple Cardtexts to be tested if it works*/}
            <CardText>{props.post.ingredients}</CardText>
            <CardText>{props.post.recipe}</CardText>
            <CardText>{props.post.postSubmitted}</CardText>
          </CardBody>
          {/*Somehow, youtube*/}
        </>
    )
} 

export default PostBodyComponent;