import React from 'react';
import { IPost } from "../../model/IPost";
import { CardBody, CardTitle, CardSubtitle, CardText } from 'reactstrap';

export interface IPst{
    post: IPost
}

export const PostRowComponent:React.FC<IPst> = (props:IPst) => {
    return(
        <>
        {/* <tr key={props.post.post_id}>
            <td>
                {props.post.post_id}
            </td>
            <td>
                {props.post.image}
            </td>
            <td>
                {props.post.ingredients}
            </td>
            <td>
                {props.post.submitted}
            </td>
            <td>
                {props.post.recipe}
            </td>
            <td>
                {props.post.title}
            </td>
            <td>
                {props.post.category_post_id}
            </td>
            <td>
                {props.post.post_user_id}
            </td>
        </tr> */}
        <CardBody>
          <CardTitle>{props.post.title}</CardTitle>
          //Display category_name here
          <CardSubtitle>{props.post.category_post_id}</CardSubtitle>
          //Multiple Cardtexts to be tested if it works
          <CardText>{props.post.ingredients}</CardText>
          <CardText>{props.post.recipe}</CardText>
          <CardText>{props.post.submitted}</CardText>
        </CardBody>
        </>
    )
} 

export default PostRowComponent;