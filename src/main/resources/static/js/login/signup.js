function changeMode(){
    const title = document.querySelector('#login_title');
    const nickname = document.querySelector('#userNickname');
    const loginBtn = document.querySelector('#login_input');
    const signUpBtn = document.querySelector('#sign_up_btn');
    const buttonText = document.querySelector('#custom_btn');

    if(title.innerHTML == "Welcome"){
        title.innerHTML = "Sign Up";
        buttonText.innerHTML = "Back To Login";

        loginBtn.classList.toggle('invisible');
        signUpBtn.classList.toggle('invisible');
        nickname.classList.toggle('invisible');
    }
    else{
        window.location.reload();
    }

}

function signUp(){
    const userNickname = document.querySelector("#userNickname");
    const userId = document.querySelector("#userId");
    const userPw = document.querySelector("#userPassword");

    const data = {
        nickname: userNickname.value,
        id: userId.value,
        password: userPw.value
    };

    const url = "api/user/signup";
    fetch(url, {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }

    }).then(response => {
        if(response.ok){
            alert("회원가입 완료");
            window.location.href = "/";
        }else{
            alert("회원가입 실패");
        }
    });
}