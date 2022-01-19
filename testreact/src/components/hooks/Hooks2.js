import React, {useState} from "react";
const Hooks2 =()=>{
    const [name, setName] = useState()('')
    return(
        <div>
            <form>
                <input type='text' value={name}
                       onChange={(e)=> setName(e.target.value)} placeholder='Enter your name'/>
                <p>{name}</p>
            </form>
        </div>
    )
}

export default Hooks2