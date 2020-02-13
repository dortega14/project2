import { useState } from "react"
import { CardBody, Card } from "reactstrap";
import { publishPost } from "../../utilities/api";


export const PostCardComponent:React.FC<any>=(props:any) => {
    const [postStream, setPostStream] = useState([]);
    useEffect(() => {
        publishPost().then(r=>setPostStream(r.data)); 
        
        
    });

    return (

        <Card>
            {postStream.map(r=><CardBody post={r}/>)}
        </Card>
    )
}

export default PostCardComponent;