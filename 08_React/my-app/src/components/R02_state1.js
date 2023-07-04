import React, { useState } from "react";

const InputTest = () => {

    // 리액트는 컴포넌트의 상태가 변할 때 마다 리렌더링을 수행함

    const[inputValue,setInputValue] = useState("초기값");
    //       변수         함수
    // inputValue : 값을 저장하는 변수
    // setInputValue = inputValue 에 값을 대입하는 setter역할의 함수

    // 첫 렌더링 : value="초기값"
    // -> input의 값을 변경
    //  1) onChange (값이 변했을 때)
    //        -> changeInputValue 함수가 실행되면서
    //           inputValue에 e.target.value(변화된 값) 대입

    // 2) 컴포넌트의 상태 변화 -> 리렌더링 진행
    // 리렌더링 -> value = 변경된 Input의 값

    const changeInputValue = e => {
        console.log(e.target.value);
        setInputValue(e.target.value);
    }

    return (
        // <><input type="text" value={inputValue}  onChange={(e) => {setInputValue(e.target.value)}}/></>
        <><input type="text" value={inputValue}  onChange={changeInputValue}/></>
    );
};

export default InputTest;