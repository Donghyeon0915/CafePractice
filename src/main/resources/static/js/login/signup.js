function signup(){
    const userNickname = document.querySelector("#sign_up_nickname");
    const userId = document.querySelector("#sign_up_id");
    const userPw = document.querySelector("#sign_up_password");

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