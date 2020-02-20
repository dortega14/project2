import { useState, SyntheticEvent } from "react";
import { Form, Input } from "reactstrap";
import { publishPost } from "../../utilities/api";
import React from "react";
import IUser from "../../model/IUser";
import { IPost } from "../../model/IPost";

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
    constructor(props: any) {
        super(props);
        this.state = {
            image: null,
            ingredients: "",
            recipe: "",
            title: "",
            category: 0
        };
    }

    updateIngredients = (event: any) => {
        this.setState({
            ...this.state,
            ingredients: event.target.value
        });
    }

    updateImage = (event: any) => {
        this.setState({
            ...this.state,
            image: event.target.value
        });
    }

    updateRecipe = (event: any) => {
        this.setState({
            ...this.state,
            recipe: event.target.value
        });
    }

    updateTitle = (event: any) => {
        this.setState({
            ...this.state,
            title: event.target.value
        });
    }

    updateCategory = (event: any) => {
        this.setState({
            ...this.state,
            category: event.target.value
        });
    }

    submitRecipe = async (event: SyntheticEvent) => {
        event.preventDefault();
        let newPost:IPost = {
            postId: 0,
            title: this.state.title,
            postSubmitted: new Date(),
            //image: this.state.image,
            recipe: this.state.recipe,
            ingredients: this.state.ingredients,
            postCategory: {
                categoryId: this.state.category,
                category: (this.state.category === 1) ? "Breakfast" : ((this.state.category === 2) ? "Lunch" : "Dinner")
            },
            postComment: undefined,
            postUser: this.props.currUser,
            postYtLink: undefined
        };

        publishPost(newPost);
    }

    render() {
    return(
        <Form onSubmit={this.submitRecipe} encType="multipart">
            <Input type="text" placeholder="ingredients"
                onChange={this.updateIngredients}/>
            
            <Input type="text" placeholder="recipe"
                onChange={this.updateRecipe}/>
            
            <Input type="text" placeholder="title"
                onChange={this.updateTitle}/>

            <Input type="select" onChange={this.updateCategory}>
                <option value={1}>Breakfast</option>
                <option value={2}>Lunch</option>
                <option value={3}>Dinner</option>
            </Input>

            <Input type="file" onChange={this.updateImage}>Choose an image!</Input>
                
            <Input type="submit" value="Post Recipe"/>
            
        </Form>
    )
    }
}