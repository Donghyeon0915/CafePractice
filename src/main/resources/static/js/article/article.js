function createArticle(){
    const nickname = document.querySelector("#new_article_author").value;
    const title = document.querySelector("#new_article_title").value;
    const content = document.querySelector("#new_article_content").value;

    const data = {
        author: nickname,
        title: title,
        content: content
    };

    console.log(data);

    const url = '/api/articles/new';
    fetch(url, {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(response => {
        if(response.ok) {
            alert("게시글이 등록 되었습니다.");
            window.location.reload();
        }
        else {
            alert("게시글 등록 실패");
        }
    });
}

function viewArticle(){

    const data = {
        articleId: document.querySelector("#article_id").value,
        userNickname: document.querySelector("#user_nickname").value
    };

    const url = "/articles/view";
    fetch(url, {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(response =>{
       if(response.ok) alert("게시글 조회 성공");
       else alert("게시글 조회 실패");
    });
}