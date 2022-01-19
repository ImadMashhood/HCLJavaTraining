import React, {Component} from "react";

export default  class Test2 extends Component{
    constructor() {
        super();
        this.state={color:false}
    }
    render(){
        const colortest=this.state.color?(<div><h2>Test Color</h2></div>):null;
        return(
            <div>
                <h1>Green Text</h1>
                {colortest}
            </div>
        )
    }
}