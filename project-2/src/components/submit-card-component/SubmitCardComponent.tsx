import { useState } from "react";
import { Form, Input } from "reactstrap";
import { publishPost } from "../../utilities/api";
import React from "react";

export const SubmitCardComponent:React.FC<any> = (props:any)=>{
    const [image, setImage] = useState();
    const [ingredients, setIngredients] = useState("");
    const [submitted, setSubmitted] = useState("");
    const [recipe, setRecipe] = useState("");
    const [title, setTitle] = useState("");
    const [category_post_id, setCategory_post_id] = useState(0);
    const [post_user_id, setPost_user_id] = useState(0);
    return(
        <Form onSubmit={()=>publishPost({
            post_id:0,
            image: image,
            ingredients: ingredients,
            submitted: submitted,
            recipe: recipe,
            title: title,
            category_post_id: category_post_id,
            post_user_id: post_user_id
        }).then(r=>console.log(r.data))}>
            <Input type="text" placeholder="ingredients"
                onChange={val=>setIngredients(val.target.value)}/>
            
            <Input type="text" placeholder="submitted"
                onChange={val=>setSubmitted(val.target.value)}/>
            
            <Input type="text" placeholder="recipe"
                onChange={val=>setSubmitted(val.target.value)}/>
            
            <Input type="text" placeholder="title"
                onChange={val=>setSubmitted(val.target.value)}/>
                
            <Input type="submit" value="Post Recipe"/>
            
        </Form>
    )
}
export default SubmitCardComponent;