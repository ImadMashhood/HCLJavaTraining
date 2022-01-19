import React from 'react'
import {useState} from "react";
const Hooks = () =>{
    const [name,setName]=useState('Imad')
    const changeName=()=>{
        setName('Mashhood')
    }
    return(
        <div>
            Welcome {name}
            <button onClick={changeName}>Change Name</button>
        </div>
    )
}

export default Hooks