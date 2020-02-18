import { useState, useEffect } from "react"
import { CardBody, Card } from "reactstrap";
import { getList } from "../../utilities/api";
import { IPost } from "../../model/IPost";
import React from "react";

export const PostCardComponent:React.FC<any>=(props:any) => {
    const [postStream, setPostStream] = useState([]);
    useEffect(() => {
        getList().then(r=>setPostStream(r.data)); 
        
    });

    return (

        <Card>
            {postStream.map((r:IPost)=><CardBody key={r.post_id} post={r}/>)}
        </Card>
    )
}

export default PostCardComponent;