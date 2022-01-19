import React, { Component } from 'react'

export default class StateChange extends Component {
    constructor(){
        super();
        this.state={
            value:'Original State'
        };
        this.updateSetState=this.updateSetState.bind(this);
    }
    updateSetState(){
        this.setState({value:'Changed State'});
    }
    render() {
        return (
            <div>
                <h3>{this.state.value}</h3>
                <button onClick={this.updateSetState}>Change State</button>

            </div>
        )
    }
}