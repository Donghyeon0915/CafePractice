
function login(){
    const userId = document.querySelector("#userId");
    const userPw = document.querySelector("#userPassword");

    const userData = {
        userId: userId.value,
        userPw: userPw.value
    };

    console.log("id = " + userData.userId + " pw = " + userData.userPw);

    const url = "/api/user/login";
    fetch(url, {
        method: "POST",
        body: JSON.stringify(userData),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(response => {
        if (response.ok) {
            alert("로그인 성공");
            window.location.href = "/articles";
        } else {
            alert("로그인 실패");
            userId.value = "";
            userPw.value = "";
        }
    });
}

/*const main = {  // jquery를 이용 $ 부분
    login: function (){
        $('#login_input').on("click", function (){
            const userId = document.querySelector("#userId");
            const userPw = document.querySelector("#userPassword");

            const userData = {
                id: userId.value,
                password: userPw.value
            };

            console.log("id = " + userData.id + " pw = " + userData.password);

            const url = "/api/user/login";
            fetch(url, {
                method: "POST",
                body: JSON.stringify(userData),
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(response => {
                if (response.ok) {
                    alert("로그인 성공");
                    window.location.href = "/articles";
                } else {
                    alert("로그인 실패");
                    userId.value = "";
                    userPw.value = "";

                }
            });
        })
    }
}

main.login();*/

