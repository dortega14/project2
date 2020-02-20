import { useState } from "react";
import { Form, Input } from "reactstrap";
import { publishPost } from "../../utilities/api";
import React from "react";
import IUser from "../../model/IUser";

interface ISubmitProps {
    currUser: IUser
}

export const SubmitCardComponent:React.FC<any> = (props:ISubmitProps)=>{
    const [image, setImage] = useState();
    const [ingredients, setIngredients] = useState("");
    const [postSubmitted, setPostSubmitted] = useState("");
    const [recipe, setRecipe] = useState("");
    const [title, setTitle] = useState("");
    const [postCategory, setPostCategory] = useState(0);
    const [postUser, setPostUser] = useState(props.currUser);
    const [postYtLink, setPostYtLink] = useState({ytLink: "", startTime: 0})
    return(
        <Form onSubmit={()=>publishPost({
            postId:0,
            image: image,
            ingredients: ingredients,
            postSubmitted: new Date(),
            recipe: recipe,
            title: title,
            postCategory: {categoryId: postCategory},
            postUser: postUser,
            postYtLink: {
                ytlink: "",
                time: 0
            }
        }).then(r=>console.log(r.data))}>
            <Input type="text" placeholder="ingredients"
                onChange={val=>setIngredients(val.target.value)}/>
            
            <Input type="text" placeholder="recipe"
                onChange={val=>setRecipe(val.target.value)}/>
            
            <Input type="text" placeholder="title"
                onChange={val=>setTitle(val.target.value)}/>
                
            <Input type="submit" value="Post Recipe"/>
            
        </Form>
    )
}
export default SubmitCardComponent;