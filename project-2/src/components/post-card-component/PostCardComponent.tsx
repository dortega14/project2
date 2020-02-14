import { useState, useEffect } from "react"
import { CardBody, Card } from "reactstrap";
import { publishPost } from "../../utilities/api";
import { IPost } from "../../model/IPost";

export const PostCardComponent:React.FC<any>=(props:any) => {
    const [postStream, setPostStream] = useState([]);
    useEffect(() => {
        publishPost().then(r=>setPostStream(r.data)); 
        
    });

    return (

        <Card>
            {postStream.map((r:IPost)=><CardBody key={r.post_id} post={r}/>)}
        </Card>
    )
}

export default PostCardComponent;