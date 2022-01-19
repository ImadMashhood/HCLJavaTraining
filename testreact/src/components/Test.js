import React from "react";

const changeNames = () => {
    const names = ["Name 1", "Name 2", "Name 3"];
    const random = Math.floor(Math.random() * 3);
    return names[random];
};

const Test = () => {
    return (
        <>
            <p>{changeNames()}</p>
        </>
    );
};

export default Test;
