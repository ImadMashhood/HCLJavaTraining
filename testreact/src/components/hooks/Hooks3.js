import React, {useEffect} from "react";
import {useState} from "react";

const Hooks3 =()=>{
    const [count, setCount] = useState(0)
    useEffect(()=>{console.log(`You have clicked Button A ${count} times`)})
    const [count1, setCount1] = useState(0)
    useEffect(()=>{console.log(`You have clicked Button B ${count1} times`)})
    return(
        <div>
            <button onClick={()=>setCount(count+1)}>Button A</button>
            <button onClick={()=>setCount1(count+1)}>Button B</button>
        </div>
    )
}

export default Hooks3