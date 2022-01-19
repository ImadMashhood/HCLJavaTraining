import React from 'react';
import {useState,useEffect} from 'react';
import axios from 'axios';

const Data = () => {
    const [post,setPost]=useState({});
    const [id,setId]=useState(1);
    const [idfromBtnClick,setIdFromBtnClick]=useState(1);

    useEffect(()=>{
        axios.get(`https://jsonplaceholder.typicode.com/posts/${id}`).then(res=>{
            console.log(res)
            setPost(res.data)
        }).catch(err=> console.log(err))
    },[idfromBtnClick])
    const handleClick=()=>{
        setIdFromBtnClick(id)
    }

    return (
        <div>
            <input type='text' value={id} onChange={e=>setId(e.target.value) }/>
            <button type='button' onClick={handleClick}>Fetch Data from Post</button>
            <div>{post.body}</div>

        </div>
    )
}

export default Data