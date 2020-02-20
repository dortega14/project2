import { useState } from "react";
import { Form, Input } from "reactstrap";
import { publishPost } from "../../utilities/api";
import React from "react";
import IUser from "../../model/IUser";

interface ISubmitProps {
    currUser: IUser
}

interface ISubmitState {
    image: any,
    ingredients: string,
    recipe: string,
    title: string,
    category: number
}

export class SubmitCardComponent extends React.Component<ISubmitProps, ISubmitState>{
    render() {
    return(
        <Form onSubmit={()=>publishPost({
            image: image,
            ingredients: ingredients,
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
}