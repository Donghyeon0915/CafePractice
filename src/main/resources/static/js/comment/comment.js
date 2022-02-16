function createdComment(){
    const articleId = document.querySelector('#hidden_article_id').value;
    const nickname = document.querySelector('#hidden_user_nickname').value;
    const content = document.querySelector('#input_comment_content').value;

    if(content == ""){
        alert("댓글을 입력하세요.");
        return;
    }

    const data = {
        articleId: articleId,
        nickname: nickname,
        content: content
    }

    const url = `/api/articles/${articleId}/comments`;

    fetch(url,{
        method: "POST",
        body: JSON.stringify(data),
        headers:{
            "Content-Type" : "application/json"
        }
    }).then(response=>{
        if(response.ok) {
            alert("댓글이 등록 되었습니다.");
            window.location.href = `/articles/${articleId}`;
        }
        else alert("댓글 등록 오류");
    })
}